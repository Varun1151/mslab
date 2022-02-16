package com.example.Student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table 
public class Studdata {
    // @Id
    // private int id;
    @Id
    private String usn;
    @Column(name="name")
    private String name;
    @Column(name="cgpa")
    private float cgpa;
	public Studdata()
	{
		
	}
    public Studdata(String string2, String string3,float float1) {
        // id=int1;
		usn=string2;
		name=string3;
		cgpa=float1;
    }

    // public int getId() {
    //     return id;
    // }

    // public void setId(int id) {
    //     this.id = id;
    // }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCgpa(){
    	return cgpa;
    }

    public void setCgpa(float cgpa){
    	this.cgpa = cgpa;
    }
}
