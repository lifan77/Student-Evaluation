package com.tangcco.evaluation.controller;

import com.tangcco.evaluation.service.ClassService;
import com.tangcoo.evaluation.pojo.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/class")
@Controller
public class ClassController {
    @Autowired
    private ClassService classService;

    @ResponseBody
    @RequestMapping("/classes")
    public List<Class> clesses(Integer gradeId){
        return classService.findAllByExample(gradeId);
    }

}
