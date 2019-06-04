/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-04
 */
@Data
@Component
@ConfigurationProperties(prefix = "app.proper")
public class ProperBean {

    private String key;
    private Integer id;
    private String value;

}
