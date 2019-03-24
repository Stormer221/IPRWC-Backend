package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import nl.hsleiden.model.Shoe;
import nl.hsleiden.service.ShoeService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class ShoeResource {

    private final ShoeService shoeService;

    @Inject
    public ShoeResource(ShoeService shoeService) {
        this.shoeService = shoeService;
    }

    @GET
    @JsonView(View.Public.class)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("GUEST")
    public List<Shoe> getAll() {return shoeService.getAll();}

    @DELETE
    @Path("/{productID}")
    @JsonView(View.Protected.class)
    @RolesAllowed("GUEST")
    @Produces(MediaType.TEXT_HTML)
    public String delete(@PathParam("productID") int productID) {
        shoeService.delete(productID);
        return " deleted from database";
    }

    @POST
    @RolesAllowed("GUEST")
    @JsonView(View.Protected.class)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String add(@Valid Shoe shoe) {
        shoeService.add(shoe);
        return " added to database";
    }

    @PUT
    @RolesAllowed("GUEST")
    @JsonView(View.Protected.class)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String update(@Valid Shoe shoe) {
        shoeService.update(shoe);
        return " updated in database";
    }
}
