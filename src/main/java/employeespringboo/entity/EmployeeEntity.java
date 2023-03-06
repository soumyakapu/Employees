package employeespringboo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class EmployeeEntity {
@Id
   private String _id;

    private String firstName;
    private String lastName;
    private String emailId;
}
