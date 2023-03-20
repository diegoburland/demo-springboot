package com.learning.academy.branch.office;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {
    List<Office> findAllByCityId(Long cityId);

    @Query("SELECT o FROM Office o WHERE o.name LIKE %:keyword% OR o.address LIKE %:keyword%")
    List<Office> search(@Param("keyword") String keyword);
}
