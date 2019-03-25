package com.bizvane.mktcenterservice.common.locktools;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * @Author: lijunwei
 * @Time: 2018/12/9 13:15
 */
public interface DistributedLocker {
    RLock lock(String lockKey);

    RLock lock(String lockKey, long timeout);

    RLock lock(String lockKey, TimeUnit unit, long timeout);

    boolean tryLock(String lockKey, TimeUnit unit, long waitTime, long leaseTime);

    void unlock(String lockKey);

    void unlock(RLock lock);

}
