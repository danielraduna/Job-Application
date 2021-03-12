package com.company;

class Recruiter extends Employee{
    public double rating;
    public Recruiter(){
        super();
        rating = 5;
    }
    public int evaluate(Job job, User user){
        int evaluare = (int) (rating * user.getTotalScore());//calculam dupa formula data
        int i;
        for(i = 0; i < Application.getInstance().Companies.size(); i++)//cautam in lista de companii
            if(job.nume_companie.equals(Application.getInstance().Companies.get(i).name))//comparam numele companiilor cu numele Companiei jobului
                Application.getInstance().Companies.get(i).manager.requests.add(new Request(job, user, this,rating * user.getTotalScore()));
                //adaugam in lista de Request a managerului companiei respective, un nou Request
        rating += 0.1;
        return evaluare;
    }
}
