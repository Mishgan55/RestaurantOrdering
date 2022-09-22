package khorsun.app.controllers;


import khorsun.app.dao.ProductsDao;
import khorsun.app.models.Products;
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


@Controller
@RequestMapping("/products")
public class ProductsController {
    private final ProductsDao productsDao;

    public ProductsController(ProductsDao productsDao) {
        this.productsDao = productsDao;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("product",productsDao.index());
        return "products/index-product";

    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id")int id,Model model){
        model.addAttribute("product",productsDao.show(id));
        return "products/show-product";

    }

    @GetMapping("/new-product")
    public String newProduct(Model model ){
        model.addAttribute("product", new Products());
        return "products/new-product";
    }

    @PostMapping()
    public String create(@ModelAttribute("product")@Valid Products products){
        productsDao.save(products);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit-product")
    public String edit(@PathVariable("id")int id,Model model){
        model.addAttribute("product",productsDao.show(id));
        return "products/edit-product";

    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("product")Products products,
                         @PathVariable("id")int id){
        productsDao.update(id,products);
        return "redirect:/products";

    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id){
        productsDao.delete(id);
        return "redirect:/products";

    }
}
