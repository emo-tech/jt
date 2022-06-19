package com.sher.test.controller;

import com.sher.test.param.FooParam;
import com.sher.test.service.FooService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sherxia92
 */
@Slf4j
@RestController
public class FooController {

    @Autowired
    private FooService fooService;

    @RequestMapping("/getFoo")
    public Object getFoo(@RequestBody FooParam fooParam) {
        log.debug("fooParam: {}", fooParam);
        return fooParam;
    }

}
