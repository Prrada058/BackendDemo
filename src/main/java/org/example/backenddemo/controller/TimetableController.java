package org.example.backenddemo.controller;

import org.example.backenddemo.entity.Timetable;
import org.example.backenddemo.mapper.TimetableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TimetableController {

    @Autowired
    private TimetableMapper timetableMapper;

//    @GetMapping("/timetable")
//    public List<Timetable> query() {
//
//        List<Timetable> timetables = timetableMapper.selectList(null);
//        return timetables;
//
//    }
//
//    @GetMapping("/time")
//    public LocalDateTime getTime() {
//        LocalDateTime now = LocalDateTime.now();
//        return now;
//    }

    @GetMapping("/timeBack")
    public List<String> getTimeBack() {
        List<String> timetables = timetableMapper.selectTimetable("永丰");
        LocalTime now = LocalTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        List<String> list = new ArrayList<String>();


        for (int i = 0; i < timetables.size(); i++) {

            LocalTime nextSubway = LocalTime.parse(timetables.get(i), formatter);
            Duration duration = Duration.between(now, nextSubway);
            long minutes = duration.toMinutes() % 60;
            long seconds = duration.getSeconds() % 60;
            if (minutes < 10){
                System.out.println(timetables.get(i) + " |  " + minutes + "分" + seconds + "秒");
                list.add(timetables.get(i) + " |  " + minutes + "分" + seconds + "秒");
            }else {
                System.out.println(timetables.get(i) + " | " + minutes + "分" + seconds + "秒");
                list.add(timetables.get(i) + " | " + minutes + "分" + seconds + "秒");
            }


        }


        return list;
    }

    @GetMapping("/timeGo")
    public List<String> getTimeGo() {
        List<String> timetables = timetableMapper.selectTimetable("温阳路");
        LocalTime now = LocalTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        List<String> list = new ArrayList<String>();


        for (int i = 0; i < timetables.size(); i++) {

            LocalTime nextSubway = LocalTime.parse(timetables.get(i), formatter);
            Duration duration = Duration.between(now, nextSubway);
            long minutes = duration.toMinutes() % 60;
            long seconds = duration.getSeconds() % 60;
            if (minutes < 10){
                System.out.println(timetables.get(i) + " |  " + minutes + "分" + seconds + "秒");
                list.add(timetables.get(i) + " |  " + minutes + "分" + seconds + "秒");
            }else {
                System.out.println(timetables.get(i) + " | " + minutes + "分" + seconds + "秒");
                list.add(timetables.get(i) + " | " + minutes + "分" + seconds + "秒");
            }


        }


        return list;
    }

    @GetMapping("/getCookie")
    public String getCookie(@CookieValue("accountToken") String accountToken) {
        return "Cookie Value: " + accountToken;
    }

}


