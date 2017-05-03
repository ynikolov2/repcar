/*
 * Copyright RepCar AD 2017
 */
package com.repcar.viechlejob.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import com.repcar.viechlejob.beans.User;
import com.repcar.viechlejob.controllers.UserController;
import com.repcar.viechlejob.resources.UserResource;

@Service
public class UserAssembler extends ResourceAssemblerSupport<User, UserResource> {

    public UserAssembler() {
        super(UserController.class, UserResource.class);
    }

    public UserResource toResource(User user) {
        UserResource resource = new UserResource( user.getUserId(), user.getUserName(), user.getUserRole());
        resource.add(linkTo(UserController.class).slash(user.getUserId()).withSelfRel());
        return resource;
    }

}
