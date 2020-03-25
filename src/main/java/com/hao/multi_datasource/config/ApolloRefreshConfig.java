package com.hao.multi_datasource.config;

import com.ctrip.framework.apollo.core.ConfigConsts;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ApolloRefreshConfig implements ApplicationContextAware {
    ApplicationContext applicationContext;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApolloRefreshConfig.class);
    @Autowired
    RefreshScope refreshScope;

    //这里指定Apollo的namespace，非常重要，如果不指定，默认只使用application
    @ApolloConfigChangeListener(value = {ConfigConsts.NAMESPACE_APPLICATION,"dev_namespace"})
    public void onChange(ConfigChangeEvent changeEvent) {
        for (String changedKey : changeEvent.changedKeys()) {
            LOGGER.info("apollo changed namespace:{} Key:{} value:{}", changeEvent.getNamespace(), changedKey, changeEvent.getChange(changedKey));
        }
        refreshProperties(changeEvent);
    }

    public void refreshProperties(ConfigChangeEvent changeEvent) {
        Set changedKeys = changeEvent.changedKeys();
        this.applicationContext.publishEvent(new EnvironmentChangeEvent(changedKeys));
        if(changeEvent.changedKeys().toString().indexOf("master")!=-1){
            refreshScope.refresh("masterDataSource");
        }else if(changeEvent.changedKeys().toString().indexOf("slave")!=-1){
            refreshScope.refresh("slaveDataSource");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
