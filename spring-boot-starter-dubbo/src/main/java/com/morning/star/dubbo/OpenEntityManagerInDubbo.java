package com.morning.star.dubbo;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.jpa.EntityManagerFactoryAccessor;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.orm.jpa.EntityManagerHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Aspect
@Order(0)
public class OpenEntityManagerInDubbo extends EntityManagerFactoryAccessor {
    
    private ThreadLocal<Integer> counter = new ThreadLocal<>();
    
    @Pointcut("execution(public * com.morning.star..*.*Application.*(..)) || "
            + "execution(public * com.morning.star..*.*Facade.*(..))")
    public void dubboPointCut() {}
    
    
    @Before("dubboPointCut()")
    public void before() throws Throwable {
        System.out.println("========================before");
        if (TransactionSynchronizationManager.hasResource(getEntityManagerFactory())) {
            incrementCounter();
        }
        else {
            try {
                System.out.println("========================bindResource");
                EntityManager em = createEntityManager();
                EntityManagerHolder emHolder = new EntityManagerHolder(em);
                TransactionSynchronizationManager.bindResource(getEntityManagerFactory(), emHolder);
                System.out.println("a:" + TransactionSynchronizationManager.hasResource(getEntityManagerFactory()));
            }
            catch (PersistenceException ex) {
                throw new DataAccessResourceFailureException("Could not create JPA EntityManager", ex);
            }
        }
    }

    @After("dubboPointCut()")
    public void afterCompletion() throws Throwable {
        System.out.println("========================afterCompletion");
        if(!decrementCounter()) {
            System.out.println("b:" + TransactionSynchronizationManager.hasResource(getEntityManagerFactory()));
            if (TransactionSynchronizationManager.hasResource(getEntityManagerFactory())) {
                System.out.println("========================unbindResource");
                EntityManagerHolder emHolder = (EntityManagerHolder)
                        TransactionSynchronizationManager.unbindResource(getEntityManagerFactory());
                System.out.println("========================closeEntityManager:" + emHolder.getEntityManager().isOpen());
                EntityManagerFactoryUtils.closeEntityManager(emHolder.getEntityManager());
                System.out.println("========================closeEntityManager:" + emHolder.getEntityManager().isOpen());
            }
        }
    }

    
    private void incrementCounter() {
        Integer count = counter.get();
        counter.set(count == null ? 1 : count + 1);
    }
    
    private boolean decrementCounter() {
        Integer count = counter.get();
        if (count == null) {
            return false;
        }
        // Do not modify the Session: just clear the marker.
        if (count > 1) {
            counter.set(count - 1);
        }
        else {
            counter.remove();
        }
        return true;
    }
}
