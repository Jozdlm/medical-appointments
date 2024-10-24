import { Request, Response, Router } from "express";
import { AppDataSource } from "../data-source";
import { UnitOfMeasure } from "./unit-of-measure";

const router = Router();
const unitOfMeasureRepository = AppDataSource.getRepository(UnitOfMeasure);

// Get all units of measure
router.get("/", async (req: Request, res: Response) => {
  try {
    const units = await unitOfMeasureRepository.find();
    res.json(units);
  } catch (error) {
    res.status(500).json({ message: "Error retrieving units of measure" });
  }
});

// Get a unit of measure by ID
router.get("/:id", async (req: Request, res: Response) => {
  const id = parseInt(req.params.id);

  try {
    const unit = await unitOfMeasureRepository.findOneBy({ id });
    if (!unit) {
      res
        .status(404)
        .json({ message: `Unit of measure not found with ID: ${id}` });
    }
    res.json(unit);
  } catch (error) {
    res.status(500).json({ message: "Error retrieving unit of measure" });
  }
});

// Create a new unit of measure
router.post("/", async (req: Request, res: Response) => {
  try {
    const unit = unitOfMeasureRepository.create(req.body); // TypeORM's create method
    const savedUnit = await unitOfMeasureRepository.save(unit);
    res.status(201).json(savedUnit);
  } catch (error) {
    res.status(500).json({ message: "Error saving unit of measure" });
  }
});

// Update an existing unit of measure
router.put("/:id", async (req: Request, res: Response) => {
  const id = parseInt(req.params.id);

  try {
    const unit = await unitOfMeasureRepository.findOneBy({ id });

    if (unit) {
      // Check if another unit with the same name exists
      const existingUnitWithSameName = await unitOfMeasureRepository.findOneBy({
        name: req.body.name,
      });
      if (existingUnitWithSameName) {
        res.status(400).json({
          message: `Unit of measure with name "${req.body.name}" already exists.`,
        });
      }

      // Update the unit properties
      unit.name = req.body.name;

      const updatedUnit = await unitOfMeasureRepository.save(unit);
      res.json(updatedUnit);
    } else {
      res
        .status(404)
        .json({ message: `Unit of measure not found with ID: ${id}` });
    }
  } catch (error) {
    res.status(500).json({ message: "Error updating unit of measure" });
  }
});

export default router;
