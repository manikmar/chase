package com.chase.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Employee /*implements Comparable<Employee>*/{

    private int id;
    private String name;
    private double salary;
    private String department;

}
