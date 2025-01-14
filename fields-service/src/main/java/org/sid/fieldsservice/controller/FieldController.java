package org.sid.fieldsservice.controller;

import org.sid.fieldsservice.entity.Field;
import org.sid.fieldsservice.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/api/fields")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @GetMapping
    public List<Field> getAllFields() {
        return fieldService.getAllFields();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Field> getFieldById(@PathVariable Long id) {
        return ResponseEntity.ok(fieldService.getFieldById(id));
    }

    @PostMapping
    public ResponseEntity<Field> createField(@RequestBody Field field) {
        return ResponseEntity.ok(fieldService.createField(field));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Field> updateField(@PathVariable Long id, @RequestBody Field field) {
        return ResponseEntity.ok(fieldService.updateField(id, field));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteField(@PathVariable Long id) {
        fieldService.deleteField(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public List<Field> filterFields(@RequestParam(required = false) String location,
                                    @RequestParam(required = false) Boolean isAvailable) {
        if (location != null && isAvailable != null) {
            return fieldService.filterFieldsByLocationAndAvailability(location, isAvailable);
        } else if (location != null) {
            return fieldService.filterFieldsByLocation(location);
        } else if (isAvailable != null) {
            return fieldService.filterFieldsByAvailability(isAvailable);
        } else {
            return fieldService.getAllFields();
        }
    }
}
