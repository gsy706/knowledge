/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.conditional;

import com.gsy.bean.conditional.condition.RandBooleanCondition;
import com.gsy.bean.conditional.condition.RandIntCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-10
 */
@Configuration
public class ConditionalAutoConfig {

    @Bean
    @Conditional(RandIntCondition.class)
    public RandDataComponent<Integer> randIntComponent() {
        return new RandDataComponent<>(() -> {
            Random random = new Random();
            return random.nextInt();
        });
    }

    @Bean
    @Conditional(RandBooleanCondition.class)
    public RandDataComponent<Boolean> randBooleanComponent() {
        return new RandDataComponent<>(() -> {
            Random random = new Random();
            return random.nextBoolean();
        });
    }

}
