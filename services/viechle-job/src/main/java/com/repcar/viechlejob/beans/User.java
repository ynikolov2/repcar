/*
 * Copyright RepCar AD 2017
 */
package com.repcar.viechlejob.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User extends ResourceSupport {

    public interface Update {
    }

    public interface Create {
    }

    private Long userId;
    private String userName;
    private Roles userRole;
    private Long companyId;

    @JsonCreator
    public User() {
    }

    @JsonCreator
    public User(@JsonProperty("userName") String userName,
            @JsonProperty("userRole") Roles userRole, @JsonProperty("companyId") Long companyId) {
        this.userName = userName;
        this.userRole = userRole;
        this.companyId = companyId;
    }

    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    @Null(groups = { Create.class })
    @NotNull(groups = { Update.class })
    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @NotNull(groups = { Create.class, Update.class })
    @Size(min = 1, max = 80)
    @Column(length = 80)
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @NotNull(groups = { Create.class, Update.class })
    @Enumerated(EnumType.STRING)
    public Roles getUserRole() {
        return this.userRole;
    }

    public void setUserRole(Roles userRole) {
        this.userRole = userRole;
    }

    @NotNull(groups = { Create.class, Update.class })
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public enum Roles {
        ROLE_ADMIN, ROLE_USER, ROLE_ANONYMOUS, ROLE_OPERATOR
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
        result = prime * result + ((userName == null) ? 0 : userName.hashCode());
        result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (companyId == null) {
            if (other.companyId != null)
                return false;
        } else if (!companyId.equals(other.companyId))
            return false;
        if (userName == null) {
            if (other.userName != null)
                return false;
        } else if (!userName.equals(other.userName))
            return false;
        if (userRole != other.userRole)
            return false;
        return true;
    }

}
