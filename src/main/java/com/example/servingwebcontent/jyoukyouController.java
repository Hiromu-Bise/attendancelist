package com.example.servingwebcontent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class jyoukyouController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/jyokyo")
    public String jyokyo(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {

        return "jyokyo";
    }

}
