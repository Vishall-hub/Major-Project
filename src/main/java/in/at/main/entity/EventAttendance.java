package in.at.main.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="event_attendance")
@Data
@NoArgsConstructor

@AllArgsConstructor
public class EventAttendance {

    @EmbeddedId
    private EventAttendanceId id;

    public EventAttendanceId getId() {
		return id;
	}

	public void setId(EventAttendanceId id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Enumerated(EnumType.STRING)
    private Status status;
}
