package com.simi.studies.politiciansprofile.politician.command.infrastructure.database.dao;

import com.simi.studies.politiciansprofile.politician.command.infrastructure.database.dbo.DocumentIdDbo;
import com.simi.studies.politiciansprofile.politician.command.infrastructure.database.dbo.PoliticianDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliticianSpringRepository extends JpaRepository<PoliticianDbo, DocumentIdDbo> {
}
