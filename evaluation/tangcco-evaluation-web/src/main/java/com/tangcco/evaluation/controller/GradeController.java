package com.tangcco.evaluation.controller;

import com.tangcco.evaluation.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GradeController {
    @Autowired
    private GradeService gradeService;


}
