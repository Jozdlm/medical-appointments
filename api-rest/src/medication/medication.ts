import { Entity, PrimaryGeneratedColumn, Column } from "typeorm";

@Entity({ name: "medicamentos" })
export class Medication {
  @PrimaryGeneratedColumn()
  id: number;

  @Column({ name: "nombre", nullable: false })
  name: string;

  @Column({ name: "medida_id", nullable: false })
  measurementId: number;

  @Column({ name: "activo", type: "boolean", nullable: false })
  isActive: boolean;
}
