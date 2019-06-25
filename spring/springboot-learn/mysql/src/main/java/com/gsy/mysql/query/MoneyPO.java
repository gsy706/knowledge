/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.mysql.query;

import lombok.Data;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-06-25
 */
@Data
public class MoneyPO {

    private Integer id;
    private String name;
    private Integer money;
    private boolean isDeleted;
    private Long created;
    private Long updated;

}
