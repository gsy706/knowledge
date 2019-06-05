/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-05
 */
@Data
@RefreshScope
@Component
public class ValueConfig {

    @Value("${rest.uuid}")
    private String uuid;

}
