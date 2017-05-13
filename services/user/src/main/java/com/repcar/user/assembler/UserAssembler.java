/*
 * Copyright RepCar AD 2017
 */
package com.repcar.user.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import com.repcar.user.beans.User;
import com.repcar.user.controllers.UserController;
import com.repcar.user.resources.UserResource;

@Service
public class UserAssembler extends ResourceAssemblerSupport<User, UserResource> {

	public UserAssembler() {
		super(UserController.class, UserResource.class);
	}

	public UserResource toResource(User user) {
		UserResource resource = new UserResource(user.getUsername(), user.getUserEmail(), user.getUserPassword(),
				user.getUserFirstName(), user.getUserLastName(), user.getUserRoleId(), user.getWorkshopId(),
				user.getTel(), user.isForcePasswordChange(), user.getStatus(), user.getParentUserId(),
				user.getUserSettingsId());
		resource.add(linkTo(UserController.class).slash(user.getUserId()).withSelfRel());
		return resource;
	}

}
