/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.conditional;

import com.gsy.bean.conditional.condition.ScanDemoCondition;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * 自动扫描Bean的条件加载
 *
 * @author: gusiyuan
 * @date: 2019-06-10
 */
@Component
@Conditional(ScanDemoCondition.class)
public class ScanDemoBean {

    @Value("${conditional.demo.load}")
    private boolean load;

    public boolean getLoad(){
        return load;
    }

}
