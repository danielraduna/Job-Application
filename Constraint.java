package com.company;

class Constraint{

    public Integer an_absolvire_inf;
    public Integer an_absolvire_sup;

    public Double medie_inf;
    public Double medie_sup;

    public int ani_experienta_inf;
    public int ani_experienta_sup;

    public Constraint(Integer an_absolvire_inf, Integer an_absolvire_sup){
        this.an_absolvire_inf = an_absolvire_inf;
        this.an_absolvire_sup = an_absolvire_sup;
        medie_inf = medie_sup = null;
        ani_experienta_sup = ani_experienta_inf = -1;
    }

    public Constraint(Double medie_inf, Double medie_sup){
        this.medie_inf = medie_inf;
        this.medie_sup = medie_sup;

        an_absolvire_sup = an_absolvire_inf = null;
        ani_experienta_sup = ani_experienta_inf = -1;
    }

    public Constraint(int ani_experienta_inf, int ani_experienta_sup){
        this.ani_experienta_inf = ani_experienta_inf;
        this.ani_experienta_sup = ani_experienta_sup;
        an_absolvire_sup = an_absolvire_inf = null;
        medie_inf = medie_sup = null;
    }

}


