package com.hbxy.ssm.admin.module.controller;

import com.hbxy.ssm.admin.module.model.App;
import com.hbxy.ssm.admin.module.model.AppExample;
import com.hbxy.ssm.admin.module.model.Module;
import com.hbxy.ssm.admin.module.model.ModuleExample;
import com.hbxy.ssm.admin.module.service.AppService;
import com.hbxy.ssm.admin.module.service.ModuleService;
import com.hbxy.ssm.admin.right.model.RoleRightExample;
import com.hbxy.ssm.admin.right.service.RoleRightService;
import com.hbxy.ssm.util.IdUtil;
import com.hbxy.ssm.util.UserLoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin  //js允许跨域访问
@Controller
@RequestMapping("/admin")
public class AppController {

    @Autowired
    private AppService appService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private RoleRightService roleRightService;

    //进入模块
    @RequestMapping("/applist")
    public String appList(){
        return "/admin/app_list";
    }

    //查询
    @RequestMapping(value = "/app", method = RequestMethod.GET)
    public @ResponseBody Object appGet(Model model, HttpServletRequest request){
        List<App> list = new ArrayList<>();

        AppExample appExample = new AppExample();
        AppExample.Criteria criteria = appExample.createCriteria();
        criteria.andCurrentStatusEqualTo("0");
        appExample.setOrderByClause(" order_index");

        list = appService.selectByExample(appExample);

        return list;
    }

    //添加
    @RequestMapping(value = "/app",method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody Object appAdd(@RequestBody App app,
                                       Model model, HttpServletRequest request){
        String id= IdUtil.nextId().toString();
        app.setAppId(id);
        app.setCurrentStatus("0");//0-正常状态;1-删除状态;
        app.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        app.setCreatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        app.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));
        app.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());

        appService.insert(app);

        return app;
    }

    //修改
    @RequestMapping(value = "/app",method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody Object appEdit(@RequestBody App app,
                                       Model model, HttpServletRequest request){
        app.setCurrentStatus("0");//0-正常状态;1-删除状态;
        app.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));
        app.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        appService.updateByPrimaryKeySelective(app);

        //更新模块表中关联的子系统名称
        Module module = new Module();
        module.setAppName(app.getAppName());//设置要修改的内容
        module.setCurrentStatus("0");
        module.setLastUpdatedTime(new Timestamp(System.currentTimeMillis()));
        module.setLastUpdatedUserLoginId(UserLoginUtil.getUserLogin(request).getUserLoginId());
        ModuleExample moduleExample = new ModuleExample();
        ModuleExample.Criteria criteria = moduleExample.createCriteria();
        criteria.andAppIdEqualTo(app.getAppId());//设置条件
        //根据条件，有选择的更新内容
        moduleService.updateByExampleSelective(module,moduleExample);

        return app;
    }

    //删除
    @RequestMapping(value = "/app/{id}",method = RequestMethod.DELETE)
    public @ResponseBody Object appDelete(@PathVariable String id,
                                        Model model, HttpServletRequest request){
        appService.deleteByPrimaryKey(id);

        //查询出关联的模块
        ModuleExample moduleExample = new ModuleExample();
        ModuleExample.Criteria criteria = moduleExample.createCriteria();
        criteria.andAppIdEqualTo(id);

        List<Module> moduleList = moduleService.selectByExample(moduleExample);

        //删除模块表关联的模块
        //根据条件删除子表记录
        moduleService.deleteByExample(moduleExample);


        ////删除与角色相关联的模块(role_right表里的数据)
        if(moduleList.size() > 0){
            List<String> moduleIds = new ArrayList<>();
            for(Module module: moduleList){
                moduleIds.add(module.getModuleId());
            }
            RoleRightExample roleRightExample = new RoleRightExample();
            RoleRightExample.Criteria criteria2 = roleRightExample.createCriteria();
            criteria2.andResourceIdIn(moduleIds);
            roleRightService.deleteByExample(roleRightExample);
        }

        return "200";
    }

}
