package com.stock.iposchedule.controller;

import com.stock.iposchedule.service.AlarmService;
import com.stock.iposchedule.service.CrawlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlarmController {

    @Autowired
    AlarmService alarmService;


    @GetMapping("send")
    @ResponseBody
    public String logDemo() {
        alarmService.alarm();

        return "TEST";
    }
}
