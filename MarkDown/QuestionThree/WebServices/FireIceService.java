package WebServices;



import models.ResponseMessage;

import Tasks.BooksTask;
import Tasks.CharacterTask;
import Tasks.HouseTask;
import models.Books;
import models.houses;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by faima on 4/10/17.
 */
@Path("/FireAndIce/")
public class FireIceService {
    @EJB
    CharacterTask characterTask;
    BooksTask booksTask;
    HouseTask housTask;
    ResponseMessage responseMessage = new ResponseMessage();




    @GET
    @Path("/ViewCharacter")
    @Produces(MediaType.APPLICATION_JSON)

    public Response view(Character Character){

            return  Response.status(200).entity( characterTask.viewDetails()).build();
    }
    @GET
    @Path("/ViewBooks")
    @Produces(MediaType.APPLICATION_JSON)

    public Response view(Books books){

        return  Response.status(200).entity( booksTask.viewDetails()).build();
    }
    @GET
    @Path("/ViewHouses")
    @Produces(MediaType.APPLICATION_JSON)

    public Response view(houses houses){

        return  Response.status(200).entity( housTask.viewDetails()).build();
    }



}
