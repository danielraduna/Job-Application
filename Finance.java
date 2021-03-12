package com.company;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

class Finance extends  Department{
    public Finance(ArrayList<Employee> employees, ArrayList<Job> jobs) {
        super(employees, jobs);
    }

    @Override
     public double getTotalSalaryBudget() {
         int i, j;
         double s = 0;
         for(i = 0 ; i < employees.size(); i++ ){
             for(j = 0; j < employees.get(i).resume.getExperienta().size(); j++){
                 if(employees.get(i).resume.getExperienta().get(j).end_date == null){
                    if(ChronoUnit.DAYS.between(employees.get(i).resume.getExperienta().get(j).start_date, LocalDate.now()) < 365)
                        s += employees.get(i).salariu + (employees.get(i).salariu * 0.1);
                    else
                        s += employees.get(i).salariu + (employees.get(i).salariu * 0.16);
                 }
             }
         }
         return s;
     }
 }
