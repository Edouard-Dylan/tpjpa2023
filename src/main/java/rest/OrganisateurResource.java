package rest;

import dao.OrganisateurDao;
import domain.Organisateur;
import domain.Professionnel;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("orga")
@Produces({"application/json"})
public class OrganisateurResource {

    private OrganisateurDao orgaDao = new OrganisateurDao();

    @GET
    @Path("/{orgaId}")
    public Organisateur getOrgaById(@PathParam("orgaId") Long orgaId)  {
        // return pet
        return (Organisateur) orgaDao.findOne(orgaId);
    }

    @GET
    @Path("/")
    public List<Organisateur> getOrgas()  {
        return (List<Organisateur>) orgaDao.findAll();
    }


    @POST
    @Consumes("application/json")
    @Path("/create")
    public Response addOrga(
            @Parameter(description = "Organisateur object that needs to be added to the application", required = true) Organisateur orga) {
        // add Organisateur
        try{
            orgaDao.save(orga);
        }catch (Exception e){
            return Response.status(400).build();
        }
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Consumes("application/json")
    @Path("/delete")
    public Response deleteOrga(
            @Parameter(description = "Organisateur object that needs to be added to the application", required = true) Organisateur orga) {
        // add Organisateur
        try{
            orgaDao.delete(orga);
        }catch (Exception e){
            return Response.status(400).build();
        }
        return Response.ok().entity("SUCCESS").build();
    }
}