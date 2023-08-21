package org.acme.Repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.User;

@ApplicationScoped
public class UserRepository  implements PanacheMongoRepository<User> {
    public User findByName(String name) {
        return find("name", name).firstResult();
    }
}
