package edu.upc.dsa.models;

import java.util.LinkedList;
import java.util.List;


public class Point {
    private String idPoint;
    private List<User> listUsersPoint = new LinkedList<>();

    public void setIdPoint (String idPoint) { this.idPoint = idPoint; }

    public String getIdPoint() {
        return idPoint;
    }

    public Point(String idPoint) {
        this.idPoint = idPoint;
    }

    public Point() {
    }

    public List<User> getListUsersPoint() {
        return this.listUsersPoint;
    }

    public void setListUsersPoint(List<User> listUsersPoint) {
        this.listUsersPoint = listUsersPoint;
    }

    public void addUserToPoint (User user) {
        listUsersPoint.add(user);
    }
}