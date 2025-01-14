package org.sid.clubservice.service;


import org.sid.clubservice.entity.Club;
import org.sid.clubservice.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {
    private final ClubRepository clubRepository;

    @Autowired
    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    public Optional<Club> getClubById(Long id) {
        return clubRepository.findById(id);
    }

    public Club createClub(Club club) {
        return clubRepository.save(club);
    }

    public Club updateClub(Long id, Club clubDetails) {
        Club club = clubRepository.findById(id).orElseThrow(() -> new RuntimeException("Club not found"));
        club.setName(clubDetails.getName());
        club.setDescription(clubDetails.getDescription());
        club.setLocation(clubDetails.getLocation());
        club.setLocation(clubDetails.getCartier());
        club.setMemberCount(clubDetails.getMemberCount());
        return clubRepository.save(club);
    }

    public void deleteClub(Long id) {
        clubRepository.deleteById(id);
    }
}
