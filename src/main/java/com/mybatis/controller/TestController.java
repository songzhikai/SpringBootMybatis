package com.mybatis.controller;

import com.mybatis.model.User;
import com.mybatis.service.UserService;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping("/addUser")
    public Map addUser() {
        Map result = new HashMap();
        User user = new User();
        user.setPhone("188888888888");
        user.setPassword("123");
        user.setUserName("zhangsan");
        boolean flag = userService.addUser(user);
        if(flag == true){
            result.put("code", 1);
            result.put("message", "添加成功");
        }else{
            result.put("code", 0);
            result.put("message", "添加失败");
        }
        return result;
    }
    @RequestMapping("/addUserList")
    public Map addUserList() {
        Map result = new HashMap();
        List<User> list = new ArrayList<User>();
        User user = new User();
        user.setPhone("188888888888");
        user.setPassword("188888888888");
        user.setUserName("zhangsan");
        list.add(user);
        User user2 = new User();
        user2.setPhone("16666666666");
        user2.setPassword("16666666666");
        user2.setUserName("lisi");
        list.add(user2);
        User user3 = new User();
        user3.setPhone("17777777777");
        user3.setPassword("17777777777");
        user3.setUserName("wangwu");
        list.add(user3);
        boolean flag = userService.insertByBatch(list);
        if(flag == true){
            result.put("code", 1);
            result.put("message", "添加成功");
        }else{
            result.put("code", 0);
            result.put("message", "添加失败");
        }
        return result;
    }
    @RequestMapping("/deleteByUserIdAndUserNames")
    public Map deleteByUserIdAndUserNames() {
        Map result = new HashMap();
        List<User> list = new ArrayList<User>();
        String[] userNames = new String[]{"zhangsan", "wangwu"};
        boolean flag = userService.deleteByUserIdAndUserNames(1000, userNames);
        if(flag == true){
            result.put("code", 1);
            result.put("message", "成功");
        }else{
            result.put("code", 0);
            result.put("message", "失败");
        }
        return result;
    }

}
