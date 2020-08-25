package com.chudichen.spring.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author chudichen
 * @date 2020-08-04
 */
@Component
public class UserFactoryBean implements FactoryBean<User> {

	@Override
	public User getObject() throws Exception {
		return new User("Tom");
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
