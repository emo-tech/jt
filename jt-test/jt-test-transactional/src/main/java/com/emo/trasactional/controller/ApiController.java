package com.emo.trasactional.controller;

import com.sher.common.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class ApiController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/test")
    public Result test() {
        return Result.success("hello transactional");
    }

    @RequestMapping("/do1")
    @Transactional(rollbackFor = Exception.class)
    public Result do1() {
        String sql = "delete from km_login_his where his_guid = 'BD1A41A4-8776-429D-A55C-9683ADECF105'";
        jdbcTemplate.update(sql);
        int i = 1/0;
        return Result.success(null);
    }
}
