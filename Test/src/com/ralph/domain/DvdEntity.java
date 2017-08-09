package com.ralph.domain;

import java.util.Date;

/**
 * Created by guozhanxian on 2017/8/1.
 */
public class DvdEntity
{
    private String name;
    private double price;
    private Date rentDate;
    private boolean isRent;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public Date getRentDate()
    {
        return rentDate;
    }

    public void setRentDate(Date rentDate)
    {
        this.rentDate = rentDate;
    }

    public boolean isRent()
    {
        return isRent;
    }

    public void setRent(boolean rent)
    {
        isRent = rent;
    }

    public DvdEntity(String name, double price, Date rentDate, boolean isRent)
    {
        this.name = name;
        this.price = price;
        this.rentDate = rentDate;
        this.isRent = isRent;
    }

    @Override
    public String toString()
    {
        return "DvdEntity{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rentDate=" + rentDate +
                ", isRent=" + isRent +
                '}';
    }
}
