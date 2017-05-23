/*
 * Copyright RepCar AD 2017
 */
package com.repcar.workshop.controllers;

import static org.springframework.hateoas.MediaTypes.HAL_JSON_VALUE;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.repcar.workshop.assembler.WorkshopAssembler;
import com.repcar.workshop.beans.Workshop;
import com.repcar.workshop.exception.ExceptionBody;
import com.repcar.workshop.resources.WorkshopResource;
import com.repcar.workshop.services.WorkshopService;

@RestController
@RequestMapping("/workshops")
@ExposesResourceFor(WorkshopResource.class)
public class WorkshopController {

	private static final Logger logger = LoggerFactory.getLogger(WorkshopController.class);

	@Autowired
	private WorkshopService workshopService;

	@Autowired
	private WorkshopAssembler workshopAssembler;

	@RequestMapping(method = GET, produces = HAL_JSON_VALUE)
	public ResponseEntity<PagedResources<WorkshopResource>> getWorkshops(
			@RequestParam(value = "companyId", required = true) Long workshopId, Pageable pageable,
			PagedResourcesAssembler<Workshop> pagedResourcesAssembler) {
		Page<Workshop> workshop = workshopService.findByWorkshopId(workshopId, pageable);
		Link self = linkTo(
				methodOn(WorkshopController.class).getWorkshops(workshopId, pageable, pagedResourcesAssembler))
						.withSelfRel();
		logger.debug("Found Workshop for workshopId: {} - {}", workshopId, workshop);
		if (!workshop.hasContent()) {
			return ResponseEntity.ok((PagedResources<WorkshopResource>) pagedResourcesAssembler
					.toEmptyResource(workshop, WorkshopResource.class, self));
		}
		return ResponseEntity.ok(pagedResourcesAssembler.toResource(workshop, workshopAssembler, self));
	}

	@RequestMapping(value = "/{workshopId:[\\d]+}", method = GET, produces = HAL_JSON_VALUE)
	public ResponseEntity<WorkshopResource> getWorkshop(@PathVariable("workshopId") Long workshopId) {
		Workshop workshop = workshopService.findById(workshopId);
		logger.info("For id: {} whe workshop is {}.", workshopId, workshop);
		if (workshop == null) {
			return new ResponseEntity<>(NOT_FOUND);
		}
		return ResponseEntity.ok(workshopAssembler.toResource(workshop));
	}

	/*
	 * @RequestMapping(method = POST, consumes = HAL_JSON_VALUE, produces =
	 * HAL_JSON_VALUE) public ResponseEntity<WorkshopResource>
	 * create(@Validated({ Create.class }) @RequestBody Workshop Workshop) { //
	 * Workshop.setWorkshopPassword(encryptDecryptService.encrypt(Workshop.
	 * getWorkshopPassword())); Workshop = WorkshopService.save(Workshop);
	 * WorkshopResource resource = WorkshopAssembler.toResource(Workshop);
	 * logger.info("Created Workshop: {}", resource); return ResponseEntity
	 * .created(ControllerLinkBuilder.linkTo(WorkshopController.class).slash(
	 * Workshop.getWorkshopId()).toUri()) .body(resource); }
	 * 
	 * @RequestMapping(method = PUT, consumes = HAL_JSON_VALUE, produces =
	 * HAL_JSON_VALUE) public ResponseEntity<WorkshopResource>
	 * update(@Validated({ Update.class }) @RequestBody Workshop Workshop) { if
	 * (WorkshopService.findOne(Workshop.getWorkshopId()) == null) { throw new
	 * IllegalArgumentException("Workshop is not found for the provided id " +
	 * Workshop.getWorkshopId()); } //
	 * Workshop.setWorkshopPassword(encryptDecryptService.encrypt(Workshop.
	 * getWorkshopPassword())); Workshop =
	 * WorkshopService.saveAndFlush(Workshop); WorkshopResource WorkshopResource
	 * = WorkshopAssembler.toResource(Workshop);
	 * logger.info("Updated Workshop: {}", WorkshopResource); return
	 * ResponseEntity.ok(WorkshopResource); }
	 * 
	 * @RequestMapping(path = "/{WorkshopId:[\\d]+}", method = DELETE) public
	 * ResponseEntity<Void> delete(@PathVariable("WorkshopId") Long WorkshopId)
	 * { WorkshopService.delete(WorkshopId);
	 * logger.info("Deleted Workshop with id: {}", WorkshopId); return
	 * ResponseEntity.noContent().build(); }
	 */
	@ExceptionHandler({ InvalidDataAccessApiUsageException.class, ConstraintViolationException.class })
	public ResponseEntity<ExceptionBody> handleBadRequestExcepion(Exception e) {
		logger.error(e.getMessage());
		logger.debug(e.getMessage(), e);
		return new ResponseEntity<ExceptionBody>(new ExceptionBody(BAD_REQUEST, e.getMessage()), BAD_REQUEST);
	}

	@ExceptionHandler({ IllegalArgumentException.class, EmptyResultDataAccessException.class })
	public ResponseEntity<ExceptionBody> handleINotFoundException(RuntimeException e) {
		logger.error(e.getMessage());
		logger.debug(e.getMessage(), e);
		return new ResponseEntity<ExceptionBody>(new ExceptionBody(NOT_FOUND, e.getMessage()), NOT_FOUND);
	}

}