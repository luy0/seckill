package org.seckill.dao;

import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

public interface SeckillDao {
    /**
     * reduce item in the stock
     * @param: seckillId
     * @param: killTime //createTime in database
     * @return //if > 1, update successfully
     */
    int reduceNumber(long seckillId, Date killTIme);

    /**
     * According to seckillId, search seckill item
     * @param: seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * According to offset, search seckill item list
     * @param: offset
     * @param: limit
     * @return
     */
    List<Seckill> queryAll(int offset, int limit);
}
