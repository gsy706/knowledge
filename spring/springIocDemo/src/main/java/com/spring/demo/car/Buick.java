/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo.car;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-05-27
 */
public class Buick implements Car{


    @Override
    public void start() {
        System.out.println("Buick.start");
    }

    @Override
    public void turnLeft() {
        System.out.println("Buick.turnLeft");
    }

    @Override
    public void turnRight() {
        System.out.println("Buick.turnRight");
    }

    @Override
    public void stop() {
        System.out.println("Buick.stop");
    }

}
