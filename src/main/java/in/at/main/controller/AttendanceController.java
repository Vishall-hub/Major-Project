package in.at.main.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.at.main.entity.EventAttendance;
import in.at.main.entity.NormalAttendance;
import in.at.main.service.AttendanceService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;
    
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }
    
    @PostMapping("/normal")
    public String markNormal(@RequestBody List<NormalAttendance> list) {
        attendanceService.markNormalAttendance(list);
        return "Normal Attendance Marked";
    }

    @PostMapping("/event")
    public String markEvent(@RequestBody List<EventAttendance> list) {
        attendanceService.markEventAttendance(list);
        return "Event Attendance Marked & Normal Updated";
    }
}
