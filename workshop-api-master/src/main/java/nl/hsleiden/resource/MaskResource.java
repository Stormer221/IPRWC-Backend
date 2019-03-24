package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import nl.hsleiden.model.Mask;
import nl.hsleiden.service.MaskService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class MaskResource {

    private final MaskService maskService;

    @Inject
    public MaskResource(MaskService maskService) {
        this.maskService = maskService;
    }

    @GET
    @JsonView(View.Public.class)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("GUEST")
    public List<Mask> getAll() {return MaskService.getAll();}

    @DELETE
    @Path("/{productID}")
    @JsonView(View.Protected.class)
    @RolesAllowed("GUEST")
    @Produces(MediaType.TEXT_HTML)
    public String delete(@PathParam("productID") int productID) {
        maskService.delete(productID);
        return " deleted from database";
    }

    @POST
    @RolesAllowed("GUEST")
    @JsonView(View.Protected.class)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String add(@Valid Mask mask) {
        maskService.add(mask);
        return " added to database";
    }

    @PUT
    @RolesAllowed("GUEST")
    @JsonView(View.Protected.class)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String update(@Valid Mask mask) {
        maskService.update(mask);
        return " updated in database";
    }
}
