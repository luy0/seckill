package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {
    /**
     * Insert purchase information, avoiding duplicates
     * @param seckilledId
     * @param userPhone
     * @return
     * if >= 1, insert successfully
     */
    int insertSuccessKilled(@Param("seckilledId") long seckilledId, @Param("userPhone") long userPhone);

    /**
     * According to Id, search successKilled and get seckill object
     * @param seckilledId
     * @param userPhone
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckilledId") long seckilledId, @Param("userPhone") long userPhone);
}
