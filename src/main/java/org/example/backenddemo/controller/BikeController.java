package org.example.backenddemo.controller;

import org.example.backenddemo.entity.Bike;
import org.example.backenddemo.mapper.BikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BikeController {

    @Autowired
    public BikeMapper bikeMapper;

    @PostMapping("/bike/add")
    public String add(@RequestBody Bike bike) {
        int i = bikeMapper.insert(bike);
        if (i > 0) {
            return "添加成功";
        }else {
            return "error";
        }
// TODO 异常处理
    }

    @PostMapping("/bike/delete")
    public String delete(@RequestBody Map<String, Integer> request) {
        Integer receivedInt = request.get("id");
        int i = bikeMapper.deleteById(receivedInt);
        if (i > 0) {
            return "成功删除" + i + "条记录";
        }else {
            return "删除失败";
        }
    }





    @GetMapping("/bike")
    public List<Bike> query() {
        List<Bike> bikes = bikeMapper.selectList(null);
        return bikes;
    }


}
