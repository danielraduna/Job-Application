package com.company;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

class Job {
     public String nume = new String();
     public String nume_companie = new String();
     public boolean deschis;
     public ArrayList<User> users = new ArrayList<>();
     public int noPositions;
     public double salariu;
    Constraint an_absolvire;
    Constraint medie;
    Constraint ani_experienta;

     public Job(String nume, String nume_companie, boolean deschis, ArrayList<User> users,int noPositions, double salariu, Constraint an_absolvire, Constraint medie, Constraint ani_experienta){
         this.nume = nume;
         this.nume_companie = nume_companie;
         this.deschis = deschis;
         this.users = users;
         this.noPositions = noPositions;
         this.salariu = salariu;
         this.an_absolvire = an_absolvire;
         this.medie = medie;
         this.ani_experienta = ani_experienta;
     }

     public Job(){
         deschis = false;
         noPositions = 0;
         salariu = 0.0;
     }

     public void apply(User user){
            Company company = Application.getInstance().getCompany(nume_companie);
            Recruiter recruiter = company.getRecruiter(user);
            recruiter.evaluate(this, user);
     }


    public boolean meetsRequirments(User user){

         if(user.getGraduationYear() < an_absolvire.an_absolvire_inf || user.getGraduationYear() > an_absolvire.an_absolvire_sup )
             return false;
         if(user.meanGPA() < medie.medie_inf || user.meanGPA() > medie.medie_sup )
             return false;
         int ani = 0, i;

        for(i = 0; i < user.resume.getExperienta().size(); i++)
            ani += (int)Math.ceil((double) ChronoUnit.DAYS.between(user.resume.getExperienta().get(i).start_date, user.resume.getExperienta().get(i).end_date) / 365);
        if(ani < ani_experienta.ani_experienta_inf || ani > ani_experienta.ani_experienta_sup )
            return false;
         return  true;
    }
}
