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
import java.util.*;

@Controller
public class GreetingController_02 {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //中本↓↓↓
    @RequestMapping("/loginPage")
    public String send01() {
        return "loginPage";
    }
    @PostMapping("/receive01")
    public String receive01(Model m, @RequestParam("ID") String id, @RequestParam("PASS") String pass) {
        m.addAttribute("id",id);
        m.addAttribute("pass",pass);
        Map<String, String> map = new HashMap<>();

        String sql3 = "SELECT id,password FROM ATTENDANCES;";
        List<Map<String, Object>> attendances = jdbcTemplate.queryForList(sql3);
        System.out.println(attendances);
        authenticate(id, pass);
        boolean existAuth = Objects.equals(authenticate(id, pass), true);
        if(existAuth){
            return "greeting";
        }
        return "loginPage";
    }
    @GetMapping("/greeting_02")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {

        model.addAttribute("name", name);
        String sql = "SELECT * FROM ATTENDANCES;";
        List<Map<String, Object>> attendances = jdbcTemplate.queryForList(sql);
        System.out.println(attendances);
        model.addAttribute("attendances", attendances);

        return "greeting";
    }
    @PostMapping("/greeting_02")
    public String postMethod(@RequestParam("post_param") String param1, String name, Model model) {

        Date date = new Date();
        Timestamp time = new Timestamp(date.getTime());
        System.out.println(time);

        String sql2 = "UPDATE ATTENDANCES SET begin_time = ? WHERE id='12345678'";

        jdbcTemplate.update(sql2, time);

        model.addAttribute("name", name);
        String sql = "SELECT * FROM ATTENDANCES;";
        List<Map<String, Object>> attendances = jdbcTemplate.queryForList(sql);
        System.out.println(attendances);
        model.addAttribute("attendances", attendances);


        return "greeting";
    }
    private boolean authenticate(String id, String password){

        String sql3 = "SELECT id,password FROM ATTENDANCES;";
        List<Map<String, Object>> map = jdbcTemplate.queryForList(sql3);

        for(int i=0; i<map.size(); i++) {
            boolean existId = id.equals((String) map.get(i).get("id"));
            boolean existPassword = password.equals(map.get(i).get("password"));
            if(existId && existPassword){
                return true;
            }
        }
        return false;
    }
}