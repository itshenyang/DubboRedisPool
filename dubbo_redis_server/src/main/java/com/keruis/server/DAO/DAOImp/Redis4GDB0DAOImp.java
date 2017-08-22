package com.keruis.server.DAO.DAOImp;

import com.keruis.DAO.Redis4GDB0DAO;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

/**
 * Created by Administrator on 2017/8/21.
 */
public class Redis4GDB0DAOImp implements Redis4GDB0DAO {


    private JedisPool jedisPool = getJedisPool();
    private final String host = "r-bp1ccc550a077d94.redis.rds.aliyuncs.com";
    private final String pwd = "So0pLi8y7M";


    public JedisPool getJedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        //最大连接数, 应用自己评估，不要超过AliCloudDB for Redis每个实例最大的连接数
        config.setMaxIdle(20);
        config.setMinIdle(10);
        config.setMaxTotal(300);
        config.setMinEvictableIdleTimeMillis(1800000);
        config.setSoftMinEvictableIdleTimeMillis(1800000);
        config.setTestOnBorrow(true);
        JedisPool pool = new JedisPool(config, host, 6379, Protocol.DEFAULT_TIMEOUT, pwd);
        return pool;
    }

    public Jedis getJedis() {
        return jedisPool.getResource();
    }
}
