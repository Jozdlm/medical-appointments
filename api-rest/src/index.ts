import "reflect-metadata";
import express, { Request, Response } from "express";
import { AppDataSource } from "./data-source";
import medicationController from "./medication/medication.controller";

const app = express();
app.use(express.json());

app.use("/api/medications", medicationController);

app.get("/", (req: Request, res: Response) => {
  res.json({
    message: "Hello world",
  });
});

AppDataSource.initialize()
  .then(() => {
    console.log("Data Source has been initialized!");

    app.listen(3000, () => {
      console.log("Server is running on port 3000");
    });
  })
  .catch((err) => {
    console.error("Error during Data Source initialization", err);
  });