package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

class Education implements Comparable<Education> {

    public LocalDate start_date;
    public LocalDate end_date;
    public String institutie;
    public String niv_educatie;
    public double medie;

    public Education(LocalDate start_date, LocalDate end_date, String institutie, String niv_educatie, double medie) throws InvalidDatesException {
        this.start_date = start_date;
        this.end_date = end_date;
        this.institutie = institutie;
        this.niv_educatie = niv_educatie;
        this.medie = medie;

        if(end_date != null && start_date.compareTo(end_date) > 0)
            throw new InvalidDatesException("Date intoduse gresit");
    }

    public String toString(){
        return start_date + "\n" +  end_date + "\n" +  institutie + "\n" + niv_educatie + "\n" +  medie;
    }
    @Override
    public int compareTo(Education o) {

        if(this.end_date != null && o.end_date != null){
            int res = o.end_date.compareTo(this.end_date);
            double d = o.medie - this.medie;

            if(res != 0)
                return res;
            else{
                return (int) d;
            }
        }
        else
            return this.start_date.compareTo(o.start_date);

    }
}

