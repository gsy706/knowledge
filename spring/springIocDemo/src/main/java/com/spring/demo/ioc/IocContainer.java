/**
 * Copyright © 2010-2019 Everyday Chain. All rights reserved.
 */
package com.spring.demo.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 1.实例化bean
 * 2.保存bean
 * 3.提供bean
 * 4.每个bean产生一个唯一的id预支相对应
 *
 * @author: gusiyuan
 * @date: 2019-05-27
 */
public class IocContainer {

    private Map<String, Object> beans = new ConcurrentHashMap<>();

    /**
     * 根据beanId获取一个bean
     * @author: gusiyuan
     * @date: 2019-05-27
     * @param beanId
     * @return 返回bean
     */
    public Object getBean(String beanId) {
        return beans.get(beanId);
    }

    /**
     * 委托Ioc容器创建一个bean
     * @author: gusiyuan
     * @date: 2019-05-27
     * @param clazz 要创建的bean的class
     * @param beanId beanId
     * @param paramBeanIds 要创建的bean的class的构造方法所需要的参数的beanId们
     * @return void
     */
    public void setBean(Class<?> clazz, String beanId, String... paramBeanIds){
        // 1.组装构造方法所需要的参数值
        Object[] paramValues = new Object[paramBeanIds.length];
        for (int i = 0; i < paramBeanIds.length; i++) {
            paramValues[i] = beans.get(paramBeanIds[i]);
        }
        // 2.调用构造方法实例化bean
        Object bean = null;
        // TODO 反射
        for (Constructor<?> constructor : clazz.getConstructors()) {
            try {
                bean = constructor.newInstance(paramValues);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        if (bean == null) {
            // 实例化失败
            throw new RuntimeException("找不到合适的构造方法去实例化bean");
        }
        // 3.将实例化的bean放入beans
        beans.put(beanId, bean);
    }

}
