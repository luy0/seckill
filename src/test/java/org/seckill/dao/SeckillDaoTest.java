package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;

import java.util.Date;
import java.util.List;


import static org.junit.Assert.*;


/**
 * spring and junit integration，start junit with SpringIOC container
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")

public class SeckillDaoTest {
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void queryById() throws Exception{
        long id =1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);

        /**
         *$400 get iphone8
         * Seckill{seckillId=1000, name='$400 get iphone8', number=400, createTime=Sun Mar 10 22:57:25 EDT 2019,
         * startTime=Mon Apr 01 00:00:00 EDT 2019, endTime=Tue Apr 02 00:00:00 EDT 2019}
         */
    }

    @Test
    public void queryAll() {
        List<Seckill> seckills = seckillDao.queryAll(0,100);
        for(Seckill seckill : seckills){
            System.out.println(seckill.getName());
            System.out.println(seckill);
        }

        /**
         *$400 get iphone8
         * Seckill{seckillId=1000, name='$400 get iphone8', number=400, createTime=Sun Mar 10 22:57:25 EDT 2019,
         * startTime=Mon Apr 01 00:00:00 EDT 2019, endTime=Tue Apr 02 00:00:00 EDT 2019}
         *
         * $700 get iphoneX
         * Seckill{seckillId=1001, name='$700 get iphoneX', number=300, createTime=Sun Mar 10 22:57:25 EDT 2019,
         * startTime=Mon Apr 01 00:00:00 EDT 2019, endTime=Tue Apr 02 00:00:00 EDT 2019}
         *
         * $1100 get MacBook
         * Seckill{seckillId=1002, name='$1100 get MacBook', number=200, createTime=Sun Mar 10 22:57:25 EDT 2019,
         * startTime=Mon Apr 01 00:00:00 EDT 2019, endTime=Tue Apr 02 00:00:00 EDT 2019}
         *
         * $1500 get MacBookPro
         * Seckill{seckillId=1003, name='$1500 get MacBookPro', number=100, createTime=Sun Mar 10 22:57:25 EDT 2019,
         * startTime=Mon Apr 01 00:00:00 EDT 2019, endTime=Tue Apr 02 00:00:00 EDT 2019}
         */
    }

    @Test
    public void reduceNumber() {
        Date killTime = new Date();
        System.out.println("updatedCount = " + seckillDao.reduceNumber(1000, killTime));

        /**
         * UPDATE seckill SET number = number-1 WHERE seckill_id=? AND start_time <= ? AND end_time >= ? AND number > 0;
         * Parameters: 1000(Long), 2019-03-11 02:28:04.514(Timestamp), 2019-03-11 02:28:04.514(Timestamp)
         * Updates: 0 because start _time is set on 4/1
         */
    }

}