package rest;

import dao.ProfessionnelDao;
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

@Path("pro")
@Produces({"application/json"})
public class ProfessionnelResource {

    private ProfessionnelDao proDao = new ProfessionnelDao();

    @GET
    @Path("/{proId}")
    public Professionnel getProById(@PathParam("proId") Long proId)  {
        // return pet
        return (Professionnel) proDao.findOne(proId);
    }

    @GET
    @Path("/")
    public List<Professionnel> getPros()  {
        return (List<Professionnel>) proDao.findAll();
    }


    @POST
    @Consumes("application/json")
    public Response addPro(
            @Parameter(description = "Professionnel object that needs to be added to the application", required = true) Professionnel pro) {
        // add professionnel
        try{
            proDao.save(pro);
        }catch (Exception e){
            return Response.status(400).build();
        }
        return Response.ok().entity("SUCCESS").build();
    }

    @POST
    @Consumes("application/json")
    public Response deletePro(
            @Parameter(description = "Professionnel object that needs to be added to the application", required = true) Professionnel pro) {
        // add professionnel
        try{
            proDao.delete(pro);
        }catch (Exception e){
            return Response.status(400).build();
        }
        return Response.ok().entity("SUCCESS").build();
    }
}