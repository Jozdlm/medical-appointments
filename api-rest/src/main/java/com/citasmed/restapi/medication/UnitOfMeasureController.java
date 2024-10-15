package com.citasmed.restapi.medication;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/units-of-measure/")
public class UnitOfMeasureController {
    @Autowired
    private UnitOfMeasureService unitOfMeasureService;

    @GetMapping("/")
    public List<UnitOfMeasure> getUnits() {
        return unitOfMeasureService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUnitById(@PathVariable Integer id) {
        Optional<UnitOfMeasure> unitOpt = unitOfMeasureService.findById(id);

        if (unitOpt.isEmpty()) {
            Map<String, String> errorResponse = Map.of(
                    "message", "Unit of measure not found with ID: " + id);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        return ResponseEntity.ok(unitOpt.get());
    }

    @PostMapping
    public UnitOfMeasure createMedication(@RequestBody UnitOfMeasure unit) {
        return unitOfMeasureService.save(unit);
    }

    @PutMapping("/{id}")
    public UnitOfMeasure updateMedication(@PathVariable Integer id, @RequestBody UnitOfMeasure unit) {
        return unitOfMeasureService.updateUnitOfMeasure(id, unit);
    }
}
