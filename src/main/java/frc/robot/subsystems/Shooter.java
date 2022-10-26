// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public Shooter() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  Shooter motor_1 = new Shooter(); //create the object
  Shooter motor_2 = new Shooter(); //create 2nd object
  motor_2 = motor_2.setInverted(true); //invert the motor
}
