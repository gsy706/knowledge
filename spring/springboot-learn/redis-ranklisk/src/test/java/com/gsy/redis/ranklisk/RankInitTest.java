/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.redis.ranklisk;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-07-20
 */
public class RankInitTest {

    private Random random;
    private RestTemplate restTemplate;

    @Before
    public void init() {
        random = new Random();
        restTemplate = new RestTemplate();
    }

    private int getUsetId() {
        return random.nextInt(1024);
    }

    private double getScore() {
        return random.nextDouble() * 100;
    }

    @Test
    public void testInitRank() {
        try {
            for (int i = 0; i < 30; i++) {
                restTemplate.getForObject("http://localhost:9533/update?userId=" + getUsetId()
                + "&score=" + getScore(), String.class);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
