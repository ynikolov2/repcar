/*
 * Copyright RepCar AD 2017
 */
package com.repcar.user.config;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.oauth2.client.OAuth2RestOperations;

import com.repcar.makemodel.beans.User_old;
import com.repcar.makemodel.beans.User_old.Roles;

@Configuration
@EnableSpringDataWebSupport
public class UnitTestContext {

    public static final Long USER_ID = 175L;
    public static final Long COMPANY_ID = 17L;
    public static final String USER_NAME = "Test User_old";
    public static final String USER_PASSWORD = "password";
    public static final String USER_PASSWORD_ENCRYPTED = "38dc6e4faf0";
    public static final String USER_FIRST_NAME = "Test";
    public static final String USER_LAST_NAME = "User_old";
    public static final String USER_EMAIL = "test.user@unittests.local";

    @Bean(name = "clientRestTemplate")
    public OAuth2RestOperations oAuth2RestOperations() {
        return mock(OAuth2RestOperations.class);
    }

    @Bean
    public User_old newUser() {
        User_old user = new User_old();
        user.setUserFirstName(USER_FIRST_NAME);
        user.setUserLastName(USER_LAST_NAME);
        user.setUserEmail(USER_EMAIL);
        user.setUserName(USER_NAME);
        user.setUserPassword(USER_PASSWORD);
        user.setUserRole(Roles.ROLE_USER);
        user.setCompanyId(COMPANY_ID);
        return user;
    }

    @Bean
    public User_old persistedUser() {
        User_old user = new User_old();
        user.setUserId(USER_ID);
        user.setUserFirstName(USER_FIRST_NAME);
        user.setUserLastName(USER_LAST_NAME);
        user.setUserEmail(USER_EMAIL);
        user.setUserName(USER_NAME);
        user.setUserPassword(USER_PASSWORD_ENCRYPTED);
        user.setUserRole(Roles.ROLE_USER);
        user.setCompanyId(COMPANY_ID);
        return user;
    }

    @Bean
    public User_old forUpdateUser() {
        User_old user = new User_old();
        user.setUserId(USER_ID);
        user.setUserFirstName(USER_FIRST_NAME);
        user.setUserLastName(USER_LAST_NAME);
        user.setUserEmail(USER_EMAIL);
        user.setUserName(USER_NAME);
        user.setUserPassword(USER_PASSWORD);
        user.setUserRole(Roles.ROLE_USER);
        user.setCompanyId(COMPANY_ID);
        return user;
    }
}