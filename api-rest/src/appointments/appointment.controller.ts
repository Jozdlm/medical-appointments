import { Request, Response, Router } from "express";
import { AppDataSource } from "../data-source"; // Adjust the import path as necessary
import { Appointment } from "./appointment";

const router = Router();

const citaRepository = AppDataSource.getRepository(Appointment);

// Get all citas
router.get("/", async (req: Request, res: Response) => {
  try {
    const citas = await citaRepository.find({
      relations: {
        paciente: true,
        doctor: true,
        secretaria: true,
      },
    });
    res.json(citas);
  } catch (error) {
    console.log(error);
    res.status(500).json({ message: "Error retrieving citas" });
  }
});

// Get a cita by ID
router.get("/:id", async (req: Request, res: Response) => {
  const id = parseInt(req.params.id);

  try {
    const cita = await citaRepository.findOne({
      where: { id },
      relations: {
        paciente: true,
        doctor: true,
        secretaria: true,
      },
    });

    if (cita) {
      res.json(cita);
    } else {
      res.status(404).json({ message: `Cita not found with ID: ${id}` });
    }
  } catch (error) {
    res.status(500).json({ message: "Error retrieving cita" });
  }
});

// Create a new cita
router.post("/", async (req: Request, res: Response) => {
  try {
    const cita = citaRepository.create(req.body);
    const savedCita = await citaRepository.save(cita);
    res.status(201).json(savedCita);
  } catch (error) {
    res.status(500).json({ message: "Error saving cita" });
  }
});

// Update an existing cita
router.put("/:id", async (req: Request, res: Response) => {
  const id = parseInt(req.params.id);

  try {
    const cita = await citaRepository.findOneBy({ id });

    if (cita) {
      Object.assign(cita, req.body);
      const updatedCita = await citaRepository.save(cita);
      res.json(updatedCita);
    } else {
      res.status(404).json({ message: `Cita not found with ID: ${id}` });
    }
  } catch (error) {
    res.status(500).json({ message: "Error updating cita" });
  }
});

export default router;
