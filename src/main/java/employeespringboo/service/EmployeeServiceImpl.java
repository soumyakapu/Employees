package employeespringboo.service;

import employeespringboo.entity.EmployeeEntity;
import employeespringboo.model.Employee;
import employeespringboo.repo.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements  EmployeeService{
    private final EmployeeRepo repo;
 public  EmployeeServiceImpl(final EmployeeRepo repo){
        this.repo=repo;
    }
    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity=new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity);
        repo.save(employeeEntity);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
     List<EmployeeEntity> employeeEntities=repo.findAll();
        List<Employee> employees = employeeEntities
                .stream()
                .map(emp -> new Employee(
                       emp.get_id(),
                        emp.getFirstName(),
                        emp.getLastName(),
                        emp.getEmailId()))
                .collect(Collectors.toList());
        return employees;
    }

    @Override
    public boolean deleteEmployee(String _id) {

        Optional<EmployeeEntity> byId = repo.findById(_id);

        if(byId.isPresent()) {
            EmployeeEntity employee = byId.get();
            repo.delete(employee);
            return true;
        }
        return false;
    }

//    @Override
//    public void deleteEmp(String firstName) {
//        repo.delete(firstName);
//    }

    @Override
    public Employee getEmployeeById(String id) {

        EmployeeEntity employeeEntity
                = repo.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) {

        EmployeeEntity employeeEntity
                = repo.findById(id).get();
        employeeEntity.setEmailId(employee.getEmailId());
        employeeEntity.setFirstName(employee.getFirstName());
        employeeEntity.setLastName(employee.getLastName());

        repo.save(employeeEntity);
        return employee;
    }
}
