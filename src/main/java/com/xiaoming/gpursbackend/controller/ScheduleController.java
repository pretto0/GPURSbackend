package com.xiaoming.gpursbackend.controller;

import com.xiaoming.gpursbackend.Response;
import com.xiaoming.gpursbackend.dao.ScheduleRepository;
import com.xiaoming.gpursbackend.dto.scheduleCreateDTO;
import com.xiaoming.gpursbackend.dto.scheduleDTO;
import com.xiaoming.gpursbackend.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping("/schedule/{id}")
    public Response<scheduleDTO> getScheduleById(@PathVariable int id) {
        return Response.success(scheduleService.getScheduleById(id));
    }

    @GetMapping("/schedule")
    public Response<List<scheduleDTO>> getAllSchedules() {
        return Response.success(scheduleService.getAllSchedules());
    }

    @PostMapping("/schedule")
    public Response<scheduleDTO> saveSchedule(@RequestBody scheduleCreateDTO scheduleCreateDTO) {
        return Response.success(scheduleService.addNewSchedule(scheduleCreateDTO));
    }

    @DeleteMapping("/schedule/{id}")
    public void deleteScheduleById(@PathVariable int id) {
        scheduleService.deleteScheduleById(id);
    }
}