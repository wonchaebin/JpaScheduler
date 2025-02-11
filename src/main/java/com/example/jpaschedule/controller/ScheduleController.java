package com.example.jpaschedule.controller;

import com.example.jpaschedule.dto.ScheduleRequestDto;
import com.example.jpaschedule.dto.ScheduleResponseDto;
import com.example.jpaschedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/schedules") //일정 등록
    public ResponseEntity<ScheduleResponseDto> saveSchedule(@RequestBody ScheduleRequestDto dto) {
        return new ResponseEntity<>(scheduleService.saveSchedule(dto), HttpStatus.CREATED);
    }

    @GetMapping("/schedules/{id}") //일정 단건 조회
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {
        ScheduleResponseDto schedulefindById = scheduleService.findScheduleById(id);

        return new ResponseEntity<>(schedulefindById, HttpStatus.OK);
    }

    @GetMapping("/schedules") //일정 전체 조회
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedules() {
        List<ScheduleResponseDto> schedules = scheduleService.findAllSchedules();

        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @PutMapping("/schedules/{id}") //일정 수정
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequestDto dto) {
        scheduleService.updateSchedule(id, dto);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/schedule/{id}") //일정 삭제
    public void deleteSchdeule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
    }
}
