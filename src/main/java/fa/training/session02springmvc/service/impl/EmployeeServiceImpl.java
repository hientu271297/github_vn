package fa.training.session02springmvc.service.impl;

import fa.training.session02springmvc.model.dto.EmployeeParamDTO;
import fa.training.session02springmvc.model.entity.Employee;
import fa.training.session02springmvc.repository.EmployeeRepository;
import fa.training.session02springmvc.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> finById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public boolean create(Employee employee) {
        try {
            Employee newEmployee = employeeRepository.save(employee);
            return newEmployee.getId() != null;
        }catch (Exception e){
            return false;
        }
    }


}
