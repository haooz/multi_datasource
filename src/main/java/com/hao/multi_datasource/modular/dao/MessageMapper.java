package com.hao.multi_datasource.modular.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hao.multi_datasource.modular.entity.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper extends BaseMapper<Message>{
}
