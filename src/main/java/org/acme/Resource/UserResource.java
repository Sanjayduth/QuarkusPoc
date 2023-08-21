package org.acme.Resource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.acme.Repository.UserRepository;
import org.acme.entity.User;
import org.bson.types.ObjectId;

import java.util.List;

@ApplicationScoped
@Path("user")
public class UserResource {
    @Inject
    private UserRepository userRepository;

    @POST
    public Response create(User person) {
        userRepository.persist(person);
        return Response.status(201).build();
    }
    @GET
    public List<User> list() {
        return userRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public User get(String id) {
        return userRepository.findById(new ObjectId(id));
    }

    @PUT
    @Path("/{id}")
    public void update(String id, User user) {
        userRepository.update(user);
    }

    @DELETE
    @Path("/{id}")
    public void delete(String id) {
        User person = userRepository.findById(new ObjectId(id));
        userRepository.delete(person);
    }

    @GET
    @Path("/search/{name}")
    public User search(String name) {
        return userRepository.findByName(name);
    }

    @DELETE
    public void deleteAll(){
        userRepository.deleteAll();
    }


}
