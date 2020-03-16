package com.lff.ssm.admin.user.service.impl;


import com.lff.ssm.admin.user.mapper.UserLoginMapper;
import com.lff.ssm.admin.user.model.UserLogin;
import com.lff.ssm.admin.user.model.UserLoginExample;
import com.lff.ssm.admin.user.service.UserLogingService;
import org.springframework.stereotype.Service;

import java.util.List;
//手工添加注解

@Service
public class UserLogingServiceImpl implements UserLogingService {

    //自动注入Mapper对象
    //Autowired
    private UserLoginMapper mapper;

    //根据条件查询得到总数
    @Override
    public long countByExample(UserLoginExample example) {
        return mapper.countByExample(example);
    }

    //根据条件删除
    @Override
    public int deleteByExample(UserLoginExample example) {
        return mapper.deleteByExample(example);
    }

    //根据主键删除
    @Override
    public int deleteByPrimaryKey(String userId) {
        return mapper.deleteByPrimaryKey(userId);
    }

    //插入数据（每列都执行插入 set a=record.getA）
    @Override
    public int insert(UserLogin record) {
        return mapper.insert(record);
    }

    //有条件插入：根据record记录的值是否为空，进行sql拼装
    @Override
    public int insertSelective(UserLogin record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<UserLogin> selectByExample(UserLoginExample example) {
        return mapper.selectByExample(example);
    }

    @Override
    public UserLogin selectByPrimaryKey(String userId) {
        return mapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByExampleSelective(UserLogin record, UserLoginExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(UserLogin record, UserLoginExample example) {
        return mapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(UserLogin record) {
        return updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserLogin record) {
        return updateByPrimaryKey(record);
    }



}
