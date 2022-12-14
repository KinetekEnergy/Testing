// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    // front motors
    WPI_TalonFX rightFront = new WPI_TalonFX(Constants.Right_front); // right
    WPI_TalonFX leftFront = new WPI_TalonFX(Constants.Left_front); // left

    // back motors
    WPI_TalonFX Right_rear = new WPI_TalonFX(Constants.Right_rear); // right
    WPI_TalonFX Left_rear = new WPI_TalonFX(Constants.Left_rear); // left

    // use motor controllers for inversions in constructor

    // proper naming conventions

    /** Creates a new Drivetrain. */
    public Drivetrain() { // motor inversion
        // invert the motors so you don't brokey the robot
        rightFront.setInverted(true);
        Right_rear.setInverted(true);

        leftFront.setInverted(false);
        Left_rear.setInverted(false);

        //sets to coast mode so that it doesn't stop abruptly
        rightFront.setNeutralMode(NeutralMode.Coast);
        Right_rear.setNeutralMode(NeutralMode.Coast);

        leftFront.setNeutralMode(NeutralMode.Coast);
        Left_rear.setNeutralMode(NeutralMode.Coast);
    }

    //use two groups so that you can vary the speeds between both of them
    //example: turning
    //you'd need to make one group go faster than the other
    //--> that can be done with two groups that can you can vary the speed with
    private MotorControllerGroup right = new MotorControllerGroup(rightFront, Right_rear);
    private MotorControllerGroup left = new MotorControllerGroup(leftFront, Left_rear);

    //set the speeds for both the controller groups
    public void tankdrive(double right_speed, double left_speed) {
        right.set(right_speed);
        left.set(left_speed);
    }
}
