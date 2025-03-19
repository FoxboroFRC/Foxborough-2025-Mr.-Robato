// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveBase;

import java.util.function.DoubleSupplier;

import javax.lang.model.util.ElementScanner14;

import edu.wpi.first.wpilibj.XboxController;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveCommand extends Command {
  /** Creates a new DriveManuallyCommand. */

  /*each command links back to the subsytem.
   *The subsystem contains the actual method for doing stuff, but the command is the one called and updated frequently
   *
   * 
   */
  private final DriveBase drivebase;
  private final DoubleSupplier leftSupplier;
  private final DoubleSupplier rightSupplier;

  public DriveCommand(DriveBase drivebase, DoubleSupplier leftSupplier, DoubleSupplier rightSupplier) {
   //parameters added here to be usable in RobotContainer with right inputs and stuff.

    this.drivebase = drivebase;
    this.leftSupplier = leftSupplier;
    this.rightSupplier = rightSupplier;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivebase); 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}
  // Ensure this is initialized properly


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
     drivebase.manualDrive(leftSupplier.getAsDouble(), rightSupplier.getAsDouble());
  /* 
  double leftRaw = leftSupplier.getAsDouble();
  double rightInverted = rightSupplier.getAsDouble(); 
  double leftAdjusted;
  double rightAdjusted;
  //rightTriggerAxis is rightY and leftTriggerAxis is rightX
 

  //left vv
 if (leftRaw >= 0)
 {
   if (leftRaw <= 0.1) {
     leftAdjusted = leftRaw + 0.15;
   }
   else if (leftRaw > 0.1 && leftRaw < 0.8){
    leftAdjusted = leftRaw/1.75 + .25;
   }
   else 
   leftAdjusted = leftRaw/ 1.5 + .4;
 
 }
 else
 {
  
   if (leftRaw >= -0.1 &&) {
     leftAdjusted = leftRaw + 0.15;
   }
  else if (leftRaw < -0.1 && leftRaw < -0.8) {
    leftAdjusted = leftRaw/1.75 - .25;
   }
   else 
   leftAdjusted = leftRaw / 1.5 - 0.4;
  
 }

 //right vv
 if (rightInverted >= 0)
 {
   if (rightInverted <= 0.1 && rightInverted) {
     rightAdjusted = rightInverted + 0.15;
   }
   else if (rightInverted > 0.1 && rightInverted < 0.8) {
    rightAdjusted = rightInverted/1.75 + .25;
   }
   else 
   rightAdjusted = rightInverted/1.5 + 0.4;
  
 }

 else
 {
  
   if (rightInverted > -0.1 && rightInverted < -0.02) {
     rightAdjusted = rightInverted + 0.15 ;
   }
   else if (rightInverted < -0.1 && rightInverted > -0.8) {
    rightAdjusted = rightInverted/1.75 - .25;
   }
   else
   rightAdjusted = rightInverted/1.5 - 0.4;
 
 }
 

  drivebase.manualDrive(leftAdjusted, rightAdjusted);
  */
  }

// Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    drivebase.manualDrive(0, 0);
    
  }

  // Returns true when the command should end.
  //can be left as false because the binding is configured to interretup 
  //when it the buttn is realeased anyway (whileTrue)
  @Override
  public boolean isFinished() {
    return false;
  }
}
