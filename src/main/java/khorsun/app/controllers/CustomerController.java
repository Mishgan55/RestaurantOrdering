package khorsun.app.controllers;

import khorsun.app.dao.CustomerDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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







}
