package com.company;

class Employee  extends Consumer{
    String companie;
    double salariu;
    public Employee(String companie, double salariu){
        this.companie = companie;
        this.salariu = salariu;
    }

    public Employee(){
        companie = "";
        salariu = 0;
    }
}
