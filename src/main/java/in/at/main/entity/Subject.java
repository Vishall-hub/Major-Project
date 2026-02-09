package in.at.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;

    private String subjectName;

    private int semester;

    public int getSubjectId() {
        return subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public Subject() {
    }
    
    public Subject(int subjectId, String subjectName, int semester) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.semester = semester;
	}

	public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}

