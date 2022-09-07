package khorsun.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customers {

    private int id;
    private  String name;
    private  String email;
    private String phoneNumber;
    private Timestamp creationDate;
    private Timestamp modificationDate;






}
