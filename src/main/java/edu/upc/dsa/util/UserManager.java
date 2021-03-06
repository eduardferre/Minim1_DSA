package edu.upc.dsa.util;

import edu.upc.dsa.models.ListUsers;
import edu.upc.dsa.models.Point;
import edu.upc.dsa.models.User;

import java.util.HashMap;
import java.util.List;


public interface UserManager {
    void addUser (User user);
    HashMap getUsersByAlphabet ();
    User getUser (String idUser);
    void informUserPass (User user, Point point);
    List<Point> getPointsUser (User user);
    ListUsers getUsersByPoint (Point point);
    ListUsers getUsersMaxPoints (ListUsers listUsers);

    Point getIdPoint (String idPoint);
    int numUsers();

}
