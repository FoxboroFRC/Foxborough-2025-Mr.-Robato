// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import frc.robot.commands.Autos;
import frc.robot.commands.DriveManuallyCommand;
import frc.robot.commands.CoralLaunch;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.TestDrive;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.CoralSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.util.RoboMap;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */

// A simple auto routine that drives forward a specified distance, and then stops.
  private final Command m_simpleAuto =
      new DriveDistance(
          AutoConstants.kAutoDriveDistanceInches, AutoConstants.kAutoDriveSpeed, m_robotDrive);

  // A complex auto routine that, for example, could drive forward, drop a hatch, and then drive backward.
  private final Command m_complexAuto = new ComplexAuto(m_robotDrive, m_hatchSubsystem);

  SendableChooser<Command> m_chooser = new SendableChooser<>();  // This code creates a menu where you can choose which trick the robot does

// Add commands to the autonomous command chooser
    m_chooser.setDefaultOption("Simple Auto", m_simpleAuto);
    m_chooser.addOption("Complex Auto", m_complexAuto);

// Put the chooser on the dashboard
SmartDashboard.putData(m_chooser);


public class RobotContainer {
  // Replace with CommandPS4Controller or CommandJoystick if needed
  public final XboxController driverController =
     new XboxController(RoboMap.joystickPort);
     private final DriveSubsystem driveSubsystem = new DriveSubsystem();
     private final CoralSubsystem coralSubsystem = new CoralSubsystem(driverController);

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
      
        
    
   //m_driverController.leftStick().whileTrue(new DriveManuallyCommand());
   //m_driverController.rightStick().whileTrue(new DriveManuallyCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    //return Autos.exampleAuto(m_driveSubsystem);//change this to actual autonums method
    return null;
  }
}
