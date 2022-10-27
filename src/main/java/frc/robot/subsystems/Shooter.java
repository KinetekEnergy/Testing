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
  WPI_TalonFX right_motor = new WPI_TalonFX(Constants.right_shooter_motor); // right
  WPI_TalonFX left_motor = new WPI_TalonFX(Constants.left_shooter_motor); // left

  public Shooter() {
    left_motor.setInverted(true);
    right_motor.setInverted(false);
  }

  private MotorControllerGroup shooter = new MotorControllerGroup(left_motor, right_motor);

  public void set_speed(double speed) {
    shooter.set(speed);
  }
}
