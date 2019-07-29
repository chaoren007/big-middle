package com.morning.star.retail.admin.utils.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;

import com.morning.star.retail.user.UserInfo;
import com.morning.star.retail.user.UserUtils;

public class AuditorAwareImpl implements AuditorAware<Operator> {
	private Logger logger = LoggerFactory.getLogger(AuditorAwareImpl.class);

	@Override
	public Operator getCurrentAuditor() {
		UserInfo user = UserUtils.currentUser();
		logger.info("Operator=====================:" + (user != null));
		if (user == null) {
			return null;
		}
		Operator op = new Operator();
		op.setOperatorId(user.getId());
		op.setOperatorName(user.getName());
		return op;
	}

}
