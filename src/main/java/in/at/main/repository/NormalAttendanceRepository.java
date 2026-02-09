package in.at.main.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import in.at.main.entity.EventAttendance;
import in.at.main.entity.NormalAttendance;
import in.at.main.entity.NormalAttendanceId;
import jakarta.transaction.Transactional;

public interface NormalAttendanceRepository extends JpaRepository<NormalAttendance, NormalAttendanceId> {

    @Modifying
    @Transactional
    @Query("""
        UPDATE NormalAttendance na
        SET na.status = 'PRESENT'
        WHERE na.id.rollNo = :rollNo
        AND na.id.slotId = :slotId
        AND na.id.attendanceDate = :date
    """)
    int updateAttendanceToPresent(String rollNo, Integer slotId, java.time.LocalDate date);
    
    
    List<NormalAttendance> findByIdRollNo(String rollNo);
    
    //Subject-wise Attendance
    @Query("SELECT COUNT(n) FROM NormalAttendance n WHERE n.id.rollNo = :rollNo AND n.id.subjectId = :subjectId")
    long totalClassesOverall(@Param("rollNo") String rollNo, Integer subjectId) ;

    @Query("SELECT COUNT(n) FROM NormalAttendance n WHERE n.id.rollNo = :rollNo AND n.id.subjectId = :subjectId AND n.status = 'PRESENT'")
    long totalPresentOverall(@Param("rollNo") String rollNo, Integer subjectId);
       
    
   
    //OverAll Attendance by filters
    @Query("SELECT COUNT(n) FROM NormalAttendance n WHERE n.id.rollNo = :rollNo")
    long totalClasses(@Param("rollNo") String rollNo);

    @Query("SELECT COUNT(n) FROM NormalAttendance n WHERE n.id.rollNo = :rollNo AND n.status = 'PRESENT'")
    long totalPresent(@Param("rollNo") String rollNo);

    
    @Query("SELECT a FROM NormalAttendance a WHERE " +
    	       "(:subjectId IS NULL OR a.id.subjectId = :subjectId) AND " +
    	       "(:date IS NULL OR a.id.attendanceDate = :date)")
    	List<NormalAttendance> searchNormal(
    	        @Param("subjectId") Integer subjectId,
    	        @Param("date") LocalDate date
    	);

    	
    	//for geting bracnch
    @Query("SELECT a FROM NormalAttendance a JOIN Student s ON a.id.rollNo = s.rollNo WHERE " +
    	       "(:branch IS NULL OR s.branch = :branch) AND " +
    	       "(:subjectId IS NULL OR a.id.subjectId = :subjectId) AND " +
    	       "(:date IS NULL OR a.id.attendanceDate = :date)")
    	List<NormalAttendance> searchNormalWithBranch(
    	        @Param("branch") String branch,
    	        @Param("subjectId") Integer subjectId,
    	        @Param("date") LocalDate date
    	);

}
