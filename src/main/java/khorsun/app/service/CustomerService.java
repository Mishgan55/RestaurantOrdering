package khorsun.app.service;

import khorsun.app.models.Customers;

import java.util.List;

public interface CustomerService<T,K> {


    T show(int id);




    List<T> index();


     void save(Customers customers);

    void update(int id,Customers updatedCustomers);

    void delete(int id);
}
