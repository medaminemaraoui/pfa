package org.sid.clubservice.repository;


import org.sid.clubservice.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {}
