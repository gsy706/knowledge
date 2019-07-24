/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.sericefeign;

import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-07-24
 */
@Component
public class ScheduleServiceHiHystrix implements ScheduleServiceHi{

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
