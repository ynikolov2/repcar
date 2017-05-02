/*
 * Copyright RepCar AD 2017
 */
package com.repcar.security.rest;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.repcar.security.hateoas.CustomResponse;


@RestController
public class UserController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
    
    @RequestMapping(value = "/logout-user/{username}", method = GET, produces = APPLICATION_JSON_VALUE)
    public HttpEntity<?> logoutUser(HttpServletRequest request, HttpServletResponse httpResponse,
            @PathVariable(value = "username") String username) throws Exception {

        // invalidates auth, session, and SecurityContextHolder
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, httpResponse, auth);
        }

        String remoteAddress = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest()
                .getRemoteAddr();

        // Remove session from cookies
        Cookie cookie = new Cookie("JSESSIONID", null);
        String cookiePath = "/";
        cookie.setPath(cookiePath);
        cookie.setMaxAge(0);
        httpResponse.addCookie(cookie);

        CustomResponse response = new CustomResponse("OK");
        return new ResponseEntity<CustomResponse>(response, OK);
    }
}
