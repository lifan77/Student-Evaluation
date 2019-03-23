package com.tangcco.evaluation.controller;

import com.tangcco.evaluation.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClassController {
    @Autowired
    private ClassService classService;


}
