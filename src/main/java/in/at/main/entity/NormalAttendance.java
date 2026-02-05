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
@Table(name="normal_attendance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NormalAttendance {

    public NormalAttendanceId getId() {
		return id;
	}


	public void setId(NormalAttendanceId id) {
		this.id = id;
	}


	public Status getStatus() {
		return status;
	}


	@EmbeddedId
    private NormalAttendanceId id;

    @Enumerated(EnumType.STRING)
    private Status status;

	public void setStatus(Status status) {
		this.status = status;
	}

    
	
}

