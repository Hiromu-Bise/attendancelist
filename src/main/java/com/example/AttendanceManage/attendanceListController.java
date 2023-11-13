package com.example.AttendanceManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class attendanceListController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/attendanceList")
    public String index(Model model) {
        String sql = "SELECT * FROM ATTENDANCES;";

        System.out.println(jdbcTemplate.queryForList(sql));
        return "attendancelist";
    }

}