/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.bean.choose.sameClz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-12
 */
@Slf4j
@Component
@Primary
public class LogPrint implements IPrint {

    @Override
    public void print(String msg) {
        log.info("log print: {}", msg);
    }
}
