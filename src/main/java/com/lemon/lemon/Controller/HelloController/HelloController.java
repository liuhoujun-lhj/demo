package com.lemon.lemon.Controller.HelloController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloController {


    @GetMapping("hello")
    public String hello(@RequestParam(name="name",required = false,defaultValue = "刘厚均")String name,Model model){
        //将数据写入HTML页面
        model.addAttribute("name","欢迎刘厚均创建了第一个页面");
        model.addAttribute("va","你是最帅的");
        return "hello";//返回到某个页面。
    }




      /*  @GetMapping("/greeting")
        public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
            model.addAttribute("name", name);
            return "greeting";

         }*/
}
