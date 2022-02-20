package com.example.demo_kafka.boundries;

import com.example.demo_kafka.services.dtos.UserDto;
import com.example.demo_kafka.services.interfaces.UserService;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@Path("/user")
public class UserResource {

    @EJB
    private UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        List<UserDto> userDtos=userService.getUsers();
        return Response.ok(userDtos).build();
    }
    @GET
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("userId") UUID uuid) {
        UserDto userDto=userService.getUserById(uuid);
        return Response.ok(userDto).build();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(UserDto userDto) {
        UserDto createdUserDto=userService.create(userDto);
        URI location= UriBuilder.fromResource(UserResource.class)
                .path("/{userId}").resolveTemplate("userId",createdUserDto.getId())
                .build();
        return Response.created(location).build();
    }

}