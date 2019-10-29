package com.lemon.lemon.Controller.HelloController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Copyright (C) 2014-2016 东华软件股份公司
 * 功能描述: 主页面
 * 作    者: liuhoujun
 * 创建时间: 2019/10/28 14:29
 * 修改记录:
 *      <时间>                <作者>        <版本>        <描述>
 *      2019/10/28 14:29        liuhoujun         1.0          初始创建
 *
 */
@Controller
public class HelloController {

    /**
     * 功能描述: 主页面显示
     * 作    者: liuhoujun
     * 创建时间: 2019/10/28 14:39
     */
    @GetMapping("/")
    public String hello(@RequestParam(name="name",required = false,defaultValue = "刘厚均")String name,Model model){
        //将数据写入HTML页面
        return "index";//返回到某个页面。
    }




      /*  @GetMapping("/greeting")
        public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
            model.addAttribute("name", name);
            return "greeting";

         }*/
}
