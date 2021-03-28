package test;

import jdk.nashorn.internal.ir.CallNode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-23 21:45
 **/
@Slf4j
public class CacheUtil {

    private static Logger logger = LoggerFactory.getLogger(CacheUtil.class);
    private static final ConcurrentMap<String, Future<String>> cache = new ConcurrentHashMap<>();

    public static String getByKey(String key) {
        Future<String> future = cache.get(key);
        if (future == null) {
            return null;
        }
        try {
            return future.get();
        } catch (Exception e) {
            logger.info("getByKey() error:{}",e.getMessage());
        }
        return null;
    }

    /**
     * 存入缓存
     *
     * @param key
     * @param val
     * @return
     */
    public static String putIntoCache(String key, String val) {
        Future<String> future = cache.get(key);
        if (future == null) {
            Callable<String> callable = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return new String(val);
                }
            };
            FutureTask<String> task = new FutureTask<>(callable);
            future = cache.putIfAbsent(key, task);
            if (future == null) {
                future = task;
                task.run();
            }
        }
        try {
            return future.get();
        } catch (Exception e) {
            cache.remove(key);
            logger.error("putIntoCache error:{}", e.getMessage());
        }
        return null;
    }


}
