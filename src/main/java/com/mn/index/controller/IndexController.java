package com.mn.index.controller;

import com.wordnik.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/5/5 12:51
 * DESC
 */

@Api(value = "index")
@Controller
@RequestMapping(value = "index")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public Object index() {
        return "P站图包";
    }

}
