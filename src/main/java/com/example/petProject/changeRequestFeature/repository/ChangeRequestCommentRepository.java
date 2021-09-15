package com.example.petProject.changeRequestFeature.repository;

import com.example.petProject.changeRequestFeature.model.entity.ChangeRequestCommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import java.util.Date;

@Repository
public interface ChangeRequestCommentRepository extends JpaRepository<ChangeRequestCommentEntity, Long> {

    Page<ChangeRequestCommentEntity> findByCreatedAt(Date createdAt, Pageable pageable);

    @Query(value = "SELECT * FROM change_request_comment WHERE change_request_id=:id", nativeQuery = true)
    Page<ChangeRequestCommentEntity> findByChangeRequestEntityId(@Param("id") Long id, Pageable pageable);

    Page<ChangeRequestCommentEntity> findByCommentBy(String username, Pageable pageable);


}
