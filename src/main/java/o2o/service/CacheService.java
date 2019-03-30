package o2o.service;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-03-23 17:00
 */
public interface CacheService {
    /*
     *根据key前缀删除所有该匹配模式下的key-value
     */
    void removeFromCache(String keyPrefix);
}
