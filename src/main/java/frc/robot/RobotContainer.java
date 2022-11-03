// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.commands.LowerShoot;
//import frc.robot.commands.ExampleCommand;
import frc.robot.commands.UpperShoot;
//import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  // private final DriveTrain m_DriveTrain = new DriveTrain();
  private final Shooter shooter = new Shooter();

  private final UpperShoot upperShoot = new UpperShoot(shooter); //thingy to activate the shoot
  private final LowerShoot lowerShoot = new LowerShoot(shooter); // thingy to activate the shoot

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    XboxController controller = new XboxController(0); //create the controller w/the port

    JoystickButton B = new JoystickButton(controller, Button.kB.value); //button map B
    JoystickButton A = new JoystickButton(controller, Button.kA.value); //button map A
    
    B.whenPressed(upperShoot).whenReleased(new LowerShoot(shooter)); //when B is pressed run the command
    A.whenPressed(lowerShoot).whenReleased(new UpperShoot(shooter)); // when A is pressed run the command

    //note: whenPressed() will make the motor start and nothing will stop it unless you manually kill the program
    //use whenHeld() to make the button only activate the motor when it's pressed (HELD down)
  
  
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return upperShoot;
  }
}
