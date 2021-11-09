package edu.upc.dsa;
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.ListUsers;
import edu.upc.dsa.models.Point;
import edu.upc.dsa.util.UserManagerImpl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserManagerTest {

    @After
    public void tearDown() {    }


    @Before
    public void setUp() {
        //Añadir usuarios
        User user1 = new User("Eduard");
        User user2 = new User("Mikel");
        User user3 = new User("Txell");
        User user4 = new User("Xavi");

        //Afegir punts
        Point point1 = new Point("P1");
        Point point2 = new Point("P2");
        Point point3 = new Point("P3");
        Point point4 = new Point("P4");
        Point point5 = new Point("P5");

        user1.addPoint(point1);
        user1.addPoint(point3);

        user2.addPoint(point1);
        user2.addPoint(point2);
        user2.addPoint(point5);

        user3.addPoint(point4);

        user1.addPoint(point3);

        UserManagerImpl.getInstance().addUser(user1);
        UserManagerImpl.getInstance().addUser(user2);
        UserManagerImpl.getInstance().addUser(user3);
        UserManagerImpl.getInstance().addUser(user4);

    }

    @Test
    public void testGetUsersByAlphabet(){
        //Primer pedido
        Assert.assertEquals(4, UserManagerImpl.getInstance().numUsers());
        // List<User> users = UserManagerImpl.getInstance().getUsersByAlphabet();
        //  Assert.assertEquals("Eduard", users.get(0).getIdUser());
    }

}
