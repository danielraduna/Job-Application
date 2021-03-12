package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Manager extends Employee{
    List<Request> requests = new ArrayList<>();
    public Manager(){
        super();
    }
    public Manager(String companie, double salariu){
        super(companie, salariu);
    }
    public void process(Job job){

        Collections.sort(requests);//sortam lista de Requsest
        Employee employee = new Employee();
        int i, j, k, t;
        int copie = job.noPositions;
        for(i = 0; i < job.noPositions && i < requests.size(); i++){//parcurgem aceasta lista
            if(Application.getInstance().Users.contains((User) requests.get(i).getValue1())){//daca userul din Request  este in lista de users din aplicatie
                //inseamna ca va fi angajat
                copie--;//scadem un loc
                Application.getInstance().Users.remove((User) requests.get(i).getValue1());//il stergem din lista de users
                employee =  ((User) requests.get(i).getValue1()).convert();//il convertim in Employee

                Company company = Application.getInstance().getCompany(companie);
                for(j = 0 ; j < company.departments.size(); j++)
                    for(k = 0; k < company.departments.get(j).jobs.size(); j++)//cautam jobul in companie
                        if(job == company.departments.get(j).jobs.get(k))
                            company.departments.get(j).employees.add(employee);//adaugam angajatul in lista de angajati al acelui departament

            }
            else
                job.noPositions++;
        }
        if(copie == 0)
            job.deschis = false;
        job.noPositions = copie;
    }
}
