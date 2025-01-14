package org.sid.fieldsservice.controller;

import org.sid.fieldsservice.entity.Field;
import org.sid.fieldsservice.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fields")
//@CrossOrigin(origins = "http://localhost:4200")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @GetMapping
    public ResponseEntity<List<Field>> getFields(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Boolean available
    ) {
        List<Field> fields = fieldService.getFields(location, available);
        return ResponseEntity.ok(fields);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Field> getFieldById(@PathVariable Long id) {
        Field field = fieldService.getFieldById(id);
        return ResponseEntity.ok(field);
    }

    @PostMapping
    public ResponseEntity<Field> createField(@RequestBody Field field) {
        Field createdField = fieldService.createField(field);
        return ResponseEntity.ok(createdField);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Field> updateField(@PathVariable Long id, @RequestBody Field field) {
        Field updatedField = fieldService.updateField(id, field);
        return ResponseEntity.ok(updatedField);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteField(@PathVariable Long id) {
        fieldService.deleteField(id);
        return ResponseEntity.noContent().build();
    }
}
