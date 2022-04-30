package com.shahrukk.jasperdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class Employee {
    @Id
    private int id;
    private String name;
    private String designation;
    private double salary;
    private String doj;
}
