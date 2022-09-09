package khorsun.app.utill;

import khorsun.app.dao.CustomerDAO;
import khorsun.app.models.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class CustomerValidator implements Validator {
    private final CustomerDAO customerDAO;
@Autowired
    public CustomerValidator(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override/*CustomerValidator will only work with Customer class*/
    public boolean supports(Class<?> aClass) {
        return Customers.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Customers customers=(Customers) o;
        //this method checks if there is a person with this email in the database
if (customerDAO.show(customers.getEmail()).isPresent())
        errors.rejectValue("email","","This email is already taken");

    }
}
