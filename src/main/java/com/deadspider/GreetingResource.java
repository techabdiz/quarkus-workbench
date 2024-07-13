package com.deadspider;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "update againsadas    in intellij";
    }

    @GET
    @Path("say/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(@PathParam("name") String name){
        System.out.println("name in path: "+name);
        return String.format("Hello, %s", name);
    }
}
