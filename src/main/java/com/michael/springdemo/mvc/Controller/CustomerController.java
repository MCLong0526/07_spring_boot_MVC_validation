package com.michael.springdemo.mvc.Controller;

import com.michael.springdemo.mvc.Domain.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Value("${places}")
    private List<String> places;


    @InitBinder
    public void initBinder(WebDataBinder dataBinder){

        // this line is removes the leading and trailing spaces from the form input
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        // this line is to let spring know that as long as is string, clean up first before put it in object.
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model theModel){
        theModel.addAttribute("customer", new Customer());
        theModel.addAttribute("places", places);
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm (@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult, Model theModel){
        theModel.addAttribute("places", places);
        if(theBindingResult.hasErrors()){
            return "customer-form";
        }else{
            return "customer-confirmation";
        }

    }

}
