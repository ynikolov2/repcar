package com.repcar.user.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.repcar.user.beans.User;
import com.repcar.user.dao.UserDAO;

@Service
@Qualifier("userService")
@Transactional(value = "transactionManager")
public class UserService {
    private static final Log log = LogFactory.getLog(UserService.class);

    @Autowired
    @Qualifier("userDAO")
    private UserDAO userDAO;

  //  private GrantedAuthority authoritySA = new SimpleGrantedAuthority("ROLE_SUPER_ADMIN");

    @Transactional(readOnly = true)
    public Page<User> findByWorkshopId(Long companyId, Pageable pageable) {
	 Page<User> user = userDAO.findByWorkshopId(companyId, pageable);
        return user;
    }

    @Transactional(readOnly = true)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public User findByUsername(String username) {
	User user = userDAO.findByUsername(username);
        return user;
    }

    @Transactional(readOnly = true)
    public User findById(Long userId) {
	User user = userDAO.findOne(userId);
        return user;
    }

}
