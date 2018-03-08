package com.chengziting.razor.web.controller;

import com.chengziting.razor.model.persistent.Roles;
import com.chengziting.razor.model.persistent.UserInfo;
import com.chengziting.razor.service.IRolesService;
import com.chengziting.razor.service.IUserInfoService;
import com.chengziting.razor.web.core.annotations.Administrator;
import com.chengziting.razor.web.model.ViewModel;
import com.chengziting.razor.web.model.vm.SimpleRoleModel;
import com.chengziting.razor.web.model.vm.SimpleUserInfoModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2018-03-08.
 */
@Controller
@RequestMapping("admin")
//@Administrator
public class AdministratorController {

    @Autowired
    private IUserInfoService userInfoService;
    @Autowired
    private IRolesService rolesService;

    @ResponseBody
    @RequestMapping(value = "rolelist",method = RequestMethod.POST)
    public String getRoles(){
        List<Roles> rolesList = rolesService.getList();
        List<SimpleRoleModel> roleModelList = new ArrayList<SimpleRoleModel>();
        for (Roles role : rolesList){
            SimpleRoleModel model = new SimpleRoleModel();
            model.setId(role.getId());
            model.setName(role.getName());
            model.setStatus(role.getStatus());
            List<SimpleUserInfoModel> userInRoleList = new ArrayList<SimpleUserInfoModel>();
            for(UserInfo user : role.getUsers()){
                SimpleUserInfoModel userModel = new SimpleUserInfoModel();
                userModel.setId(user.getId());
                userModel.setName(user.getName());
                userInRoleList.add(userModel);
            }
            model.setUsers(userInRoleList);
            roleModelList.add(model);
        }

        ViewModel<List<SimpleRoleModel>> vm = new ViewModel<List<SimpleRoleModel>>();
        vm.setTitle("Role List");
        vm.setData(roleModelList);
        return new Gson().toJson(vm);
    }
}
