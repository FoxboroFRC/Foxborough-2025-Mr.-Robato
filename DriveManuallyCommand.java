// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveManuallyCommand extends Command {
  /** Creates a new DriveManuallyCommand. */
  private final DriveSubsystem driveSubsystem;
private final CommandXboxController controller;

  public DriveManuallyCommand(DriveSubsystem driveSubsystem, CommandXboxController controller) {
   //just added double move and double turn parameters because chatgpt wah
    // Use addRequirements() here to declare subsystem dependencies.
    this.driveSubsystem = driveSubsystem;
    this.controller = controller;
    

    addRequirements(driveSubsystem); 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  // Ensure this is initialized properly
  // Called every time the scheduler runs while the command is scheduled.
 

  @Override
  public void execute() {

  // Called once the command ends or is interrupted.
 //RobotContainer robotContainer = new RobotContainer(); // Ensure this is initialized properly
 double move = -1 * controller.getLeftY();
 double turn = controller.getRightX();
 
System.out.println("This is in the execute of driveCommand." + move + " and now turn: " + turn);
 driveSubsystem.manualDrive(move, turn);
 

  }


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
