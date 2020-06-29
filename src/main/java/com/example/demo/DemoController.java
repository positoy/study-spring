package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class DemoController {
    DemoService service;

    public DemoController(DemoService service) {
        this.service = service;
    }

    //CREATE (post)
    @PostMapping("/api/demo")
    public Demo postDemo(@RequestBody Demo demo) {
        LoggerFactory.getLogger(DemoController.class).info("/api/demo, " + "{data=" +demo.getData()+",id="+demo.getId()+"}");
        return service.addDemo(demo);
    }

    //READ (get)
    @GetMapping("/api/demo")
    public ArrayList<Demo> getDemo(
            @RequestParam(value = "data", defaultValue = "") String data, @RequestParam(value = "id", defaultValue = "0") int id) {
        LoggerFactory.getLogger(DemoController.class).info("/api/demo," + " data("+data+")," + " id(" +id + ")");
        return data.isEmpty() ? service.getAll() : service.getDemoWithData(data);
    }

    @GetMapping("/api/demo/{id}")
    public Demo getDemo(
            @PathVariable("id") int id) {
        LoggerFactory.getLogger(DemoController.class).info("/api/demo/" + id);
        return service.getDemo(id);
    }

    //UPDATE (put)
    @PutMapping("/api/demo/{id}")
    public Demo putDemo(
            @PathVariable("id") int id,
            @RequestBody Demo demo) {
        return service.updateDemo(id, demo);
    }

    //D (delete)
    @DeleteMapping("/api/demo/{id}")
    public Demo deleteDemo(@PathVariable("id")int id) {
        return service.deleteDemo(id);
    }

}
