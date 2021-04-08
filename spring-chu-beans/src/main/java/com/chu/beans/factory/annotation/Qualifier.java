package com.chu.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @author chudichen
 * @date 2021-04-01
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Inherited
@Documented
public @interface Qualifier {
}
