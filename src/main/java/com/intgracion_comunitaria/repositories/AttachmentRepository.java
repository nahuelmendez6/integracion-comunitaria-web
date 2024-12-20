package com.intgracion_comunitaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intgracion_comunitaria.model.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    List<Attachment> findByPortfolioId(Long portfolioId);

}
