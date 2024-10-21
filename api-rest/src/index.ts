import "reflect-metadata";
import dotenv from "dotenv";
import express, { Request, Response } from "express";
import { DataSource } from "typeorm";

// Load environment variables
dotenv.config();

const app = express();
app.use(express.json());

const AppDataSource = new DataSource({
  type: "mysql",
  host: process.env.DB_HOST,
  port: parseInt(process.env.DB_PORT || "3306"),
  username: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_NAME,
  entities: [],
  synchronize: true,
});

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
