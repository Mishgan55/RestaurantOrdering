package khorsun.app.controllers;

import khorsun.app.dao.CustomerDAO;
import khorsun.app.models.Customers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;

@Controller
@RequestMapping("/customer")
public class CustomerController {

private final CustomerDAO customerDAO;


    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("customer",customerDAO.index());
        return "customer/index";

    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id")int id,Model model){
        model.addAttribute("customer",customerDAO.show(id));

        return  "customer/show";

    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("customer",new Customers());
        return "customer/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("customer")@Valid Customers customers){
        customerDAO.save(customers);

        return "redirect:/customer";


    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id")int id,Model model){
        model.addAttribute("customer",customerDAO.show(id));
        return "customer/edit";

    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("customer")Customers customers,@PathVariable("id")int id){
        customerDAO.update(id,customers);
        return "redirect:/customer";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id){
        customerDAO.delete(id);
        return "redirect:/customer";

    }










}
