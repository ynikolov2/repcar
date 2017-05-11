/*
 * Copyright RepCar AD 2017
 */
package com.repcar.workshop.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import com.repcar.workshop.beans.User;
import com.repcar.workshop.controllers.UserController;
import com.repcar.workshop.resources.UserResource;

@Service
public class UserAssembler extends ResourceAssemblerSupport<User, UserResource> {

    public UserAssembler() {
        super(UserController.class, UserResource.class);
    }

    public UserResource toResource(User user) {
        UserResource resource = new UserResource(user.getUserId(), user.getWorkshop(), user.getUserName(), user.getUserEmail(),
                user.getUserFirstName(), user.getUserLastName(), user.getUserRole());
        resource.add(linkTo(UserController.class).slash(user.getUserId()).withSelfRel());
        return resource;
    }

}
