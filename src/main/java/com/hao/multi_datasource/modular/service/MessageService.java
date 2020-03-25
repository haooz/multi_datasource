package com.hao.multi_datasource.modular.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hao.multi_datasource.core.common.annotion.DataSource;
import com.hao.multi_datasource.core.common.constant.DataSourceType;
import com.hao.multi_datasource.modular.dao.MessageMapper;
import com.hao.multi_datasource.modular.entity.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageService extends ServiceImpl<MessageMapper,Message> {

    @DataSource(value= DataSourceType.MASTER)
    public Object test1(){
        return this.baseMapper.selectCount(null);
    }

    @DataSource(value= DataSourceType.SLAVE)
    public Object test2(){
        return this.baseMapper.selectCount(null);
    }
}
