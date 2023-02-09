package fa.training.session02springmvc.service;

import fa.training.session02springmvc.model.dto.EmployeeParamDTO;
import fa.training.session02springmvc.model.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAll();

    Optional<Employee> finById(Long id);

    boolean create(Employee employee);
}
