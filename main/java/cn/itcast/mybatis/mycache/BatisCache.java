package cn.itcast.mybatis.mycache;

import org.apache.ibatis.cache.Cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BatisCache implements Cache{


    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private ConcurrentHashMap<Object,Object> cache = new ConcurrentHashMap<Object,Object>();
    private String id;


    public BatisCache(){

        System.out.println("初始化-1！");
    }


    //必须有该构造函数
    public BatisCache(String id){
        System.out.println("初始化-2！");
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {

    }

    @Override
    public Object getObject(Object key) {
        return lock;
    }

    @Override
    public Object removeObject(Object key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
