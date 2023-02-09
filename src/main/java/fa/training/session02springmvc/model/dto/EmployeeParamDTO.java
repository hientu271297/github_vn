package fa.training.session02springmvc.model.dto;

import fa.training.session02springmvc.enums.Role;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class EmployeeParamDTO {
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private Role role;
}
