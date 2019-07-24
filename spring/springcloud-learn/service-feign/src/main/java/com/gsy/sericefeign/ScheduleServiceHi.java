/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.sericefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-07-24
 */
@FeignClient(value = "service-hi",fallback = ScheduleServiceHiHystrix.class)
public interface ScheduleServiceHi {

    @GetMapping("/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
