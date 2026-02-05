package in.at.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    private String rollNo;

    private String name;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Branch branch;

    private String batch;
}

