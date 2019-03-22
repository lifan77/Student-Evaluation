package com.tangcco.evaluation.controller;

import com.tangcco.evaluation.service.PaperService;
import com.tangcoo.evaluation.dto.PageResult;
import com.tangcoo.evaluation.dto.Result;
import com.tangcoo.evaluation.pojo.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * CreateDate: 2019/3/21 19:17
 */
@RequestMapping("paper")
@Controller
public class PaperController {

    @Autowired
    private PaperService paperService;

    @ResponseBody
    @GetMapping("papers")
    public PageResult<Paper> findAllByExample(Paper paper, Integer page, Integer size) {
        return paperService.findAllByExample(paper, page, size);
    }

    @PostMapping("save")
    public Result save(Paper paper) {
        try {
            paperService.save(paper);
            return new Result(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败");
        }
    }
}
