package com.company;

import java.util.ArrayList;

class Management extends Department{

    public Management(ArrayList<Employee> employees, ArrayList<Job> jobs) {
        super(employees, jobs);
    }

    @Override
    public double getTotalSalaryBudget() {
        int i;
        double s = 0;
        for(i = 0 ; i < employees.size(); i++ ){
            s += employees.get(i).salariu + (employees.get(i).salariu * 0.16);
        }
        return s;
    }
}
