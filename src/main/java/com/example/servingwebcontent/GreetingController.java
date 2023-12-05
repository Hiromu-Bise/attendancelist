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
public class GreetingController {

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

    @PostMapping("/input")
    public String postMethod(@RequestParam("post_param") String param1, String name, Model model) {

        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        System.out.println(time);

//        String sql2 = "UPDATE ATTENDANCES SET begin_time = ? WHERE id='12345678';";
//
//        jdbcTemplate.update(sql2,time);

        model.addAttribute("name", name);
        String sql = "SELECT * FROM ATTENDANCES;";
        List<Map<String,Object>> attendances = jdbcTemplate.queryForList(sql);
        System.out.println(attendances);
        model.addAttribute("attendances", attendances);

        return "attendanceinput";
    }

}