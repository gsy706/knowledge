/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo;

import com.spring.demo.car.Audi;
import com.spring.demo.car.Buick;
import com.spring.demo.humen.Humen;
import com.spring.demo.humen.LiSi;
import com.spring.demo.humen.ZhangSan;
import com.spring.demo.ioc.IocContainer;
import org.junit.Before;
import org.junit.Test;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-05-27
 */
public class SpringIocDemoTest {

    private IocContainer iocContainer = new IocContainer();

    @Before
    public void before(){
        iocContainer.setBean(Audi.class, "audi");
        iocContainer.setBean(Buick.class, "buick");
        iocContainer.setBean(ZhangSan.class, "zhangsan", "audi");
        iocContainer.setBean(LiSi.class, "lisi", "buick");
    }

    @Test
    public void test(){
        Humen zhangsan = (Humen) iocContainer.getBean("zhangsan");
        zhangsan.goHome();
        Humen lisi = (Humen) iocContainer.getBean("lisi");
        lisi.goHome();
    }

}
