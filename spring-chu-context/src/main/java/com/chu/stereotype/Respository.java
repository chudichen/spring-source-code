package com.chu.stereotype;

import java.lang.annotation.*;

/**
 * @author chudichen
 * @date 2021-04-01
 */
@Component
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Respository {

	String value() default "";
}
