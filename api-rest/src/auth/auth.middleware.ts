import { Request, Response, NextFunction } from "express";
import jwt from "jsonwebtoken";

const JWT_SECRET = process.env.JWT_KEY;

export const authMiddleware = (
  req: Request,
  res: Response,
  next: NextFunction
) => {
  const token = req.header("Authorization");

  if (!token) {
    return res.status(401).json({ message: "No token, authorization denied" });
  }

  try {
    const decoded = jwt.verify(token, JWT_SECRET) as {
      id: string;
      role: string;
    };

    req.user = decoded; // Attach the decoded token to the request object
    next();
  } catch (err) {
    res.status(401).json({ message: "Invalid token" });
  }
};
