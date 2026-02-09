package in.at.main.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import in.at.main.dto.AttendanceSummaryDTO;
import in.at.main.entity.EventAttendance;
import in.at.main.entity.NormalAttendance;
import in.at.main.entity.Status;
import in.at.main.repository.EventAttendanceRepository;
import in.at.main.repository.NormalAttendanceRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final NormalAttendanceRepository normalRepo;
    private final EventAttendanceRepository eventRepo;
    
    public AttendanceService(NormalAttendanceRepository normalRepo,
            EventAttendanceRepository eventRepo) {
this.normalRepo = normalRepo;
this.eventRepo = eventRepo;
}
  

    // Teacher marks normal attendance
    public void markNormalAttendance(List<NormalAttendance> list) {
        if (list == null || list.isEmpty()) {
            throw new RuntimeException("Attendance list is empty");
        }
        normalRepo.saveAll(list);
    }

    // Event coordinator marks event attendance
    public void markEventAttendance(List<EventAttendance> list) {

        if (list == null || list.isEmpty()) {
            throw new RuntimeException("Event Attendance list is empty");
        }

        eventRepo.saveAll(list);

        // after event attendance, update normal attendance
        updateNormalAttendanceFromEvent(list);
    }

    private void updateNormalAttendanceFromEvent(List<EventAttendance> list) {

        for (EventAttendance ea : list) {

            if (ea != null && ea.getStatus() == Status.PRESENT) {

                String rollNo = ea.getId().getRollNo();
                Integer slotId = ea.getId().getSlotId();
                LocalDate date = ea.getId().getAttendanceDate();

                normalRepo.updateAttendanceToPresent(rollNo, slotId, date);
            }
        }
    }
    
    // For Percentage of Attendance
    public AttendanceSummaryDTO getOverallSummary(String rollNo) {

        long total = normalRepo.totalClasses(rollNo);
        long present = normalRepo.totalPresent(rollNo);
        long absent = total - present;

        double percentage = 0;
        if (total > 0) {
            percentage = (present * 100.0) / total;
        }

        return new AttendanceSummaryDTO(rollNo, total, present, absent, percentage);
    }
    
    
    public AttendanceSummaryDTO getOverallSummaryBySubject(String rollNo, Integer subjectId) {

        long total = normalRepo.totalClassesOverall(rollNo,subjectId);
        long present = normalRepo.totalPresentOverall(rollNo,subjectId);
        long absent = total - present;

        double percentage = 0;
        if(total > 0) {
            percentage = (present * 100.0) / total;
        }
        
        // subjectid se

        return new AttendanceSummaryDTO(rollNo, null, total, present, absent, percentage);
    }



}
