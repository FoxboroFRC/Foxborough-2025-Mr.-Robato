// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.XboxController;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveManuallyCommand extends Command {
  /** Creates a new DriveManuallyCommand. */

  /*each command links back to the subsytem.
   *The subsystem contains the actual method for doing stuff, but the command is the one called and updated frequently
   *
   * 
   */
  private final DriveSubsystem driveSubsystem;
private final XboxController controller;

  public DriveManuallyCommand(DriveSubsystem driveSubsystem, XboxController controller) {
   //parameters added here to be usable in RobotContainer with right inputs and stuff.

    this.driveSubsystem = driveSubsystem;
    this.controller = controller;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSubsystem); 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  // Ensure this is initialized properly


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

  
 double left =   controller.getLeftY();
 double right = -1 * controller.getRightTriggerAxis(); 
 //rightTriggerAxis is rightY and leftTriggerAxis is rightX
 driveSubsystem.manualDrive(left, right);
 

  }

// Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    driveSubsystem.manualDrive(0, 0);
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
