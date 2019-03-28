package com.tangcco.evaluation.controller;

import com.alibaba.fastjson.JSON;
import com.tangcco.evaluation.service.TeacherService;
import com.tangcoo.evaluation.pojo.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TeacherController {


    @Resource
    private TeacherService service;
    @RequestMapping("teacherList")
    public String teacherList(@RequestParam(value = "typeId",required = false) Integer typeId, Model model,@RequestParam(value = "name",required = false) String name) {

        System.out.println(typeId);
        System.out.println(name);

        List<Teacher> teachers=service.findTeacher(typeId,name);
        model.addAttribute("teachers",teachers);
        return "teacher";
    }

    @RequestMapping("UpdateTeacher")
    public String UpdateTeacher(@RequestParam("teacher_id") Integer teacher_id,Model model)
    {

        System.out.println(teacher_id);
        Teacher teacher=service.findTeacherById(teacher_id);
        model.addAttribute("teacher",teacher);

        return "";
    }
    @RequestMapping("delTeacher")
    @ResponseBody
    public JSON delTeacher(@RequestParam("teacherId") Integer teacherId){
        System.out.println("aaaaaaaaaaaaaaaaa");
        Integer result = null;
        Map<String, String> resultMap = new HashMap<String, String>();
        try {
            result = service.deleteTeacherById(teacherId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result>0) {
            resultMap.put("data", "true");
        } else {
            resultMap.put("data", "false");
        }
        return (JSON) JSON.toJSON(resultMap);
    }

}
