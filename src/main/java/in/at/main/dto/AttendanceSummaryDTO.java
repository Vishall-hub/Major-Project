package in.at.main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceSummaryDTO {

    private String rollNo;
    private long totalClasses;
    private long present;
    private long absent;
    private double percentage;
    private String subjectID;
    
	public String getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public long getTotalClasses() {
		return totalClasses;
	}
	public void setTotalClasses(long totalClasses) {
		this.totalClasses = totalClasses;
	}
	public long getPresent() {
		return present;
	}
	public void setPresent(long present) {
		this.present = present;
	}
	public long getAbsent() {
		return absent;
	}
	public void setAbsent(long absent) {
		this.absent = absent;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public AttendanceSummaryDTO(String rollNo, String subjectID, long totalClasses, long present, long absent, double percentage) {
		super();
		this.rollNo = rollNo;
		this.totalClasses = totalClasses;
		this.present = present;
		this.absent = absent;
		this.percentage = percentage;
		this.subjectID = subjectID;
	}
    
 
	public AttendanceSummaryDTO(String rollNo, long totalClasses, long present, long absent, double percentage) {
		super();
		this.rollNo = rollNo;
		this.totalClasses = totalClasses;
		this.present = present;
		this.absent = absent;
		this.percentage = percentage;
		
	}
    
    
}
