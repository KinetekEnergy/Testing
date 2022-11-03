// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */  
  private WPI_TalonFX rightMotor = new WPI_TalonFX(Constants.right_shooter_motor); // right
  private WPI_TalonFX leftMotor = new WPI_TalonFX(Constants.left_shooter_motor); // left
  
  private MotorControllerGroup shooter = new MotorControllerGroup(leftMotor, rightMotor);
  
  public Shooter() {
    leftMotor.setInverted(false);
    rightMotor.setInverted(true);
  }
  
  
  public void set_speed(double speed) {
    shooter.set(speed);
  }
}
