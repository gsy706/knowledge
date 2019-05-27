/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo.humen;

import com.spring.demo.car.Car;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-05-27
 */
public abstract class HumanWithCar implements Humen{

    public Car car;

    public HumanWithCar(Car car) {
        this.car = car;
    }

    @Override
    public abstract void goHome();
}
