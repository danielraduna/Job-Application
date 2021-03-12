package com.company;

import java.util.ArrayList;

abstract class Department {
     public ArrayList <Employee> employees = new ArrayList<>();
     public ArrayList <Job> jobs = new ArrayList<>();

     public Department(ArrayList<Employee> employees, ArrayList <Job> jobs){
         this.employees = employees;
         this.jobs = jobs;
     }
    public abstract double getTotalSalaryBudget();

    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public void add(Employee employee){
        employees.add(employee);
    }

    public void remove(Employee employee){
        employees.remove(employee);
    }

    public void add(Job job){
        jobs.add(job);
    }

    public ArrayList<Employee> getEmployees(){
        return employees;
    }
}
