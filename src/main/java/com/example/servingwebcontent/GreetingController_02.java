package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController_02 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        String sql = "SELECT * FROM ATTENDANCES;";
        List<Map<String,Object>> attendances = jdbcTemplate.queryForList(sql);
        System.out.println(attendances);
        model.addAttribute("attendances", attendances);

        return "greeting";
    }

    @PostMapping("/greeting")
    public String postMethod(@RequestParam("post_param") String param1, String name, Model model) {

        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        System.out.println(time);

        String sql2 = "UPDATE ATTENDANCES SET begin_time = ? WHERE id='12345678'";

        jdbcTemplate.update(sql2,time);

        model.addAttribute("name", name);
        String sql = "SELECT * FROM ATTENDANCES;";
        List<Map<String,Object>> attendances = jdbcTemplate.queryForList(sql);
        System.out.println(attendances);
        model.addAttribute("attendances", attendances);


        return "greeting";
    }
  //追加
    //bise testtesttest1234abcdefgh
  
    //中本↓↓↓
    @RequestMapping("/send01")
    public String send01(){
        return "send01";
    }
    @PostMapping("/receive01") //次回ここから（send01で入力させたデータがattendandesDBのデータと合ってるか判定したい）
    public String login(@RequestParam("id") String name,@RequestParam("pass") String pass, Model m) {
        m.addAttribute("id",name);
        m.addAttribute("pass",pass);
        return "receive01";
    }
  
}
