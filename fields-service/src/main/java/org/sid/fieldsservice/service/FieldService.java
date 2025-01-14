package org.sid.fieldsservice.service;

import org.sid.fieldsservice.entity.Field;
import org.sid.fieldsservice.repository.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FieldService {

    @Autowired
    private FieldRepository fieldRepository;

    public List<Field> getAllFields() {
        return fieldRepository.findAll();
    }

    public Field getFieldById(Long id) {
        return fieldRepository.findById(id).orElseThrow(() -> new RuntimeException("Field not found"));
    }

    public Field createField(Field field) {
        return fieldRepository.save(field);
    }

    public Field updateField(Long id, Field updatedField) {
        Field existingField = getFieldById(id);
        existingField.setName(updatedField.getName());
        existingField.setLocation(updatedField.getLocation());
        existingField.setAvailable(updatedField.isAvailable());
        return fieldRepository.save(existingField);
    }

    public void deleteField(Long id) {
        fieldRepository.deleteById(id);
    }

    public List<Field> filterFieldsByLocation(String location) {
        return fieldRepository.findByLocation(location);
    }

    public List<Field> filterFieldsByAvailability(boolean isAvailable) {
        return fieldRepository.findByIsAvailable(isAvailable);
    }

    public List<Field> filterFieldsByLocationAndAvailability(String location, boolean isAvailable) {
        return fieldRepository.findByLocationAndIsAvailable(location, isAvailable);
    }
}
