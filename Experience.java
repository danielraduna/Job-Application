package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

class Experience implements Comparable<Experience>{

    public LocalDate start_date;
    public LocalDate end_date;
    public String pozitie;
    public String companie;

    public Experience(LocalDate start_date, LocalDate end_date, String pozitie, String companie) throws InvalidDatesException {
        this.start_date = start_date;
        this.end_date = end_date;
        this.pozitie = pozitie;
        this.companie  = companie;

        if(end_date != null && start_date.compareTo(end_date) > 0)
            throw new InvalidDatesException("Date intoduse gresit");
    }

    public String toString(){
        return start_date + "\n" +  end_date + "\n" +  pozitie + "\n" + companie;
    }

     @Override
     public int compareTo(Experience o) {
         if(this.end_date != null && o.end_date != null){
           return o.end_date.compareTo(this.end_date);
         }
         else
             return this.companie.compareTo(o.companie);
     }
 }

 /*class Test{
     public static void main(String[] args) throws InvalidDatesException {
         ArrayList <Experience> lista = new ArrayList<>();
         Experience ex1 = new Experience(LocalDate.now(),LocalDate.now().plusYears(1) , "CEO", "Netflix");
         Experience ex2 = new Experience(LocalDate.now().plusYears(2), LocalDate.now().plusYears(4), "CEO", "Tacebook");
         Experience ex3 = new Experience(LocalDate.now().plusYears(5), null, "CEO", "BMW");
         lista.add(ex1);
         lista.add(ex2);
         lista.add(ex3);
         Collections.sort(lista);
         for(Experience ex : lista)
             System.out.println(ex);
     }
 }*/