package com.chudichen.spring.circle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chudichen
 * @date 2020-09-08
 */
@Component
public class BeanA {

	@Autowired
	private BeanB beanB;
}
