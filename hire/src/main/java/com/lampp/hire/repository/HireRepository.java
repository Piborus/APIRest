package com.lampp.hire.repository;

import com.lampp.hire.models.Hire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HireRepository extends JpaRepository<Hire, Long> {

    Hire findByShortUrl(String shortUrl);
}
