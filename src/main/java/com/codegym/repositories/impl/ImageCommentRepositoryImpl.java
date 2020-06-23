package com.codegym.repositories.impl;

import com.codegym.models.ImageComment;
import com.codegym.repositories.ImageCommentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public class ImageCommentRepositoryImpl implements ImageCommentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ImageComment findById(Long id) {
        ImageComment imageComment = entityManager.find(ImageComment.class, id);
        return imageComment;
    }

    @Override
    public List<ImageComment> findAll() {
        TypedQuery<ImageComment> typedQuery
                = entityManager.createQuery(
                        "Select i FROM ImageComment i",
                            ImageComment.class
                        );

        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public boolean save(ImageComment imageComment) {
        try {

            if (imageComment.getId() != null) {
                entityManager.merge(imageComment);
            } else {
                entityManager.persist(imageComment);
            }

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Long id) {

        try {
            ImageComment imageComment = entityManager.find(ImageComment.class, id);
            entityManager.remove(imageComment);
            return true;

        } catch (Exception e) {
            return false;
        }

    }
}
