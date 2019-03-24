package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import nl.hsleiden.model.Fin;
import nl.hsleiden.service.FinsService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Singleton
@Path("/fins")
public class FinsResource {

    private final FinsService finsService;

    @Inject
    public FinsResource(FinsService finsService) {
        this.finsService = finsService;
    }

    @GET
    @JsonView(View.Public.class)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("GUEST")
    public List<Fin> getAll() {return finsService.getAll();}

    @DELETE
    @Path("/{productID}")
    @JsonView(View.Protected.class)
    @RolesAllowed("GUEST")
    @Produces(MediaType.TEXT_HTML)
    public String delete(@PathParam("productID") int productID) {
        finsService.delete(productID);
        return " deleted from database";
    }

    @POST
    @RolesAllowed("GUEST")
    @JsonView(View.Protected.class)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String add(@Valid  Fin fin) {
        finsService.add(fin);
        return " added to database";
    }

    @PUT
    @RolesAllowed("GUEST")
    @JsonView(View.Protected.class)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String update(@Valid Fin fin) {
        finsService.update(fin);
        return " updated in database";
    }


}
