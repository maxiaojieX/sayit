package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Admin;
import com.example.demo.bean.AdminConfig;
import com.example.demo.bean.Friends;
import com.example.demo.bean.Message;
import com.example.demo.service.*;
import com.example.demo.util.mail.CodeEmailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaojie.Ma on 2018/3/13.
 */
@Controller
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AdminService adminService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private FrinedsService frinedsService;
    @Autowired
    private RegService regService;
    @Autowired
    private AdminConfigService adminConfigService;
    @GetMapping("/")
    public String index(Model model,@RequestParam(required = false) String msg) {
        if(msg != null) {
            model.addAttribute("msg",msg);
        }else {
            model.addAttribute("msg","");
        }
        return "index";
    }


    @PostMapping("/login")
    public String login(String user, String password, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        if("".equals(user) || user ==null || "".equals(password) || password ==null) {
            return "redirect:/";
        }else {
            if(adminService.chickAdmin(user,password,request)) {
                return "redirect:/home";
            }else {
                redirectAttributes.addAttribute("msg","账号或密码错误!");
                return "redirect:/";
            }
        }
    }

    @GetMapping(value = "/home",produces = "text/plain;charset=UTF-8")
    public String home(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("user");
        AdminConfig adminConfig = adminConfigService.findById(admin.getId());
        model.addAttribute("sex",adminConfig.getHeadPortraitUrl());
        List<Message> messages = messageService.findAllByAid(admin.getId());

        model.addAttribute("messages",messages);
        model.addAttribute("id",admin.getId());
        return "user/home";
    }

    @RequestMapping(value = "/edit" ,produces = "text/plain;charset=UTF-8")
    public String edit(String id,Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("user");
        AdminConfig adminConfig = adminConfigService.findById(admin.getId());
        model.addAttribute("sex",adminConfig.getHeadPortraitUrl());
        model.addAttribute("aid",id);
        return "user/edit";
    }

    @RequestMapping(value = "/friends",produces = "text/plain;charset=UTF-8")
    public String friends(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("user");
        List<Friends> friends = frinedsService.findAll(admin.getId());
        AdminConfig adminConfig = adminConfigService.findById(admin.getId());
        model.addAttribute("sex",adminConfig.getHeadPortraitUrl());
        model.addAttribute("friends",friends);
        return "user/friends";
    }

    @PostMapping(value = "/save",produces = "text/plain;charset=UTF-8")
    public String save(String aid,String content,String simi,String reply,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("user");
        try {
            Message message = new Message();
            message.setAid(Integer.parseInt(aid));
            message.setContent(content);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long time=System.currentTimeMillis();
            String d = format.format(time);
            Date data=format.parse(d);
            message.setCreateTime(data);

            message.setBy(admin.getId());
            messageService.save(message);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(Integer.parseInt(aid) == admin.getId()) {
            return "redirect:/home";
        }else {
            return "redirect:/friendsHome?bid="+aid;
        }
    }

    @RequestMapping(value = "/friendsHome",produces = "text/plain;charset=UTF-8")
    public String friendsHome(String bid,Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("user");
        AdminConfig adminConfig = adminConfigService.findById(admin.getId());
        model.addAttribute("sex",adminConfig.getHeadPortraitUrl());
        List<Message> messages = messageService.findByAid(Integer.parseInt(bid));
        model.addAttribute("aid",bid);
        model.addAttribute("messages",messages);
        return "user/friendsHome";
    }

    @RequestMapping(value = "/findFriends",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String findFriends(String name) {
        Admin admin = frinedsService.findByName(name);
        AdminConfig adminConfig = adminConfigService.findById(admin.getId());

        if(admin == null) {
            return "NONE";
        }else {
            String json = admin.getId()+"_"+adminConfig.getHeadPortraitUrl()+"_"+adminConfig.getNickName();
            return json;
        }
    }

    @GetMapping(value = "/makeFriend",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String makeFriend(String bid,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("user");
        frinedsService.save(admin.getId(),Integer.parseInt(bid));
        return "SUCCESS";
    }

    @GetMapping(value = "/reg",produces = "text/plain;charset=UTF-8")
    public String reg(){
        return "reg";
    }

    @GetMapping(value = "/getCode",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String a(String email) {
        if(CodeEmailUtil.codes.containsKey(email)) {
            return "请勿重新请求";
        }else {
            try {
                if(CodeEmailUtil.sendMail(email)) {
                    return "验证码已发送成功!";
                }else {
                    return  "验证码发送失败";
                }
            }catch (MailSendException m){
                return "请输入正确邮箱";
            }
        }
    }

    @PostMapping(value = "/doReg",produces = "text/plain;charset=UTF-8")
    public String doReg(String email,String password,String nickName,String code,Model model) {

        if (email == null || password == null || nickName == null || code == null ||"".equals(email) || "".equals(password) || "".equals(nickName) || "".equals(code)){
            return "reg";
        }
        if(code.length() < 4){
            return "reg";
        }else {
            String co = code.substring(0,4);
            if(CodeEmailUtil.codes.containsKey(email) && CodeEmailUtil.codes.get(email).equals(co)) {
                CodeEmailUtil.codes.remove(email);
                String num = regService.doReg(email,password,nickName);
                log.debug("【用户注册】账户:"+num+",nickName:"+nickName+",密码:"+password+",邮箱:"+email);
                model.addAttribute("number",num);
                return "num";
            }else {
                return "reg";
            }
        }
    }

    @GetMapping("/config")
    public String config(Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("user");
        AdminConfig adminConfig = adminConfigService.findById(admin.getId());
        model.addAttribute("adminConfig",adminConfig);
        model.addAttribute("sex",adminConfig.getHeadPortraitUrl());
        return "user/userConfig";
    }

}
