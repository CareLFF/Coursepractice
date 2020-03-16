package com.lff.ssm.admin.right.mapper;

import com.lff.ssm.admin.right.model.RoleRight;
import com.lff.ssm.admin.right.model.RoleRightExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleRightMapper {
    long countByExample(RoleRightExample example);

    int deleteByExample(RoleRightExample example);

    int deleteByPrimaryKey(String roleRightId);

    int insert(RoleRight record);

    int insertSelective(RoleRight record);

    List<RoleRight> selectByExample(RoleRightExample example);

    RoleRight selectByPrimaryKey(String roleRightId);

    int updateByExampleSelective(@Param("record") RoleRight record, @Param("example") RoleRightExample example);

    int updateByExample(@Param("record") RoleRight record, @Param("example") RoleRightExample example);

    int updateByPrimaryKeySelective(RoleRight record);

    int updateByPrimaryKey(RoleRight record);
}