/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.redis.ranklisk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-07-20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rank implements Serializable {

    /**
     * 用户在排行榜上的排名
     */
    private Long rank;

    /**
     * 用户的历史最高积分，也就是排行榜上的积分
     */
    private Float score;

    /**
     * 用户id
     */
    private Long userId;

}
