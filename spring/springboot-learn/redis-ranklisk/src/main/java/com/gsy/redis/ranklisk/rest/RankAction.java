/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.gsy.redis.ranklisk.rest;

import com.gsy.redis.ranklisk.component.RankListComponent;
import com.gsy.redis.ranklisk.entity.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * TODO
 *
 * @author: gusiyuan
 * @date: 2019-07-20
 */
@RestController
public class RankAction {

    @Autowired
    private RankListComponent rankListComponent;

    @GetMapping(path = "/topn")
    public List<Rank> showTopN(int n) {
        return rankListComponent.getTopNRanks(n);
    }

    @GetMapping(path = "/update")
    public Rank updateScore(long userId, float score) {
        return rankListComponent.updateRank(userId, score);
    }

    @GetMapping(path = "/rank")
    public Rank queryRank(long userId) {
        return rankListComponent.getRank(userId);
    }

    @GetMapping(path = "/around")
    public List<Rank> around(long userId, int n) {
        return rankListComponent.getRankAroundUser(userId, n);
    }

}
