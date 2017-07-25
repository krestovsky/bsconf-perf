package krestovsky.test.resources;

import krestovsky.test.db.UserDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author maxim.krestovsky@gmail.com on 7/25/17.
 */
@Path("/users")
public class UserResource {

    private UserDao registry;

    public UserResource(UserDao registry) {
        this.registry = registry;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return Response.ok(registry.findAll()).build();
    }
}
