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

public class rirekiController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String (@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        return "";
    }

}
