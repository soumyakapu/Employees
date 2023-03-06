package employeespringboo.controller;

import employeespringboo.model.Employee;
import employeespringboo.service.EmployeeService;
import employeespringboo.service.EmployeeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    private final EmployeeService employeeService;
  public EmployeeController(final EmployeeService employeeService){
        this.employeeService=employeeService;
    }
    @PostMapping("/create")
    public Employee createEmployee(@RequestBody Employee employee){
      return employeeService.createEmployee(employee);
    }
    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return  employeeService.getAllEmployee();
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable(value = "id") String  id) {
        boolean deleted = false;
        deleted = employeeService.deleteEmployee(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String _id) {
        Employee employee = null;
        employee = employeeService.getEmployeeById(_id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable String id,
                                                   @RequestBody Employee employee) {
        employee = employeeService.updateEmployee(id, employee);
        return ResponseEntity.ok(employee);
    }
//    @DeleteMapping("/delete/{firstName}")
//    public  void deleteEmp(String firstName){
//      employeeService.deleteEmp(firstName);
//    }

}
