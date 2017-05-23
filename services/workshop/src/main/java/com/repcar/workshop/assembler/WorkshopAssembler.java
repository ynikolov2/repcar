/*
 * Copyright RepCar AD 2017
 */
package com.repcar.workshop.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import com.repcar.workshop.beans.Workshop;
import com.repcar.workshop.controllers.WorkshopController;
import com.repcar.workshop.resources.WorkshopResource;

@Service
public class WorkshopAssembler extends ResourceAssemblerSupport<Workshop, WorkshopResource> {

	public WorkshopAssembler() {
		super(WorkshopController.class, WorkshopResource.class);
	}

	public WorkshopResource toResource(Workshop workshop) {
		WorkshopResource resource = new WorkshopResource(workshop.getWorkshopName(), workshop.getWorkshopAddress(),
				workshop.getCreated(), workshop.getParentWorkshopId(), workshop.getType(), workshop.getCity(),
				workshop.getCountry(), workshop.getTimezone(), workshop.getEmail(), workshop.getTelephone(),
				workshop.getSubscriptionType(), workshop.getSubscriptionEndDate(), workshop.getStatus(),
				workshop.getSubscriptions(), workshop.getWorkshopSettings(), workshop.getWorshopDefinedService(),
				workshop.getUsers(), workshop.getWorkshopCustomers(), workshop.getWorkshopInvoiceDetails(),
				workshop.getCars());
		resource.add(linkTo(WorkshopController.class).slash(workshop.getWorkshopId()).withSelfRel());
		return resource;
	}

}
