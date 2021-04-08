package com.chu.stereotype;

import java.lang.annotation.*;

/**
 * @author chudichen
 * @date 2021-04-01
 */
@Indexed
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

	String value() default "";
}
