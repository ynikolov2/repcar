/*
 * Copyright RepCar AD 2017
 */
package com.repcar.workshop.resources;

import java.sql.Timestamp;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.repcar.workshop.beans.Workshop;
import com.repcar.workshop.beans.User.Roles;

/**
 * @author <a href="mailto:mstancheva@repcarpro.com">Mihaela Stancheva</a>
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(collectionRelation = "users", value = "user")
public class UserResource extends ResourceSupport {

    private Long userId;
    private Workshop workshop;
    private String userName;
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private Roles userRole;

    @JsonCreator
    public UserResource() {

    }

    @JsonCreator
    public UserResource(@JsonProperty("userId") Long userId,@JsonProperty("workshopId") Workshop workshop, @JsonProperty("userName") String userName,
            @JsonProperty("userEmail") String userEmail, @JsonProperty("userFirstName") String userFirstName,
            @JsonProperty("userLastName") String userLastName, @JsonProperty("userRole") Roles roles) {
        this.userId = userId;
        this.workshop = workshop;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userRole = roles;
    }

    public Long getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public String getUserFirstName() {
        return this.userFirstName;
    }

    public String getUserLastName() {
        return this.userLastName;
    }

    public Roles getUserRole() {
        return this.userRole;
    }

}
