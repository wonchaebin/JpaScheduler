package com.example.jpaschedule.service;

import com.example.jpaschedule.dto.ScheduleRequestDto;
import com.example.jpaschedule.dto.ScheduleResponseDto;
import com.example.jpaschedule.entity.Schedule;
import com.example.jpaschedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto dto) {

        return null;
    }
}
