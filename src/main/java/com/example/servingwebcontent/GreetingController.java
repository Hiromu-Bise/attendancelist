package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.stylesheets.LinkStyle;

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
    @GetMapping("/attendanceList")
    public String index(Model model) {
        String sql = "SELECT * FROM ATTENDANCES;";

        System.out.println(jdbcTemplate.queryForList(sql));
        return "attendancelist";
    }

}