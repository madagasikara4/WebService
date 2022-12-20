package com.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.Date;

@Entity(name = "expiration")
public class Expiration {

    @Id
    @Column(name = "token")
    private String idtoken;
    @Column
    private Date dateexpiration;

    public Expiration(){}

    public Expiration(String idtoken, Date dateexpiration) {
        this.idtoken = idtoken;
        this.dateexpiration = dateexpiration;
    }

    public Expiration(Token token){
        this.idtoken=token.getToken();
        this.dateexpiration=Expiration.getDateexpiration(token);
    }

    public String getIdtoken() {
        return idtoken;
    }

    public void setIdtoken(String idtoken) {
        this.idtoken = idtoken;
    }

    public Date getDateexpiration() {
        return dateexpiration;
    }

    public void setDateexpiration(Date dateexpiration) {
        this.dateexpiration = dateexpiration;
    }

    public static Date getDateexpiration(Token token) {
        Date creation=token.getDatecreation();
        Calendar cal=Calendar.getInstance();
        cal.setTime(creation);
        Double d=new Double(token.getDuree());
        cal.add(Calendar.SECOND,d.intValue());
        return cal.getTime();
    }
}
