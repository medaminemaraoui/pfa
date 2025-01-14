package org.sid.clubservice.controller;


import org.sid.clubservice.entity.Club;
import org.sid.clubservice.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {
    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public List<Club> getAllClubs() {
        return clubService.getAllClubs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Club> getClubById(@PathVariable Long id) {
        return clubService.getClubById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Club createClub(@RequestBody Club club) {
        return clubService.createClub(club);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Club> updateClub(@PathVariable Long id, @RequestBody Club clubDetails) {
        return ResponseEntity.ok(clubService.updateClub(id, clubDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClub(@PathVariable Long id) {
        clubService.deleteClub(id);
        return ResponseEntity.noContent().build();
    }
}
