// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.Autos;
import frc.robot.commands.DriveManuallyCommand;
import frc.robot.commands.CoralLaunch;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.TestDrive;
import frc.robot.commands.autoDrive;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.CoralSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.util.RoboMap;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */

// A simple auto routine that drives forward a specified distance, and then stops.
  
public class RobotContainer {
  // Replace with CommandPS4Controller or CommandJoystick if needed
  public final XboxController driverController =
     new XboxController(RoboMap.joystickPort);
     private final DriveSubsystem driveSubsystem = new DriveSubsystem();
     private final CoralSubsystem coralSubsystem = new CoralSubsystem(driverController);
     public final autoDrive simpleAuto =
      new autoDrive(driveSubsystem);

      public final CommandXboxController test = null;
      /*controller is not the same as xbox controller
      *please cross reference for right commands and values
      */

  //we don't have a complexAuto lol
  //private final Command complexAuto = new ComplexAuto(robotDrive, hatchSubsystem);

 /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return simpleAuto;
 }


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    
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
    
    /*new Trigger(m_ExampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_ExampleSubsystem));
*/
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    driveSubsystem.setDefaultCommand(
      new DriveManuallyCommand(driveSubsystem, driverController)); //Always active

      new Trigger(coralSubsystem::coralLaunchButtonPressed).onTrue(new CoralLaunch(coralSubsystem));
      
        
  }
   //m_driverController.leftStick().whileTrue(new DriveManuallyCommand());
   //m_driverController.rightStick().whileTrue(new DriveManuallyCommand());
  
}