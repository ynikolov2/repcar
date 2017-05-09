/*
 * Copyright RepCar AD 2017
 */
package com.repcar.viechlejob.resources;

import java.sql.Timestamp;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.repcar.viechlejob.beans.User.Roles;

/**
 * @author <a href="mailto:mstancheva@repcarpro.com">Mihaela Stancheva</a>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(collectionRelation = "users", value = "user")
public class UserResource extends ResourceSupport {

    private Long userId;
    private String userName;
    private Roles userRole;


    @JsonCreator
    public UserResource() {

    }

    @JsonCreator
    public UserResource(@JsonProperty("userId") Long userId, @JsonProperty("userName") String userName,
            @JsonProperty("userRole") Roles roles) {
        this.userId = userId;
        this.userName = userName;
        this.userRole = roles;
    }

    public Long getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public Roles getUserRole() {
        return this.userRole;
    }
}
