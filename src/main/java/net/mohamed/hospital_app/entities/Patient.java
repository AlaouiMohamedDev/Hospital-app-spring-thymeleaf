package net.mohamed.hospital_app.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
@Table(name="PATIENTS")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min=2 , max=70)
    private String lastName;
    private String firstName;
    private Date birthDate;
    @DecimalMin(value = "10")
    private int score;
    private boolean malade;
}
