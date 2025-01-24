package com.xiaoming.gpursbackend.service;

import com.xiaoming.gpursbackend.dao.ScheduleRepository;
import com.xiaoming.gpursbackend.dao.User;
import com.xiaoming.gpursbackend.dao.UserRepository;
import com.xiaoming.gpursbackend.dao.schedule;
import com.xiaoming.gpursbackend.dto.scheduleCreateDTO;
import com.xiaoming.gpursbackend.dto.scheduleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public scheduleDTO getScheduleById(int id) {

        schedule schedule = scheduleRepository.findById(id).orElse(null);

        User user = userRepository.findById(schedule.getUserId()).orElse(null);
        scheduleDTO scheduleDTO = new scheduleDTO();
        scheduleDTO.setId(id);
        scheduleDTO.setTitle(schedule.getTitle());
        scheduleDTO.setStart(schedule.getStart());
        scheduleDTO.setEnd(schedule.getEnd());
        scheduleDTO.setgpunum(schedule.getGpunum());

        scheduleDTO.setName(user != null ? user.getName() : null);
        return scheduleDTO;
    }

    @Override
    public void deleteScheduleById(int id) {
        scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("id:" + id + " does not exist"));
        scheduleRepository.deleteById(id);
    }

    @Override
    public scheduleDTO addNewSchedule(scheduleCreateDTO scheduleCreateDTO) {
        schedule schedule = new schedule();
        schedule.setTitle(scheduleCreateDTO.getTitle());
        schedule.setStart(scheduleCreateDTO.getStart());
        schedule.setEnd(scheduleCreateDTO.getEnd());
        schedule.setGpunum(scheduleCreateDTO.getgpunum());

        User user = userRepository.findByName(scheduleCreateDTO.getName()).orElse(null);
        schedule.setUserId(user != null ? user.getId() : null);

        scheduleRepository.save(schedule);

        scheduleDTO scheduleDTO = new scheduleDTO();
        scheduleDTO.setId(schedule.getId());
        scheduleDTO.setTitle(schedule.getTitle());
        scheduleDTO.setStart(schedule.getStart());
        scheduleDTO.setEnd(schedule.getEnd());
        scheduleDTO.setgpunum(schedule.getGpunum());
        scheduleDTO.setName(user!= null? user.getName() : null);

        return scheduleDTO;

    }

    @Override
    public List<scheduleDTO> getAllSchedules() {
        List<schedule> schedules = scheduleRepository.findAll();
        return schedules.stream().map(schedule -> {
            User user = userRepository.findById(schedule.getUserId()).orElse(null);
            scheduleDTO scheduleDTO = new scheduleDTO();
            scheduleDTO.setId(schedule.getId());
            scheduleDTO.setTitle(schedule.getTitle());
            scheduleDTO.setStart(schedule.getStart());
            scheduleDTO.setEnd(schedule.getEnd());
            scheduleDTO.setgpunum(schedule.getGpunum());
            scheduleDTO.setName(user!= null? user.getName() : null);
            return scheduleDTO;
        }).collect(Collectors.toList());
    }
}
