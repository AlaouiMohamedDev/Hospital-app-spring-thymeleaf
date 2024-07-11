package net.mohamed.hospital_app;

import lombok.NoArgsConstructor;
import net.mohamed.hospital_app.entities.Patient;
import net.mohamed.hospital_app.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class HospitalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner start(PatientRepository patientRepository){ //Injection de dependance = @Autowired
		return args -> {
			//NoArgsConstructor
			Patient patient = new Patient();
			patient.setFirstName("HAMID");
			patient.setLastName("OMAR");
			patient.setBirthDate(new Date());
			patient.setMalade(true);
			patient.setScore(20);
			patientRepository.save(patient);

			//AllArgsConstructor
			patientRepository.save(new Patient(null,"ALAOUI","MOHAMED",new Date(),11,false));
			patientRepository.save(new Patient(null,"ALAOUI","MOHAMED",new Date(),11,false));
			patientRepository.save(new Patient(null,"ALAOUI","MOHAMED",new Date(),11,false));
			patientRepository.save(new Patient(null,"ALAOUI","MOHAMED",new Date(),11,false));
			patientRepository.save(new Patient(null,"ALAOUI","MOHAMED",new Date(),11,false));
			patientRepository.save(new Patient(null,"ALAOUI","MOHAMED",new Date(),11,false));
			patientRepository.save(new Patient(null,"ALAOUI","MOHAMED",new Date(),11,false));
			patientRepository.save(new Patient(null,"ALAOUI","MOHAMED",new Date(),11,false));

			//Builder
			Patient patient1 = Patient.builder()
					.firstName("KARIM")
					.lastName("FOUAD")
					.birthDate(new Date())
					.score(30)
					.malade(false)
					.build();
			patientRepository.save(patient1);

			patientRepository.findAll().forEach(p->{
				System.out.println("*********");
				System.out.println(p.toString());
				System.out.println("*********");
			});
		};
	}

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
