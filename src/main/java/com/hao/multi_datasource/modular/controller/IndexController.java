package com.hao.multi_datasource.modular.controller;

import com.hao.multi_datasource.core.common.annotion.DataSource;
import com.hao.multi_datasource.core.common.constant.DataSourceType;
import com.hao.multi_datasource.modular.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {
    private Logger log= LoggerFactory.getLogger(getClass());
    @Autowired
    private MessageService messageService;

    @RequestMapping("/master")
    @ResponseBody
    public Object test(){
        Object total=messageService.test1();
        log.info("master数据源中message总数:"+total);
        return total;
    }

    @RequestMapping("/slave")
    @ResponseBody
    public Object slave(){
        Object total=messageService.test2();
        log.info("slave数据源中message总数:"+total);
        return total;
    }
}
