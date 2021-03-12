package com.company;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

class User extends Consumer {
     ArrayList<String> companii = new ArrayList<>();


    public Employee convert(){
        Employee employee = new Employee();
        employee.resume = this.resume;
        employee.social_network = this.social_network;
        return employee;
    }

    public Double getTotalScore(){

        Double scor = 0.0;
        Double ani_experienta = 0.0;
        int i;

        for(i = 0; i < this.resume.getExperienta().size(); i++)//parcurgem lista cu exeperiente a unui user
            ani_experienta += Math.ceil((double) ChronoUnit.DAYS.between(this.resume.getExperienta().get(i).start_date, this.resume.getExperienta().get(i).end_date) / 365);
            //calculam diferenta dintre data de inceput si data de sfarsit a fiecarei experiente, si aproximam prin adaos;
        scor = ani_experienta * 1.5 + meanGPA();//folosim formula
        return scor;
    }
}
