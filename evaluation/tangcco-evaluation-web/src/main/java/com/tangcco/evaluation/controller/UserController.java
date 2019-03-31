package com.tangcco.evaluation.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tangcco.evaluation.service.*;
import com.tangcoo.evaluation.dto.PageDto;
import com.tangcoo.evaluation.pojo.*;
import com.tangcoo.evaluation.pojo.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@RequestMapping("/student")
@Controller
public class UserController {
    private Integer userId;
    //先查出来paper表的状态，然后查出来班级
    private Integer paperId;
    private Date endTime;
    //根据班级查出teacherId，教员Id
    private Integer teacherId;
    private Integer classTeacherId;
    //获取班级id
    private Integer classId;
    //获取班级的所属年级
    private Integer gradeId;
    //意见反馈
    private String option;
    //昵称
    private String nickname;
    //时间
    private Date date=new Date();

    @Autowired
    private UserService userService;
    @Autowired
    private PaperService paperService;
    @Autowired
    private ClassService classService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private GradeService gradeService;

    private TeacherService teacherService;
    @RequestMapping("")
    public String index(Model model){
        Map<String,String> map=new HashMap<>();
        for (int i = 0; i < paperService.findJson().size(); i++) {
            JSONObject jsonObject = JSONObject.parseObject(paperService.findJson().get(i).getClasses());
            JSONArray list = jsonObject.getJSONArray("classes");

            /*String jsonArray = paperService.findJson().get(i).getClasses();//获取到两个json的String
            JSONArray list = JSON.parseArray(jsonArray);//String转成JSONArray
            System.out.println(list.size());*/

            for (int j = 0; j < list.size(); j++) {
                // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                JSONObject job = list.getJSONObject(j);
                // 得到 每个对象中的属性值
                //System.out.println(job.get("classId") + "=");
                map.put(job.get("classId").toString(), job.get("name").toString());
                //System.out.println(job.get("name") + "=");
            }
        }
        model.addAttribute("map",map);
        System.out.println(map);
        return "/admin-login/index";
    }

