package com.lff.ssm.admin.user.mapper;

import com.lff.ssm.admin.user.model.Org;
import com.lff.ssm.admin.user.model.OrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgMapper {
    long countByExample(OrgExample example);

    int deleteByExample(OrgExample example);

    int deleteByPrimaryKey(String orgId);

    int insert(Org record);

    int insertSelective(Org record);

    List<Org> selectByExample(OrgExample example);

    Org selectByPrimaryKey(String orgId);

    int updateByExampleSelective(@Param("record") Org record, @Param("example") OrgExample example);

    int updateByExample(@Param("record") Org record, @Param("example") OrgExample example);

    int updateByPrimaryKeySelective(Org record);

    int updateByPrimaryKey(Org record);
}