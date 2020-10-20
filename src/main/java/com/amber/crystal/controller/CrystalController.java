
package com.amber.crystal.controller;

import com.amber.crystal.model.Employee;
import com.amber.crystal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CrystalController implements CommandLineRunner {

    private final EmployeeRepository repository;

    @Autowired
    public CrystalController(EmployeeRepository repository) {
        this.repository = repository;
    }

    /*@RequestMapping(value = "/" , method = RequestMethod.GET)
    public String Crystal() {
        return "index";
    }*/

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new Employee("Frodo", "Baggins", "ring bearer"));
    }

}

