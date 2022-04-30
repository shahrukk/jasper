package com.shahrukk.jasperdemo.service;

import com.shahrukk.jasperdemo.entity.Employee;
import com.shahrukk.jasperdemo.repository.EmployeeRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String exportreport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\dell\\Desktop\\Report";
        List<Employee> epmloyee = employeeRepository.findAll();

        //Load file and compile it
        File file = ResourceUtils.getFile("classpath:employee.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(epmloyee);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdby","shahrukk");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);
        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path+"\\employee.html");
        }
        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, path+"\\employee.pdf");
        }
        return "report generate in path: "+path;
    }
}