    @RequestMapping(value = "studentLogin")
    public String  loginStudent(String password, String name, Integer classId, RedirectAttributes redirectAttributes,Model model){
        User user=new User();
        user.setClassId(classId);
        this.classId=classId;   //33333333333333333333333333333333333333333333333333333333333333333333333333
        Class c=new Class();
        c.setClassId(this.classId);

        //user.setLand(1);
        user.setName(name);
        String yan=password;
        User user1=userService.login(user);

        if(user1!=null){
            this.userId=user1.getUserId();/////////////////////////////////////////////////////////////////////////获取用户id
            System.out.println(user1);
            String seng=user1.getNumber().substring(12,18);//获取后六位
            Integer land=user1.getLand();//获取登录状态
            //登录状态判断
            if(land==1){
                System.out.println("允许登录");
                if(seng.equals(yan)){
                    System.out.println("验证成功");
                    Class c2=classService.select(c).get(0);
                    this.teacherId=c2.getTeacherId();//33333333333333333333333333333333333333333333333333333333333333333
                    this.classTeacherId=c2.getClassTeacherId();//3333333333333333333333333333333333333333333333333333333
                    this.gradeId=c2.getGradeId();
                    model.addAttribute("msg","身份验证成功，允许登录。");
                    return "forward:/student/exam1";
                }else{
                    System.out.println("验证失败");
                    redirectAttributes.addFlashAttribute("msg","身份验证失败，请检查登录信息。");
                    return "redirect:/student";
                }
            }else{
                System.out.println("不允许登录");
                redirectAttributes.addFlashAttribute("msg","身份验证失败，请检查登录信息。");
                return "redirect:/student";
            }
        }else{
            redirectAttributes.addFlashAttribute("msg","身份验证失败，请检查登录信息。");
            return "redirect:/student";
        }

    }
    @RequestMapping("exam1")
    public String exam(Model model) {  //Integer gradeId,Integer teacherType 这两个参数一定要加的
        Teacher teacher=teacherService.findTeacherById(teacherId);
        System.out.println(teacher);
        Question t = new Question();
        t.setGradeId(this.gradeId);
        t.setTeacherType(teacher.getType());
        List<Question> q = questionService.selectQuestion(t);//根据年级，教员开始分配题目
        //[Question(questionId=2, title=测试2, direction=很棒, options=[{"detail":"这是第一个选项","score":"1"},{"detail":"这是第二个选项","score":"2"},{"detail":"这是第三个选项","score":"3"}], gradeId=1, createTime=Sat Mar 23 14:32:31 CST 2019, updateTime=Sat Mar 23 19:32:36 CST 2019, teacherType=2)]
        /*List<String> key=new ArrayList<>();
        List<String> value=new ArrayList<>();*/
        Map<String, Map> map = new HashMap<>();
        System.out.println(t);
        for (int i = 0; i < q.size(); i++) {
            String xuhao = q.get(i).getTitle();
            System.out.println(q.get(i).getOptions());//得到array
            String jsonArray = q.get(i).getOptions();
            JSONArray list = JSON.parseArray(jsonArray);
            List<String> key = new ArrayList<>();
            List<String> value = new ArrayList<>();
            Map<String, String> option = new HashMap<>();
            for (int j = 0; j < list.size(); j++) {
                // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                JSONObject job = list.getJSONObject(j);
                // 得到 每个对象中的属性值
                System.out.println(job.get("detail") + "=");
                option.put(job.get("detail").toString(), job.get("score").toString());
                //System.out.println(option);
                //key.set(j,job.get("detail").toString());
                //value.set(j,job.get("score").toString());
                //map.put(key,value);
                //System.out.println(job.get("name") + "=");
            }
            map.put(xuhao, option);
        }
        System.out.println(map);
        model.addAttribute("map",map);
        model.addAttribute("teacher",teacher);
        //这是往前面传的结果
        //{1={这是第二个选项=2, 这是第一个选项=1, 这是第三个选项=3}, 2={这是第二个选项=2, 这是第一个选项=1, 这是第三个选项=3}}
        return "/StudentMT/index";
    }
    @RequestMapping("exam2")
    public String exam2(Model model) {  //Integer gradeId,Integer teacherType 这两个参数一定要加的
        System.out.println("进来没有exam2");
        Teacher teacher2=teacherService.findTeacherById(classTeacherId);
        Question t = new Question();
        t.setGradeId(this.gradeId);
        t.setTeacherType(teacher2.getType());
        List<Question> q = questionService.selectQuestion(t);//根据年级，教员开始分配题目
        //[Question(questionId=2, title=测试2, direction=很棒, options=[{"detail":"这是第一个选项","score":"1"},{"detail":"这是第二个选项","score":"2"},{"detail":"这是第三个选项","score":"3"}], gradeId=1, createTime=Sat Mar 23 14:32:31 CST 2019, updateTime=Sat Mar 23 19:32:36 CST 2019, teacherType=2)]
        /*List<String> key=new ArrayList<>();
        List<String> value=new ArrayList<>();*/
        Map<String, Map> map = new HashMap<>();
        for (int i = 0; i < q.size(); i++) {
            String xuhao = q.get(i).getTitle();
            System.out.println(q.get(i).getOptions());//得到array
            String jsonArray = q.get(i).getOptions();
            JSONArray list = JSON.parseArray(jsonArray);
            List<String> key = new ArrayList<>();
            List<String> value = new ArrayList<>();
            Map<String, String> option = new HashMap<>();
            for (int j = 0; j < list.size(); j++) {
                // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                JSONObject job = list.getJSONObject(j);
                // 得到 每个对象中的属性值
                System.out.println(job.get("detail") + "=");
                option.put(job.get("detail").toString(), job.get("score").toString());
                //System.out.println(option);
                //key.set(j,job.get("detail").toString());
                //value.set(j,job.get("score").toString());
                //map.put(key,value);
                //System.out.println(job.get("name") + "=");
            }
            map.put(xuhao, option);

        }
        System.out.println(map);
        model.addAttribute("map",map);
        //这是往前面传的结果
        //{1={这是第二个选项=2, 这是第一个选项=1, 这是第三个选项=3}, 2={这是第二个选项=2, 这是第一个选项=1, 这是第三个选项=3}}
        model.addAttribute("teacher2",teacher2);
        return "/ans/demo2";
    }

