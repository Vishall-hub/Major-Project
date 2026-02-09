package in.at.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    private String username;
    private String role;
    private String rollNo;
    private String facultyId;

    public LoginResponse(String username, String role, String rollNo, String facultyId) {
        this.username = username;
        this.role = role;
        this.rollNo = rollNo;
        this.facultyId = facultyId;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getFacultyId() {
        return facultyId;
    }

	
	private String token;

}
