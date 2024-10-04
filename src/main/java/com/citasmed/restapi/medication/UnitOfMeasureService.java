package com.citasmed.restapi.medication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitOfMeasureService {
    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public List<UnitOfMeasure> findAll() {
        return unitOfMeasureRepository.findAll();
    }

    public Optional<UnitOfMeasure> findById(Integer id) {
        return unitOfMeasureRepository.findById(id);
    }

    public UnitOfMeasure save(UnitOfMeasure unitOfMeasure) {
        return unitOfMeasureRepository.save(unitOfMeasure);
    }

    public UnitOfMeasure updateUnitOfMeasure(Integer id, UnitOfMeasure updatedUnit) {
        Optional<UnitOfMeasure> existingUnitOpt = unitOfMeasureRepository.findById(id);

        if (existingUnitOpt.isEmpty()) {
            throw new RuntimeException("UnitOfMeasure not found with ID: " + id);
        }

        UnitOfMeasure unit = existingUnitOpt.get();
        Optional<UnitOfMeasure> existingUnitWithSameNameOpt = unitOfMeasureRepository
                .findByName(updatedUnit.getName());

        if (existingUnitWithSameNameOpt.isPresent()) {
            throw new IllegalArgumentException(
                    "Unit of measure with name: " + updatedUnit.getName() + " , already exists");
        }

        unit.setName(updatedUnit.getName());
        return unitOfMeasureRepository.save(unit);
    }
}
