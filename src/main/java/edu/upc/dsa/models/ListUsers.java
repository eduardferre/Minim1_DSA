package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListUsers {
    private int numUsers;
    private List<User> listUsers = new ArrayList<>();

    public ListUsers(int numUsers) {
        this.numUsers = numUsers;
    }

    public void addUser (User user) {
        this.listUsers.add(user);
        numUsers++;
    }
}
