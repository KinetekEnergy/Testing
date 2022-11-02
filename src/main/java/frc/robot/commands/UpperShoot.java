// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Shooter;
//import edu.wpi.first.wpilibj.PS4Controller.Button;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
//import frc.robot.Constants;

/** An example command that uses an example subsystem. */
public class UpperShoot extends CommandBase {
    @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" }) // suppress useless warnings
    private final Shooter shooter;

    /**
     * Creates a new UpperShoot.
     *
     * @param upperShoot The subsystem used by this command.
     */
    public UpperShoot(Shooter upperShoot) { // method called uppershoot
        shooter = upperShoot;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(upperShoot);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        shooter.set_speed(0.5); // set the speed of the motor
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        // Shooter.set_speed(0);
        return false;
    }
}