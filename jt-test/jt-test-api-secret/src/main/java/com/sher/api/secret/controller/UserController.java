package com.sher.api.secret.controller;

import com.sher.api.secret.bean.ResponseEntity;
import com.sher.api.secret.constant.UserType;
import com.sher.api.secret.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sherxia92
 */
@Slf4j
@RestController
@RequestMapping(value = {"/user", "/secret/user"})
public class UserController {

    @RequestMapping("/list")
    ResponseEntity<List<User>> listUser(){
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setName("boyka");
        user.setRegisterTime(LocalDateTime.now());
        user.setUserType(UserType.COMMON);
        users.add(user);
        ResponseEntity<List<User>> response = new ResponseEntity<>();
        response.setCode(HttpStatus.OK.value());
        response.setData(users);
        response.setMsg("用户列表查询成功\"");
        return response;
    }
}
