package com.company;

import java.util.ArrayList;

class Company {
    public String name = new String();
    public Manager manager = new Manager();
    public ArrayList<Department> departments = new ArrayList<>();
    public ArrayList<Recruiter> recruiters = new ArrayList<>();

    public Company(){

    }

    public Company(String nume, Manager manager, ArrayList<Department>departments, ArrayList<Recruiter> recruiters ){
        name = nume;
        this.manager = manager;
        this.departments = departments;
        this.recruiters = recruiters;
    }
    public void add(Department department){
        departments.add(department);
    }

    public void add(Recruiter recruiter){
        recruiters.add(recruiter);
        int i;
        for(i = 0; i < departments.size(); i++)
            if(departments.get(i) instanceof IT){
                departments.get(i).employees.add(recruiter);
                break;
            }
    }

    public void add(Employee employee, Department department){
        int i;
        for(i = 0; i < departments.size(); i++)
            if(departments.get(i) == department){
                departments.get(i).employees.add(employee);
                break;
            }
    }
    public void remove(Employee employee){
        int i, j;
        if(recruiters.contains(employee))
            recruiters.remove(employee);
        for(i = 0; i < departments.size();i++)
            if(departments.get(i).employees.contains(employee))
                departments.get(i).employees.remove(employee);

    }

    public void remove(Department department){
        departments.remove(department);
    }

    public void remove(Recruiter recruiter){
        recruiters.remove(recruiter);
        int i;
        for(i = 0; i < departments.size(); i++)
            if(departments.get(i) instanceof IT)
                departments.get(i).employees.remove(recruiter);
    }

    public void move(Department source, Department destination){
        int i, i_source = -1;
        for(i = 0; i < departments.size(); i++)
            if(departments.get(i) == source){
                i_source = i;
                break;
            }

        for(i = 0; i <departments.get(i_source).employees.size(); i++)
            move(departments.get(i_source).employees.get(i), destination);
    }
    public void move(Employee employee, Department newDepartment){
        int i;
        for(i = 0; i < departments.size();i++)
            if(departments.get(i).employees.contains(employee))
                departments.get(i).employees.remove(employee);

        for(i = 0; i < departments.size(); i++)
            if(departments.get(i) == newDepartment)
                departments.get(i).employees.add(employee);
    }

    public boolean contains(Department department){

        return departments.contains(department);
    }

    public boolean contains(Employee employee){
        int i;
        for(i = 0; i < departments.size(); i++)
            if(departments.get(i).employees.contains(employee))
                return true;
        return false;
    }

    public boolean contains(Recruiter recruiter){
        return recruiters.contains(recruiter);
    }



    public Recruiter getRecruiter(User user){
        int i, max = 0, j;
        ArrayList<Recruiter> recruiters_max = new ArrayList<>();

        for(i = 0 ; i < recruiters.size(); i++)
            if(user.getDegreeInFriendship(recruiters.get(i)) > max)
                max = user.getDegreeInFriendship(recruiters.get(i));

        for(i = 0 ; i < recruiters.size(); i++)
            if(user.getDegreeInFriendship(recruiters.get(i)) == max)
                recruiters_max.add(recruiters.get(i));

        if(recruiters_max.size() == 1)
            return recruiters_max.get(0);
        else{
            double rating_max = 0;
            Recruiter aux = new Recruiter();
            for(i = 0; i < recruiters_max.size(); i++)
                if(recruiters_max.get(i).rating > rating_max){
                    rating_max = recruiters_max.get(i).rating;
                    aux = recruiters_max.get(i);
                }
            return aux;
        }

    }
    public ArrayList<Job> getJobs(){
        ArrayList<Job> jobs = new ArrayList<>();
        int i, j;
        for(i = 0; i < departments.size(); i++)
            for(j = 0 ; j < departments.get(i).jobs.size(); j++)
                if(departments.get(i).jobs.get(j).deschis)
                    jobs.add(departments.get(i).jobs.get(j));
        return jobs;
    }
}
