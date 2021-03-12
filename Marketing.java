package com.company;

import java.util.ArrayList;

class Marketing extends Department {
    public Marketing(ArrayList<Employee> employees, ArrayList<Job> jobs) {
        super(employees, jobs);
    }

    @Override
    public double getTotalSalaryBudget() {
        int i;
        double s = 0;
        for(i = 0 ; i < employees.size(); i++ ){
            if(employees.get(i).salariu > 5000)
                s += employees.get(i).salariu + (employees.get(i).salariu * 0.1);
            else
                if(employees.get(i).salariu < 3000)
                    s += employees.get(i).salariu;
                else
                    s += employees.get(i).salariu + (employees.get(i).salariu * 0.16);
        }

        return s;
    }
}
