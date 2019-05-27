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
public class ZhangSan extends HumanWithCar {

    public ZhangSan(Car car) {
        super(car);
    }

    @Override
    public void goHome() {
        car.start();
        car.turnLeft();
        car.turnRight();
        car.stop();
    }
}
