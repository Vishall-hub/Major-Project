package in.at.main.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.at.main.dto.AttendanceSummaryDTO;
import in.at.main.entity.EventAttendance;
import in.at.main.entity.NormalAttendance;
import in.at.main.repository.EventAttendanceRepository;
import in.at.main.repository.NormalAttendanceRepository;
import in.at.main.service.AttendanceService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final NormalAttendanceRepository normalRepo;
    private final EventAttendanceRepository eventRepo;
    private final AttendanceService attendanceService;

    public StudentController(NormalAttendanceRepository normalRepo, EventAttendanceRepository eventRepo
    		,AttendanceService attendanceService) {
        this.normalRepo = normalRepo;
        this.eventRepo = eventRepo;
        this.attendanceService = attendanceService;
    }
    
    //in this both method do same work with diff way
    @GetMapping("/{rollNo}/normal")
    public List<NormalAttendance> getNormal(@PathVariable String rollNo) {
        return normalRepo.findByIdRollNo(rollNo);
    }

    @GetMapping("/{rollNo}/event")
    public List<EventAttendance> getEventAttendance(@PathVariable String rollNo) {
        return eventRepo.findAll()
                .stream()
                .filter(a -> a.getId().getRollNo().equals(rollNo))
                .toList();
    }
    
    

    


}
