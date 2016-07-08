package com.ks.poc.testfragmentapplication;

import java.util.Date;

/**
 * Created by Krit on 7/7/2016.
 */
public class CompoundClass {
    private String name;
    private int number;
    private boolean flag;
    private Date startDate;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public CompoundClass(boolean flag, String name, int number, Date startDate) {
        this.flag = flag;
        this.name = name;
        this.number = number;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "CompoundClass{" +
                "flag=" + flag +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", startDate=" + startDate +
                '}';
    }

    public String toMultiLineString() {
        return  "flag=" + flag + System.getProperty("line.separator") +
                "name='" + name + '\'' + System.getProperty("line.separator") +
                "number=" + number + System.getProperty("line.separator") +
                "startDate=" + startDate;
    }
}
