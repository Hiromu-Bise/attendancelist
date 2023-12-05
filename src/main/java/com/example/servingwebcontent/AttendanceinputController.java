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
public class AttendanceinputController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @PostMapping("/home")
    public String input(@RequestParam("post_param") String param1, String name, Model model) {
        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        System.out.println(time);

        String sql2 = "UPDATE ATTENDANCES SET begin_time = ? WHERE id='98765432';";

        jdbcTemplate.update(sql2,time);

        return "home";
    }

}
