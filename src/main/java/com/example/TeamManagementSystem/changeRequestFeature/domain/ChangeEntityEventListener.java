package com.example.TeamManagementSystem.changeRequestFeature.domain;


import com.example.TeamManagementSystem.changeRequestFeature.domain.entity.ChangeRequestEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Component
public class ChangeEntityEventListener {


    @PrePersist
    void prePersistDataInjection(ChangeRequestEntity changeRequestEntity) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        changeRequestEntity.setCreatedBy(authentication.getName());
        changeRequestEntity.setModifiedAt(null);
        changeRequestEntity.setCreatedAt(LocalDateTime.of(LocalDate.now(), LocalTime.now()));
    }


    @PreUpdate
    @PreRemove
    void preUpdateDataInjection(ChangeRequestEntity changeRequestEntity) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        changeRequestEntity.setModifiedBy(authentication.getName());
        changeRequestEntity.setModifiedAt(LocalDateTime.now());
    }


}
