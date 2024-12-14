package com.example.covo.model;

import java.util.Date;

public class Ride {
    private int id;
    private String startPoint;
    private String destination;
    private Date departureTime;
    private int availableSeats;
    private double price;

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
