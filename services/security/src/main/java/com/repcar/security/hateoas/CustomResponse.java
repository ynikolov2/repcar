package com.repcar.security.hateoas;

import org.springframework.hateoas.ResourceSupport;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class CustomResponse extends ResourceSupport {

		private final String message;

		@JsonCreator
		public CustomResponse(@JsonProperty("message") String message) {
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

}