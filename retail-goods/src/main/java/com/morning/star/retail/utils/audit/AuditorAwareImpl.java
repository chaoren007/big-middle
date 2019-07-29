package com.morning.star.retail.utils.audit;

import com.morning.star.retail.user.UserInfo;
import com.morning.star.retail.user.UserUtils;
import org.springframework.data.domain.AuditorAware;


public class AuditorAwareImpl implements AuditorAware<Operator> {

    @Override
    public Operator getCurrentAuditor() {
        UserInfo user = UserUtils.currentUser();
        if(user == null) {
            return null;
        }
        Operator op = new Operator();
        op.setOperatorId(user.getId());
        op.setOperatorName(user.getName());
        return op;
    }

}
