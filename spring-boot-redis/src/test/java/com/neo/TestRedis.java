package com.neo;

import com.neo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
	@Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }
    
    @Test
    public void testObj() throws Exception {
        User user=new User("aa@126.com", "aa", "aa123456", "aa","123");
        ValueOperations<String, User> operations=redisTemplate.opsForValue();
        operations.set("com.neox", user);
        operations.set("com.neo.f", user,1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists=redisTemplate.hasKey("com.neo.f");
        if(exists){
        	System.out.println("exists is true");
        }else{
        	System.out.println("exists is false");
        	System.out.println("exists is false");
        	System.out.println("exists is false");
        	System.out.println("exists is false");
        	System.out.println("exists is false");
        	System.out.println("exists is false");
        	System.out.println("exists is false 这里就是一些修改，我可以这样实现，加油你好");
            System.out.println("其实你不要想那么多努力学习就好了，就是这样的加油吧，不为别人就为了你的父母和自己生活好一点，不要想太多了，你肯定是加油你自己是没有其他优势的，相信自己");
        }
       // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }
}