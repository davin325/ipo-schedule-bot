package com.stock.iposchedule.controller;

import com.stock.iposchedule.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlarmController {

    @Autowired
    AlarmService alarmService;


    @Scheduled(cron = "0 0 22 * * SUN")
    @Scheduled(cron = "0 0 9 * * MON-FRI")
    @GetMapping("send")
    @ResponseBody
    public void sendBot() {
        alarmService.alarm();
    }
}
