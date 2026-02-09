package in.at.main.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.at.main.entity.EventAttendance;
import in.at.main.entity.EventAttendanceId;

@Repository
public interface EventAttendanceRepository extends JpaRepository<EventAttendance, EventAttendanceId> {

    List<EventAttendance> findByIdRollNo(String rollNo);
    
    @Query("SELECT a FROM EventAttendance a JOIN Student s ON a.id.rollNo = s.rollNo WHERE " +
    	       "(:branch IS NULL OR s.branch = :branch) AND " +
    	       "(:eventId IS NULL OR a.id.eventId = :eventId) AND " +
    	       "(:date IS NULL OR a.id.attendanceDate = :date)")
    	List<EventAttendance> searchEventWithBranch(
    	        @Param("branch") String branch,
    	        @Param("eventId") Integer eventId,
    	        @Param("date") LocalDate date
    	);

    		
    
}

