package com.mn.index.controller;

import com.wordnik.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/5/5 12:51
 * DESC
 */

@Controller
@RequestMapping(value = "test")
@Api(value = "test")
public class TestController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public Object hello() {
        return "hello world";
    }

}
