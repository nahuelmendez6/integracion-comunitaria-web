package com.intgracion_comunitaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intgracion_comunitaria.model.Attachment;

import com.intgracion_comunitaria.repositories.AttachmentRepository;
import java.util.List;

@Service
public class AttachmentService {

    @Autowired
    private AttachmentRepository attachmentRepository;

    public List<Attachment> getAttachmentsByPortfolio(Long portfolioId) {
        return attachmentRepository.findByPortfolioId(portfolioId);
    }

    public Attachment addAttachment(Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    public void deleteAttachment(Long idAttachment) {
        attachmentRepository.deleteById(idAttachment);
    }

}
