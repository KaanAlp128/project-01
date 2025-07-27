package model;

import java.util.Locale;

public abstract class Person {
    private String iD;
    private String name;
    private String email;
    private static int x;

    public Person(String name) {

        int x = 1;
        this.name = name;
        iD = idGenerator(name);
    }
    public String getıD() {
        return iD;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    private String getInitials(String name){
        String initials;
        String[] lastName = name.split(" ");
        String lastname = lastName[lastName.length -1];

        initials = name.substring(0,1) + lastname.substring(0,1);

        return initials.toLowerCase();
    }

    public String idGenerator(String name){
        x++;
        if(x<10){
            return getInitials(name) + "000" + x;
        }
        if( x >= 10 && x < 100){
            return getInitials(name) + "00" + x;

        }
        if(x>= 100 && x< 1000){
            return getInitials(name) + "0" + x;
        }
        if(x>= 1000 && x < 10000){
            return getInitials(name) + x;
        }
        return null;
    }

    public String toString(){

        return iD + ", " + name + ", " + email;


    }




}
