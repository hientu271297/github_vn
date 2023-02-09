package fa.training.session02springmvc.controller;

import fa.training.session02springmvc.model.dto.EmployeeParamDTO;
import fa.training.session02springmvc.model.entity.Employee;
import fa.training.session02springmvc.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    //TODO: Constructor Injection
//    private final EmployeeService employeeService;
//    @Autowired
//    public EmployeeController(EmployeeService employeeService){
//        this.employeeService = employeeService;
//    }
    //TODO: Setter Injection
    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String showEmployeeList(Model model) {
        List<Employee> employeeList = employeeService.getAll();
        model.addAttribute("employeeList", employeeList);
        System.out.println(employeeList);
        return "employee/employee-list"; //Forward to view
        //       return "redirect:/employee"  => Send redirect
    }

//    @GetMapping("/employee")
//    public Employee showEmployee(@RequestParam Long id){
//        Employee employee = employeeService.finById(id);
//        System.out.println(employee);
//        return employee;
//    }

    @GetMapping("/add")
    public String showEmployeeAdd(Model model) {
        EmployeeParamDTO employeeParamDTO = new EmployeeParamDTO();
        model.addAttribute("employeeParamDto", employeeParamDTO);
        return "employee/employee-form";
    }

    @PostMapping("/add")
    public String addEmployee(EmployeeParamDTO employeeParamDTO) {
        //convert DTO ->Entity
        Employee employee = new Employee();
        //Copy all mapping-field(variable name,data type) employeeDTO to Employee
        BeanUtils.copyProperties(employeeParamDTO, employee);
        employeeService.create(employee);
        return "redirect:/employees";
    }

    //GET /employees/update?id={id}&q={keywordSearch}
//    @GetMapping("/update")
//    public String showEmployeeUpdate(@RequestParam Long id,
//                                     @RequestParam(required = false) String q){
//        return "employee/employee-form";
//    }

    @GetMapping("update/{id}")
    public String showEmployeeUpdate(@PathVariable(name = "id") Long employeeId, Model model){
        Optional<Employee> employeeOpt = employeeService.finById(employeeId);
        if (employeeOpt.isEmpty()){
            throw new IllegalArgumentException("Can not found entity with id: " + employeeId);
        }
        // Convert Entity - > DTO
        EmployeeParamDTO employeeParamDTO = new EmployeeParamDTO();
        BeanUtils.copyProperties(employeeOpt.get(), employeeParamDTO);

        model.addAttribute("employeeParamDto", employeeParamDTO);
        return "employee/employee-form";
    }

}
