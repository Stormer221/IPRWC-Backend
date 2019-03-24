package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import nl.hsleiden.model.Lead;
import nl.hsleiden.service.LeadService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

public class LeadResource {

    private final LeadService leadService;

    @Inject
    public LeadResource(LeadService leadService) {
        this.leadService = leadService;
    }

    @GET
    @JsonView(View.Public.class)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("GUEST")
    public List<Lead> getAll() {return leadService.getAll();}

    @DELETE
    @Path("/{productID}")
    @JsonView(View.Protected.class)
    @RolesAllowed("GUEST")
    @Produces(MediaType.TEXT_HTML)
    public String delete(@PathParam("productID") int productID) {
        leadService.delete(productID);
        return " deleted from database";
    }

    @POST
    @RolesAllowed("GUEST")
    @JsonView(View.Protected.class)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String add(@Valid Lead lead) {
        leadService.add(lead);
        return " added to database";
    }

    @PUT
    @RolesAllowed("GUEST")
    @JsonView(View.Protected.class)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    public String update(@Valid Lead lead) {
        leadService.update(lead);
        return " updated in database";
    }
}
