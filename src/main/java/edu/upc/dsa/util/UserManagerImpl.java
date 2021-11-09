package edu.upc.dsa.util;

import edu.upc.dsa.models.ListUsers;
import edu.upc.dsa.models.Point;
import edu.upc.dsa.models.User;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class UserManagerImpl implements UserManager {

    private static UserManagerImpl instance;

    HashMap <String, User> usersHashMap = new HashMap<String, User>();

    final static Logger logger = Logger.getLogger(UserManagerImpl.class);


    /**Singleton */
    private UserManagerImpl() {
    }
    public static UserManager getInstance(){
        if (instance == null) {
            instance = new UserManagerImpl();
        }
        return instance;
    }

    @Override
    public void addUser(User user) {
        logger.info("New user to add: " + user);
        this.usersHashMap.put(user.getIdUser(), user);
        logger.info("User added.");
    }

    @Override
    public HashMap<String, User> getUsersByAlphabet() {
        logger.info("Listado de usuarios por orden alfabetico");
        return this.usersHashMap;
    }


    @Override
    public User getUser(String idUser) {
        logger.info("Información del usuario con id: " + idUser);
        User u = this.usersHashMap.get(idUser);

        if (u == null) {
            logger.info("ERROR, usuario no encontrado");
            return u;
        }
        else {
            logger.info("Usuario encontrado");
            return u;
        }
    }

    @Override
    public int informUserPass(User user, Point point) { //0 si no ha pasado, 1 si ha pasado
        logger.info("Buscando si usuario: " + user.getIdUser() + " ha pasado por el punto con id: " + point.getIdPoint());

        List<Point> listPointsUser = user.getListPointsUser();
        int found = 0; //si lo encuentra se pone 1

        for (Point p : listPointsUser) {
            if (Objects.equals(p.getIdPoint(), point.getIdPoint())) {
                found = 1;
                break;
            }
        }

        if (found == 0) { logger.info("El usuario no ha pasado por el punto"); }
        else { logger.info("El usuario ha pasado por el punto"); }

        return found;
    }

    @Override
    public List<Point> getPointsUser(User user) {
        logger.info ("Pedido para saber los puntos del usuario: " + user.getIdUser());
        return user.getListPointsUser();
    }

    @Override
    public ListUsers getUsersByPoint(Point point, ListUsers listUsers) {
        return null;
    }

    @Override
    public ListUsers getUsersMaxPoints(ListUsers listUsers) {
        return null;
    }

    @Override
    public int numUsers() {
        return usersHashMap.size();
    }
}
