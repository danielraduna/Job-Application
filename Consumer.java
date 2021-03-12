package com.company;

import javax.swing.event.ListSelectionListener;
import java.util.*;

abstract  class Consumer {
    class Resume{
        private Information information = new Information();
        private List<Education> educatie = new ArrayList<>();
        private List<Experience> experienta = new ArrayList<>();

        public Resume(){

        }
        public Resume(BuilderResume builder){

        }
        public  List<Experience> getExperienta(){
            return experienta;
        }
        public  List<Education> getEducatie(){
            return educatie;
        }
        public Information getInformation(){
            return information;
        }

        public  class BuilderResume{
            private Information information = new Information();
            private List<Education> educatie = new ArrayList<>();
            private List<Experience> experienta = new ArrayList<>();

            public BuilderResume(Information information){
                this.information = information;
            }
            public BuilderResume educatie( List<Education> educatie){
                this.educatie = educatie;
                return this;
            }
            public BuilderResume experienta( List<Experience> experienta) {
                this.experienta = experienta;
                return this;
            }
            public Resume build(){
                return new Resume(this);
            }
        }

    }
    Resume resume = new Resume();
    ArrayList<Consumer> social_network = new ArrayList<>();
    public void add(Education education){
        resume.educatie.add(education);
        Collections.sort(resume.educatie);
    }
    public void add(Experience experience){
        resume.experienta.add(experience);
        Collections.sort(resume.experienta);
    }
    public void add(Consumer consumer){
        social_network.add(consumer);
    }
    public int getDegreeInFriendship(Consumer consumer){
        int  i;
        HashMap<Consumer, Integer> visit = new HashMap<>();
        LinkedList<Consumer> coada = new LinkedList<>();
        Consumer consumer1;

        coada.add(this);//punem in "coada" consumerul curent
        visit.put(this, 0);//si il marcam ca fiind vizitat

        while (!coada.isEmpty()){
            consumer1 = coada.poll();//sccoatem din coada un element
            for(i = 0; i < consumer1.social_network.size();i++) {//parcurgem pritenii lui
                if(consumer1.social_network.get(i) == consumer)//daca gasim consumerul cautat
                    return visit.get(consumer1) + 1;//returnam nivelul consumerului anterior + 1

                if (!visit.containsKey(consumer1.social_network.get(i))) {//verificam daca prietenii au fost vizitati deja
                    visit.put(consumer1.social_network.get(i), visit.get(consumer1) + 1);//daca nu ii marcam
                    coada.add(consumer1.social_network.get(i));//si adaugam in coada.
                }
            }

        }
        return -1;
    }
    public void remove(Consumer consumer){
        social_network.remove(consumer);
    }
    public Integer getGraduationYear(){
        Integer an = null;
        int i;
        for(i = 0; i < resume.educatie.size(); i++)
            if(resume.educatie.get(i).niv_educatie.equals("licenta"))
                if(resume.educatie.get(i).end_date != null)
                    an = resume.educatie.get(i).end_date.getYear();
        return an;

    }
    public Double meanGPA(){
        Double media = 0.0;
        int s = 0, i;
        for(i = 0; i < resume.educatie.size(); i++)
            s += resume.educatie.get(i).medie;
        media = (double)(s / resume.educatie.size());
        return media;
    }

}