    @RequestMapping("submitExam")
    public String submitExam1(String nickname, String detail, Integer score, String option, RedirectAttributes redirectAttributes, Model model){
        Answer answer=new Answer();
        answer.setNickname(nickname);
        System.out.println(detail);
        detail=detail.substring(0,detail.length() - 1);
        answer.setDetail("["+detail+"]");
        answer.setTotalScore(score);
        answer.setOpinion(option);
        answer.setStatus(0);
        answer.setTeacherId(this.teacherId);
        answer.setClassId(this.classId);
        Integer garderId=this.gradeId;
        List<Paper> p=paperService.findJson();
        for (int i = 0; i <p.size() ; i++) {
            if(date.getTime()<p.get(i).getEndTime().getTime()){
                this.paperId=p.get(i).getPaperId();
            }
        }
        answer.setPaperId(this.paperId);    //////////////////////////////////////////////////这里是paperid
        answer.setCreateTime(date);
        Integer j=answerService.addAnswer(answer);
        if (j==1){
            model.addAttribute("msg","提交成功，进入下一个测评问卷。");
            System.out.println(nickname+""+detail+""+score+""+option);
            return "forward:/student/exam2";
        }else{
            redirectAttributes.addFlashAttribute("msg","提交失败，请联系管理员进行维护。");
            System.out.println(nickname+""+detail+""+score+""+option);
            return "redirect:/student";
        }
    }
    @RequestMapping("submitExam2")
    public String submitExam2(String nickname,String detail,Integer score,String option,RedirectAttributes redirectAttributes,Model model){
        Answer answer=new Answer();
        answer.setNickname(nickname);
        detail=detail.substring(0,detail.length() - 1);
        answer.setDetail("["+detail+"]");
        answer.setTotalScore(score);
        answer.setOpinion(option);
        answer.setStatus(0);



        Integer garderId=this.gradeId;
        List<Paper> p=paperService.findJson();
        for (int i = 0; i <p.size() ; i++) {
            if(date.getTime()<p.get(i).getEndTime().getTime()){
                this.paperId=p.get(i).getPaperId();
            }
        }
        answer.setPaperId(paperId);
        answer.setCreateTime(this.date);
        answer.setTeacherId(this.classTeacherId);
        answer.setClassId(this.classId);
        Integer j=answerService.addAnswer(answer);
        if (j==1){
            model.addAttribute("msg","提交成功，完成测评。");
            System.out.println(nickname+""+detail+""+score+""+option);
            userService.userLand(this.userId);
            return "forward:/student";
        }else{
            redirectAttributes.addFlashAttribute("msg","提交失败，请联系管理员进行维护。");
            System.out.println(nickname+""+detail+""+score+""+option);
            return "redirect:/student";
        }
    }


    @RequestMapping("/userList")
    public String userList(Integer classId,String stuName,Map map){
        System.out.println(classId+"....."+stuName+"***********************");
        PageDto<User> userPageDto = userService.selectUser(1,10,classId,stuName);
        map.put("userList",userPageDto);
        map.put("cId",classId);
        if(stuName==null){
            stuName="";
        }
        map.put("stuName",stuName);
        return "student/student_list";
    }

    @RequestMapping("ajaxUserList")
    @ResponseBody
    public Object ajaxUserList(Integer pageNo, Integer pageSize, Integer classId,String stuName){
        System.out.println(stuName+"mingzi ============");
        PageDto<User> userPageDto = userService.selectUser(pageNo,10,classId,stuName);
        return userPageDto;
    }

    @RequestMapping("addUser")
    public String addUser(Integer classId,Map map){
        System.out.println(classId+"获取的班级id");
        map.put("classId",classId);
        return "student/add_student";
    }

    @RequestMapping("addUsers")
    public String addUsers(Integer cid,String stuName,String number,Integer login){
        String shenfenzheng=number;
        String pwd = shenfenzheng.substring(shenfenzheng.length() - 6);
        System.out.println(pwd);
        User user = new User();
        user.setClassId(cid);
        user.setName(stuName);
        user.setNumber(number);
        user.setLand(login);
        user.setPassword(pwd);
        Integer count = userService.addUser(user);
        if(count>0){
            return "redirect:/student/userList?classId="+cid;
        }else{
            return "student/add_student";
        }
    }

    @RequestMapping("updateStu")
    public String updateStu(Map map,Integer userId){
        List<Class> classList = classService.queryAll();
        map.put("classes",classList);
        User user = userService.selectByid(userId);
        map.put("user",user);
        return "student/update_student";
    }

    @RequestMapping("updateStus")
    public String updateStus(Integer stuId,String stuName,Integer stuClassId,String stuNum,Integer login,String stuPwd){
        System.out.println(stuId);
        User user = new User();
        user.setUserId(stuId);
        user.setName(stuName);
        user.setClassId(stuClassId);
        user.setLand(login);
        user.setNumber(stuNum);
        user.setPassword(stuPwd);
        int count = userService.updateUser(user);
        if(count>0){
            System.out.println("修改成功");
           return "redirect:/student/userList?classId="+user.getClassId() ;
        }else{
            return "student/update_student";
        }

    }
}
