package com.repcar.workshop.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.repcar.workshop.beans.Workshop;
import com.repcar.workshop.dao.WorkshopDAO;

@Service
@Qualifier("workshopService")
@Transactional(value = "transactionManager")
public class WorkshopService {
    private static final Log log = LogFactory.getLog(WorkshopService.class);

    @Autowired
    @Qualifier("userDAO")
    private WorkshopDAO workshopDAO;

    @Transactional(readOnly = true)
    public Page<Workshop> findByWorkshopId(Long workshopId, Pageable pageable) {
	 Page<Workshop> workshop = workshopDAO.findByWorkshopId(workshopId, pageable);
        return workshop;
    }

    @Transactional(readOnly = true)
    public Workshop findByWorkshopName(String workshopName) {
    	Workshop workshop = workshopDAO.findByWorkshopName(workshopName);
        return workshop;
    }
    
    @Transactional(readOnly = true)
    public Workshop findById(Long userId) {
    	Workshop workshop = workshopDAO.findOne(userId);
        return workshop;
    }

}
