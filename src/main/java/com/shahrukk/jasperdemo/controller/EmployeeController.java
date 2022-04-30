package com.shahrukk.jasperdemo.controller;

import com.shahrukk.jasperdemo.entity.Employee;
import com.shahrukk.jasperdemo.repository.EmployeeRepository;
import com.shahrukk.jasperdemo.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private ReportService service;

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<String> postEmployee(@RequestBody Employee employee){
        repository.save(employee);
        return new ResponseEntity<>("Employee added succsessfully!", HttpStatus.OK);

    }


    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return service.exportreport(format);
    }
}
