// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.armCommand;
import frc.robot.commands.climbCommand;
import frc.robot.commands.coralCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Coral;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.ExampleSubsystem;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // Replace with CommandPS4Controller or CommandJoystick if needed
  //joystick class is used because we don't have an xbox, so usng joystick is just easy
  private final Joystick driverjs = new Joystick(0);
  


  //joystick bindings
  //buttons used: 1 2 3 4 5 6 7 8 9 10
  private final JoystickButton coralbutton = new JoystickButton(driverjs, 3);
  private final JoystickButton coralFastbutton = new JoystickButton(driverjs, 4);
  private final JoystickButton coralButtonReverse = new JoystickButton(driverjs, 5);
  private final JoystickButton slowButton = new JoystickButton(driverjs, 6);
  private final JoystickButton climbOutButton = new JoystickButton(driverjs, 2);
  private final JoystickButton climbInButton = new JoystickButton(driverjs, 1);
  private final JoystickButton armLow = new JoystickButton(driverjs, 7);
  private final JoystickButton armHigh = new JoystickButton(driverjs, 8);
  private final JoystickButton armBack = new JoystickButton(driverjs, 9);
 

  //makes subsystem references, which the commands use as parameters
  private final DriveBase drivebase = new DriveBase(6, 1, 3,5 );
  private final Coral coral = new Coral(2);
  private final Climb climb = new Climb (4);
  private final Arm arm = new Arm(7);

  private final RelativeEncoder armEncoder = arm.armEncoder;
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    //defaultCommand sets the command that will always be on
    drivebase.setDefaultCommand(new DriveCommand(drivebase, () -> 0.8 * driverjs.getRawAxis(1), () -> 0.8 * driverjs.getRawAxis(5)));
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    // new Trigger(m_exampleSubsystem::exampleCondition)
    //     .onTrue(new ExampleCommand(m_exampleSubsystem));

    //does the speed constants here instead of in the command so constants are 
    //all in one place
    coralbutton.whileTrue(new coralCommand(coral, 0.4));
    coralFastbutton.whileTrue(new coralCommand(coral, 0.7));
    coralButtonReverse.whileTrue(new coralCommand(coral, -0.6));
    slowButton.whileTrue(new DriveCommand(drivebase, () -> 0.9 * driverjs.getRawAxis(1), () -> 0.9 * driverjs.getRawAxis(5)));
    climbOutButton.whileTrue(new climbCommand(climb, 0.5));
    climbInButton.whileTrue(new climbCommand(climb, -0.5));
    armLow.whileTrue(new armCommand(arm, 155, false));
    armHigh.whileTrue(new armCommand(arm, 155, false));
    armBack.whileTrue(new armCommand(arm, 0, true));
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous

    //drives for some, waits for 6 seconds, then drops the coral
    return new DriveCommand(drivebase, () -> -0.5, () -> -0.5)
      .withDeadline(new WaitCommand(6))
      .andThen(new coralCommand(coral, 0.4));
  }
}
