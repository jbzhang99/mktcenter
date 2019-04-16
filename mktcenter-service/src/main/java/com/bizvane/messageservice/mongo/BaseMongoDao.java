package com.bizvane.messageservice.mongo;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import com.aliyun.openservices.shade.com.alibaba.fastjson.JSONObject;
import com.bizvane.messageservice.common.utils.PageForm;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BaseMongoDao<T>
{
  protected Class<T> entityClass;
  @Autowired
  protected MongoTemplate mongoTemplate;
  
  protected Class<T> getEntityClass()
  {
    if (this.entityClass == null) {
      this.entityClass = ((Class)((java.lang.reflect.ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
    return this.entityClass;
  }
  
  protected List<T> find(Query query)
  {
    return this.mongoTemplate.find(query, getEntityClass());
  }
  
  protected List<T> find(Query query, String collectionName)
  {
    return this.mongoTemplate.find(query, getEntityClass(), collectionName);
  }
  
  protected T findOne(Query query)
  {
    return this.mongoTemplate.findOne(query, getEntityClass());
  }
  
  protected T findOne(Query query, String collectionName)
  {
    return this.mongoTemplate.findOne(query, getEntityClass(), collectionName);
  }
  
  protected void update(Query query, Update update)
  {
    this.mongoTemplate.findAndModify(query, update, getEntityClass());
  }
  
  protected void update(Query query, T entity)
  {
    Update update = new Update();
    
    JSONObject entityJson = JSON.parseObject(JSON.toJSONString(entity));
    
    Iterator<String> iterator = entityJson.keySet().iterator();
    while (iterator.hasNext()){
        String key = (String) iterator.next();
        Object value = entityJson.get(key);
        
        if(key.equals("updateDate")||key.equals("createDate")) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long lt = new Long((long) value);
            Date date = new Date(lt);
            update.set(key, date);
        }else {
        	update.set(key, value);
        }

    }
    
    this.mongoTemplate.findAndModify(query, update, getEntityClass());
  }
  
  protected void update(Query query, Update update, String collectionName)
  {
    this.mongoTemplate.findAndModify(query, update, getEntityClass(), collectionName);
  }
  
  protected T insert(T entity)
  {
    this.mongoTemplate.insert(entity);
    return entity;
  }
  
  protected T insert(T entity, String collectionName)
  {
    this.mongoTemplate.insert(entity, collectionName);
    return entity;
  }
  
  protected T save(T entity)
  {
    this.mongoTemplate.save(entity);
    return entity;
  }
  
  protected T save(T entity, String collectionName)
  {
    this.mongoTemplate.save(entity, collectionName);
    return entity;
  }
  
  protected void batchSave(Collection<T> entitys)
  {
    this.mongoTemplate.insert(entitys, getEntityClass());
  }
  
  protected void batchSave(Collection<T> entitys, String collectionName)
  {
    this.mongoTemplate.insert(entitys, getEntityClass());
  }
  
  protected T delete(T entity)
  {
    this.mongoTemplate.remove(entity);
    return entity;
  }
  
  protected T delete(T entity, String collectionName)
  {
    this.mongoTemplate.remove(entity, collectionName);
    return entity;
  }
  
  protected void delete(Query query)
  {
    this.mongoTemplate.remove(query, getEntityClass());
  }
  
  protected void delete(Query query, String collectionName)
  {
    this.mongoTemplate.remove(query, getEntityClass(), collectionName);
  }
  
  protected T findById(String id)
  {
    return this.mongoTemplate.findById(id, getEntityClass());
  }
  
  protected T findById(String id, String collectionName)
  {
    return this.mongoTemplate.findById(id, getEntityClass(), collectionName);
  }
  
  protected PageInfo<T> findPage(PageForm pageable, Query query)
  {
    PageInfo<T> page = new PageInfo<>();
    long count = count(query);
    page.setTotal(Long.valueOf(count).intValue());
    
    int pageNum = pageable.getPageNum();
    int pageSize = pageable.getPageSize();
    page.setPageNum(pageNum);
    page.setPageSize(pageSize);
    
    query.skip((pageNum - 1) * pageSize).limit(pageSize);

    /**
     * total=(pageNum-1) * pageSize+ pageSize
     * x=pageSize
     *
     */
    List<T> rows = find(query);
    page.setList(rows);
    return page;
  }

  protected PageInfo<T> findPage(PageForm pageable, int count, Query query)
  {
    PageInfo<T> page = new PageInfo<>();
    page.setTotal(Long.valueOf(count).intValue());

    int pageNum = pageable.getPageNum();
    int pageSize = pageable.getPageSize();
    page.setPageNum(pageNum);
    page.setPageSize(pageSize);

    int yu = count % pageSize;
    if (yu != 0 && page.getPages() > 1){
      //前面将页码反转，现在如果是查询第一页,100=100
      if (pageNum == 1){
        query.limit(yu);
      } else {
        query.skip((pageNum - 2) * pageSize + yu).limit(pageSize);
      }

    } else {
      query.skip((pageNum - 1) * pageSize).limit(pageSize);
    }


    /**
     * total=(pageNum-1) * pageSize+ pageSize
     * x=pageSize
     *
     */
    List<T> rows = find(query);
    page.setList(rows);
    return page;
  }
  
  protected PageInfo<T> findPage(PageForm pageable, Query query, String collectionName)
  {
    PageInfo<T> page = new PageInfo<>();
    long count = count(query, collectionName);
    page.setTotal(Long.valueOf(count).intValue());
    
    int pageNum = pageable.getPageNum();
    int pageSize = pageable.getPageSize();
    page.setPageNum(pageNum);
    page.setPageSize(pageSize);
    
    query.skip((pageNum - 1) * pageSize).limit(pageSize);
    List<T> rows = find(query, collectionName);
    page.setList(rows);
    return page;
  }
  
  protected long count(Query query)
  {
    return this.mongoTemplate.count(query, getEntityClass());
  }
  
  protected long count(Query query, String collectionName)
  {
    return this.mongoTemplate.count(query, getEntityClass(), collectionName);
  }
  
  protected MongoTemplate getMongoTemplate()
  {
    return this.mongoTemplate;
  }
}
