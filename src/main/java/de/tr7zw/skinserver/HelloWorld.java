package de.tr7zw.skinserver;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/")
public class HelloWorld {

    @GET
    public Response getHello() {
        return Response.status(200).entity("Hello world! This is the skin backend.").build();
    }
    
}
