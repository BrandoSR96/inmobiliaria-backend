package com.inmobiliaria.inmobiliaria_backend.repository;

import com.inmobiliaria.inmobiliaria_backend.model.Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultimediaRepository extends JpaRepository<Multimedia, Long> {
}
