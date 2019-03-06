package org.seckill.dao;


import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {
    /**
     * Insert purchase information, avoiding duplicates
     * @param: seckillId
     * @param: userPhone
     * @return //if >= 1, insert successfully
     */
    int insertSuccessKilled(long seckillId, long userPhone);

    /**
     * According to Id, search successKilled and get seckill object
     * @param: seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(long seckillId);

}
