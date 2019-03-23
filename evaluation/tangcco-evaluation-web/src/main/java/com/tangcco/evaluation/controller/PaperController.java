package com.tangcco.evaluation.controller;

import com.tangcco.evaluation.service.PaperService;
import com.tangcoo.evaluation.dto.PageResult;
import com.tangcoo.evaluation.dto.Result;
import com.tangcoo.evaluation.pojo.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * CreateDate: 2019/3/21 19:17
 */
@RequestMapping("/paper")
@Controller
public class PaperController {

    @Autowired
    private PaperService paperService;

    @GetMapping("/papers")
    public String findAllByExample(Model model, Paper paper, Integer page, Integer size) {
        PageResult<Paper> papers = paperService.findAllByExample(paper, page, size);
        model.addAttribute("papers",papers.getItems());
        model.addAttribute("total",papers.getTotal());
        model.addAttribute("totalPage",papers.getTotalPage());
        return "papers";
    }

    @GetMapping("/savePage")
    public  String savePage(Model model){
       // model.addAttribute("",);
        return "add_paper";
    }

    @ResponseBody
    @PostMapping("/save")
    public Result save(Paper paper) {
        try {
            paper.setCreateTime(new Date());
            paperService.save(paper);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败");
        }
    }


}
