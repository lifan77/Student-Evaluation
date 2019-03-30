package com.tangcco.evaluation.controller;

import com.tangcco.evaluation.service.RoleService;
import com.tangcoo.evaluation.pojo.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RoleController {
    @Resource
    private RoleService roleService;

    /*   *
     * @Description:去登陆页面
     * @Param:[]
     * @return:java.lang.String
     * @Author:DongZhen
     * @Date:2019/3/29
     */
    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("adminLogin")
    public String adminLogin(HttpServletRequest request, Model model, @RequestParam(value = "roleId", required = false) String roleId, @RequestParam(value = "password", required = false) String password) {
       request.getSession().setMaxInactiveInterval(1);
        Role role = roleService.findRole(roleId, password);
        if (role != null) {
            request.getSession().setAttribute("userSession", role);
            request.getSession().setAttribute("success","登陆成功");
        } else {
            model.addAttribute("error","登陆失败");
            return "login";
        }
        model.addAttribute("userSession",role);
        return "redirect:class/toindnex";
    }

    @RequestMapping("exit")
    public String exit(HttpServletRequest request){
        request.removeAttribute("userSession");
        return "login";
    }
}
