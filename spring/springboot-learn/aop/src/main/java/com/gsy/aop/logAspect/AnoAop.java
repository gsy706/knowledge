/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.aop.logAspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-24
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnoAop {

}
