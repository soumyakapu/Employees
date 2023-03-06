package employeespringboo.service;

import employeespringboo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee (Employee employee);
    List<Employee> getAllEmployee();
    boolean deleteEmployee(String _id);
//    void deleteEmp(String firstName);
    Employee getEmployeeById(String id);
    Employee updateEmployee(String id,Employee employee);
}
