package in.at.main.entity;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventAttendanceId implements Serializable {

    private String rollNo;
    private Integer eventId;
    private Integer slotId;
    private LocalDate attendanceDate;
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	public Integer getSlotId() {
		return slotId;
	}
	public void setSlotId(Integer slotId) {
		this.slotId = slotId;
	}
	public LocalDate getAttendanceDate() {
		return attendanceDate;
	}
	public void setAttendanceDate(LocalDate attendanceDate) {
		this.attendanceDate = attendanceDate;
	}
      
}
