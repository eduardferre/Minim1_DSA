package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class User {
    private String idUser;
    private List<Point> listPointsUser = new LinkedList<>();

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdUser() {
        return idUser;
    }

    public User(String idUser){
        this.idUser = idUser;
    }

    public void addPoint(Point point) {
        listPointsUser.add(point);
        point.addUserToPoint(this);
    }

    public List<Point> getListPointsUser() {
        return listPointsUser;
    }

    public User(){};

}
