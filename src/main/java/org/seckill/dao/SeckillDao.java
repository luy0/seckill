package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

public interface SeckillDao {
    /**
     * reduce item in stock
     * @param seckillId
     * @param killTime
     * @return
     * if > 1, update successfully
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * According to seckillId, search seckill item
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * According to offset, search seckill item list
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
