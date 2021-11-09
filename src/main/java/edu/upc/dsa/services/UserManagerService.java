package edu.upc.dsa.services;

import edu.upc.dsa.models.Point;
import edu.upc.dsa.models.User;
import edu.upc.dsa.util.UserManager;
import edu.upc.dsa.util.UserManagerImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/User", description = "End point to User Service")
@Path("/User")
public class UserManagerService {
    private UserManager manager;

    public UserManagerService(){
        this.manager = UserManagerImpl.getInstance();
        if (true){
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
    }

    //----------------------------------------------

    @POST
    @ApiOperation(value = "Add a user to the system.", notes = "Additional information.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully added user.")
    })
    @Path("/addUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser (User user) {
        this.manager.addUser(user);
        return Response.status(201).build();
    }


    @GET
    @ApiOperation(value = "Get certain user", notes = "Additional information.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List"),
            @ApiResponse(code = 404, message= "ERRROR")
    })

    @Path("/getUser/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("idUser") String idUser){
        if (this.manager.getUser(idUser) != null){
            User user = this.manager.getUser(idUser);
            return Response.status(201).entity(user).build();
        }
        else{
            return Response.status(404).build();
        }
    }





}
