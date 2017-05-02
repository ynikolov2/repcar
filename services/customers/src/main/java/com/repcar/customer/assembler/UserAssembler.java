/*
 * Copyright RepCar AD 2017
 */
package com.repcar.customer.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import com.repcar.customer.beans.User;
import com.repcar.customer.controllers.UserController;
import com.repcar.customer.resources.UserResource;

@Service
public class UserAssembler extends ResourceAssemblerSupport<User, UserResource> {

    public UserAssembler() {
        super(UserController.class, UserResource.class);
    }

    public UserResource toResource(User user) {
        UserResource resource = new UserResource(user.getUserId(), user.getUserName(), user.getUserEmail(),
                user.getUserFirstName(), user.getUserLastName(), user.getUserImage(), user.getUserRole(),
                user.getCreationDate(), user.getUserAttributes());
        resource.add(linkTo(UserController.class).slash(user.getUserId()).withSelfRel());
        return resource;
    }

}
