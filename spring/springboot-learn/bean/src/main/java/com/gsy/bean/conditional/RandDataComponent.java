/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.conditional;

import java.util.function.Supplier;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-10
 */
public class RandDataComponent<T> {

    private Supplier<T> rand;

    public RandDataComponent(Supplier<T> rand) {
        this.rand = rand;
    }

    public T rand() {
        return rand.get();
    }

}
