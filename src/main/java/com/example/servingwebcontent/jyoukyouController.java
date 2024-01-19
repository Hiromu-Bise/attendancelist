package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public class jyoukyouController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/jyoukyou")
    public String jyokyo(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        String sql = "SELECT * FROM ATTENDANCES;";
        List<Map<String,Object>> attendances = jdbcTemplate.queryForList(sql);
        System.out.println(attendances);
        model.addAttribute("attendances", attendances);

        return "jyoukyou";
    }

}
