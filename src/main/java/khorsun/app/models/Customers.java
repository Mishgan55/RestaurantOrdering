package khorsun.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customers {

    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(max=50,message = "Name should be between 0 and 50")
    private  String name;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "email should be valid")
    private  String email;
    @NotEmpty(message = "Phone number should not be empty")
    private String phoneNumber;
    private Timestamp creationDate;
    private Timestamp modificationDate;






}
