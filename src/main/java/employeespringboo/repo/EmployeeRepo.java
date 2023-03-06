package employeespringboo.repo;

import employeespringboo.entity.EmployeeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends MongoRepository<EmployeeEntity,String > {
//    void delete(String firstName);
}
