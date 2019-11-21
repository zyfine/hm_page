package com.hm.hm_page.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hm.hm_page.entity.User;
import com.hm.hm_page.service.UserService;
import com.hm.hm_page.util.FastJsonConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable int id) throws Exception {
        ModelAndView mv = new ModelAndView("/sys/show");
        User userinfo = userService.getFirst(id);
        mv.addObject("member", userinfo);
        return mv;
    }
    //    http://localhost:8080/testBoot/getAll
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ModelAndView getUserlist() throws Exception {
        ModelAndView mv = new ModelAndView("/sys/userlist");
        List<User> userlist = userService.getAlluser();
        mv.addObject("userlist", userlist);
        return mv;
    }

    @RequestMapping(value = "/getAllJson", method = RequestMethod.GET)
    public String getUserlistJson() throws Exception {
        List<User> userlist = userService.getAlluser();
        String re = FastJsonConvertUtil.convertObjectToJSON(userlist);
        return re;
    }

    //http://localhost:8080/testBoot/getAllPage?pageNum=1
    @RequestMapping(value = "/getAllPage" , method = RequestMethod.GET)
    public ModelAndView getSomePerson(@RequestParam(value = "pageNum",defaultValue="1") int pageNum ) throws Exception {
        ModelAndView mv = new ModelAndView("/sys/userlistPage");
        //pageNum:表示第几页  pageSize:表示一页展示的数据
        PageHelper.startPage(pageNum,3);
        List<User> userlist = userService.getAlluser();
        //将查询到的数据封装到PageInfo对象
        PageInfo<User> pageInfo=new PageInfo(userlist,3);
        //分割数据成功
        mv.addObject("userlist", userlist);
        return mv;
    }
    @RequestMapping(value = "/delUser/{id}", method = RequestMethod.POST)
    public ModelAndView delUser(@PathVariable int id) throws Exception {
        ModelAndView mv = new ModelAndView("/sys/success");
        userService.delUser(id);
       return mv;
    }
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView showAdd() throws Exception {
        ModelAndView mv = new ModelAndView("/sys/form");
        return mv;
    }
    @PostMapping(value = "/save")
    public String saveUser(User user) throws Exception {
//        ModelAndView mv = new ModelAndView("success");
        user.setPassword("14235245");
        userService.insertUser(user);
        return "redirect:/sys/userlist";
    }
    @PostMapping(value = "/saveBatch")
    public ModelAndView saveBatchUser(User user) throws Exception {
        ModelAndView mv = new ModelAndView("success");
        user.setPassword("14235245");
        List<User> list = new ArrayList<User>();
        list.add(user);
        list.add(user);
        userService.insertUserBatch(list);
        return mv;
    }


}
