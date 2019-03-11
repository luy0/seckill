package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 *  spring and junit  integration, loading SpringIOC container when junit start
 */
@RunWith(SpringJUnit4ClassRunner.class)
//provide junit with spring docs
@ContextConfiguration("classpath:spring/spring-dao.xml")

public class SuccessKilledDaoTest {
    //loading Dao implement class
    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() {
        int insertTimes = successKilledDao.insertSuccessKilled(1000L, 12300001000L);
        System.out.println("insertCount = " + insertTimes);

        /**
         * 1st: insertCount = 1
         * 2nd: insertCount = 0 because it is a duplicate for the same union key
         */

    }

    @Test
    public void queryByIdWithSeckill() {
        long id = 1000L;
        long userPhone = 12300001000L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, userPhone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());

        /**
         *SuccessKilled{seckillId=1000, userPhone=12300001000, state=1, creatTime=null,
         * seckill=Seckill{seckillId=1000, name='$400 get iphone8', number=400, createTime=Sun Mar 10 22:57:25 EDT 2019,
         * startTime=Mon Apr 01 00:00:00 EDT 2019, endTime=Tue Apr 02 00:00:00 EDT 2019}}
         *
         * Seckill{seckillId=1000, name='$400 get iphone8', number=400, createTime=Sun Mar 10 22:57:25 EDT 2019,
         * startTime=Mon Apr 01 00:00:00 EDT 2019, endTime=Tue Apr 02 00:00:00 EDT 2019}
         */
    }
}