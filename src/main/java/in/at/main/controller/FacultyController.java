package in.at.main.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import in.at.main.EventAttendenceSystemApplication;
import in.at.main.entity.EventAttendance;
import in.at.main.entity.NormalAttendance;
import in.at.main.repository.EventAttendanceRepository;
import in.at.main.repository.NormalAttendanceRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/faculty")
@RequiredArgsConstructor
public class FacultyController {

    private final EventAttendenceSystemApplication eventAttendenceSystemApplication;

    private final NormalAttendanceRepository normalRepo;
    private final EventAttendanceRepository eventRepo;

    public FacultyController(NormalAttendanceRepository normalRepo, EventAttendanceRepository eventRepo) {
        this.eventAttendenceSystemApplication = new EventAttendenceSystemApplication();
		this.normalRepo = normalRepo;
        this.eventRepo = eventRepo;
    }

    @GetMapping("/normal/all")
    public List<NormalAttendance> getAllNormalAttendance() {
        return normalRepo.findAll();
    }

    @GetMapping("/event/all")
    public List<EventAttendance> getAllEventAttendance() {
        return eventRepo.findAll();
    }
    
    @GetMapping("/normal/search")
    public List<NormalAttendance> searchNormal(
            @RequestParam(required = false) String branch,
            @RequestParam(required = false) Integer subjectId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return normalRepo.searchNormalWithBranch(branch, subjectId, date);
    }
    
    @GetMapping("/event/search")
    public List<EventAttendance> searchEvent(
            @RequestParam(required = false) String branch,
            @RequestParam(required = false) Integer eventId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return eventRepo.searchEventWithBranch(branch, eventId, date);
    }


}
