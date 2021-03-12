package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

class  Application {

    public ArrayList<Company> Companies = new ArrayList<>();
    public ArrayList<User>  Users = new ArrayList<>();

    private static Application single_instance = new Application();

    private Application(){

    }
    public static Application getInstance(){
        return single_instance;
    }

    public ArrayList<Company> getCompanies(){
        return  Companies;
    }
    public Company getCompany(String name){
        Company a = new Company();
        for(Company i : Companies) {
            if(i.name.equals(name))
                a = i;
        }
        return a;
    }

    public void add(Company company){
        Companies.add(company);
    }

    public void add(User user){
        Users.add(user);
    }

    public boolean remove(Company company){
        if(Companies.contains(company)){
            Companies.remove(company);
            return true;
        }
        else
            return false;
    }

    public boolean remove(User user){
        if(Users.contains(user)){
            Users.remove(user);
            return true;
        }
        else
            return false;
    }
    public ArrayList<Job> getJobs(List<String> companies){
        ArrayList<Job> jobs = new ArrayList<>();
        int i, j;
        for(i = 0; i < companies.size(); i++)
            for(j = 0 ; j < Companies.size(); j++)
                if(companies.get(i).equals(Companies.get(j).name)){
                    jobs.addAll(Companies.get(i).getJobs());
                }
        return jobs;
    }
}
