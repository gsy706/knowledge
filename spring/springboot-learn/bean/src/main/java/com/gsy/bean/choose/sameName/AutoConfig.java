/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.choose.sameName;

import com.gsy.bean.choose.sameName.a.SameA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-12
 */
@Configuration
public class AutoConfig {

    @Bean
    public SameA mySameA(){
        return new SameA();
    }

}
