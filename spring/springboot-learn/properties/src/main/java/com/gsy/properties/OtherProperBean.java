/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-05
 */
@Data
@Configuration
@PropertySource("classpath:biz.properties")
@ConfigurationProperties(prefix = "biz")
public class OtherProperBean {

    private String token;
    private String appKey;
    private Integer appVersion;
    private String source;
    private String uuid;

}
