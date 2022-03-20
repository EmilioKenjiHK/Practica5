package com.example.demo.Services;

import java.io.Serializable;

public class Respuesta implements Serializable{
    private String name;
    private String lname;
    private String genero;
    private String opinion;

    public Respuesta(String name, String lname, String genero, String opinion)
    {
        this.setName(name);
        this.setLName(lname);
        this.setGender(genero);
        this.setOpinion(opinion);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setLName(String lname)
    {
        this.lname = lname;
    }

    public String getLName()
    {
        return this.lname;
    }

    public void setGender(String genero)
    {
        this.genero = genero;
    }

    public String getGender()
    {
        return this.genero;
    }

    public void setOpinion(String opinion)
    {
        this.opinion = opinion;
    }

    public String getOpinion()
    {
        return this.opinion;
    }

}
