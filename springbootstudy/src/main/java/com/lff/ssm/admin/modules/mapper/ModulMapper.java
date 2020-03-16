package com.lff.ssm.admin.modules.mapper;

import com.lff.ssm.admin.modules.model.Module;
import com.lff.ssm.admin.modules.model.ModuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModulMapper {
    long countByExample(ModuleExample example);

    int deleteByExample(ModuleExample example);

    int deleteByPrimaryKey(String moduleId);

    int insert(Module record);

    int insertSelective(Module record);

    List<Module> selectByExample(ModuleExample example);

    Module selectByPrimaryKey(String moduleId);

    int updateByExampleSelective(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByExample(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
}