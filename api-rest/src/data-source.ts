import { DataSource } from "typeorm";
import { Medication } from "./medication/medication";

import dotenv from "dotenv";
// Load environment variables
dotenv.config();

export const AppDataSource = new DataSource({
  type: "mysql",
  host: process.env.DB_HOST,
  port: parseInt(process.env.DB_PORT || "3306"),
  username: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DB_NAME,
  entities: [Medication],
  // synchronize: true,
});