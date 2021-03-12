package com.company;

import java.util.ArrayList;

class DepartmentFactory {
    public Department factory(String type, ArrayList<Employee> employees, ArrayList <Job> jobs){
        if(type.equalsIgnoreCase("IT"))
            return new IT(employees, jobs);
        if(type.equalsIgnoreCase("MARKETING"))
            return new Marketing(employees, jobs);
        if(type.equalsIgnoreCase("MANAGEMENT"))
            return new Management(employees, jobs);
        if(type.equalsIgnoreCase("FINANCE"))
            return new Finance(employees, jobs);
        return null;
    }
 }
