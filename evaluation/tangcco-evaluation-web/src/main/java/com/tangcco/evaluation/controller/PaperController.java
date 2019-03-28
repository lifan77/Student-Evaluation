package com.tangcco.evaluation.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tangcco.evaluation.service.GradeService;
import com.tangcco.evaluation.service.PaperService;
import com.tangcoo.evaluation.dto.PageResult;
import com.tangcoo.evaluation.dto.Result;
import com.tangcoo.evaluation.pojo.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * CreateDate: 2019/3/21 19:17
 */
@RequestMapping("/paper")
@Controller
public class PaperController {

    @Autowired
    private PaperService paperService;

    @Autowired
    private GradeService gradeService;

    private final int size = 5;


    @RequestMapping("/papers")
    public String findAllByExample(Model model, String date1, String date2, Integer page) {
        page=page==null?1:page;
        date1=date1==null?"":date1;
        date2=date2==null?"":date2;
        PageResult<Paper> papers = paperService.findAllByExample(date1, date2, page, size);
        model.addAttribute("date1",date1);
        model.addAttribute("date2",date2);
        model.addAttribute("papers", papers.getItems());
        model.addAttribute("page", page);
        model.addAttribute("total", papers.getTotal());
        model.addAttribute("size", size);
        return "papers";
    }

    @GetMapping("/savePage")
    public String savePage(Model model) {
        model.addAttribute("grades",gradeService.findAll());
        return "add_paper";
    }

    @ResponseBody
    @PostMapping("/save")
    public Result save(Paper paper,String begin,String end) {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            paper.setBeginTime(format.parse(begin.replace('T',' ')));
            paper.setEndTime(format.parse(end.replace('T',' ')));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        paper.setCreateTime(new Date());
        if (paperService.save(paper) > 0) {
            return new Result(true, "添加成功");
        } else {
            return new Result(false, "添加失败");
        }
    }














    @RequestMapping("totestScore")
    public String totestScore(Model model, Integer pid , Integer cid){
        pid=pid==null?0:pid;
        cid=cid==null?0:cid;
        model.addAttribute("pid",pid);
        model.addAttribute("cid",cid);
        return "testScore";

    }

    @RequestMapping("totestScoreDetail")
    public String totestScoreDetail(){
        return "testScoreDetail";
    }



    @RequestMapping("getPapers")
    @ResponseBody
    public JSON getPapers(){
        List<Paper> papers=paperService.getPaperList();
        return (JSON)JSON.toJSON(papers);
    }

    @RequestMapping("getPaperClasses")
    @ResponseBody
    public JSON getPaperClasses(Integer pid){
        Paper paper=paperService.getPaperClasses(pid);
        JSONObject jsonObject=JSONObject.parseObject(paper.getClasses());//获取json数据
        JSONArray jsonArray=jsonObject.getJSONArray("classes");//根据键获取json中的json数组

        return (JSON)JSON.toJSON(jsonArray);
    }



}
