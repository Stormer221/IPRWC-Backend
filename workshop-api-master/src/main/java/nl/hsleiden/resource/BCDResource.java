package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import nl.hsleiden.model.BCD;
import nl.hsleiden.service.BCDService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class BCDResource {

    private final BCDService bcdService;

    @Inject
    public BCDResource(BCDService bcdService) {
        this.bcdService = bcdService;
    }

    @GET
    @JsonView(View.Public.class)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("GUEST")
    public List<BCD> getAll() {
        return bcdService.getAll();
    }

    @DELETE
    @Path("/{productID}")
    @JsonView(View.Protected.class)
    @RolesAllowed("GUEST")
    @Produces(MediaType.TEXT_HTML)
    public String delete(@PathParam("productID") int productID) {
        bcdService.delete(productID);
        return " deleted from database";
    }

    @POST
    @RolesAllowed("GUEST")
    @JsonView(View.Protected.class)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String add(@Valid BCD bcd) {
        bcdService.add(bcd);
        return " added to database";
    }

    @PUT
    @RolesAllowed("GUEST")
    @JsonView(View.Protected.class)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String update(@Valid BCD bcd) {
        bcdService.update(bcd);
        return " updated in database";
    }
}
