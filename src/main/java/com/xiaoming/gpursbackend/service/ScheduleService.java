package com.xiaoming.gpursbackend.service;

import com.xiaoming.gpursbackend.dto.scheduleCreateDTO;
import com.xiaoming.gpursbackend.dto.scheduleDTO;

import java.util.List;

public interface ScheduleService {

    scheduleDTO getScheduleById(int id);

    void deleteScheduleById(int id);

    scheduleDTO addNewSchedule(scheduleCreateDTO scheduleCreateDTO);

    List<scheduleDTO> getAllSchedules();
}
