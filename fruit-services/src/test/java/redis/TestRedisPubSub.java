package redis;

import org.junit.Test;
import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * Created by liuzhi on 2016/7/12.
 */

public class TestRedisPubSub extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {
        System.out.println("message:"+message);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println("onPMessage: channel["+channel+"], message["+message+"]");
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("onSubscribe: channel["+channel+"],"+ "subscribedChannels["+subscribedChannels+"]");
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("onUnsubscribe: channel["+channel+"], "+ "subscribedChannels["+subscribedChannels+"]");
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPUnsubscribe: pattern["+pattern+"],"+   "subscribedChannels["+subscribedChannels+"]");
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPSubscribe: pattern["+pattern+"], "+ "subscribedChannels["+subscribedChannels+"]");
    }
    @Test
    public void testRedis(){
        Jedis jedis = new Jedis("data.redis.univpl.com",6379,0);
        Client client = jedis.getClient();
        TestRedisPubSub testRedisPub = new TestRedisPubSub();
        testRedisPub.proceed(client,"liuZhi","liuZhi001");
        jedis.disconnect();
    }
}
