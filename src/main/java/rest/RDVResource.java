package rest;

import dao.RDVDao;
import domain.RDV;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("rdv")
@Produces({"application/json"})
public class RDVResource {

    private RDVDao rdvDao = new RDVDao();

    @GET
    @Path("/{rdvId}")
    public RDV getRDVById(@PathParam("rdvId") Long rdvId)  {
        // return pet
        return (RDV) rdvDao.findOne(rdvId);
    }

    @GET
    @Path("/")
    public List<RDV> getRDVs()  {
        return (List<RDV>) rdvDao.findAll();
    }


    @POST
    @Consumes("application/json")
    public Response addRDV(
            @Parameter(description = "RDV object that needs to be added to the application", required = true) RDV rdv) {
        // add RDV
        try{
            rdvDao.save(rdv);
        }catch (Exception e){
            return Response.status(400).build();
        }
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Consumes("application/json")
    public Response deleteRDV(
            @Parameter(description = "RDV object that needs to be added to the application", required = true) RDV rdv) {
        // add RDV
        try{
            rdvDao.delete(rdv);
        }catch (Exception e){
            return Response.status(400).build();
        }
        return Response.ok().entity("SUCCESS").build();
    }
}