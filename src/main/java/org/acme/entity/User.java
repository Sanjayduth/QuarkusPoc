package org.acme.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.time.LocalDate;

@MongoEntity(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private   Object id;
    private  String name;
    private String age;
}
