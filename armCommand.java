package frc.robot.commands;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkRelativeEncoder;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;


public class armCommand extends Command{
    
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.



/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */

  /** Creates a new coralCommand. */
  private final Arm arm;
  private final double angle;
  private final boolean reset;
  
  
  public armCommand(Arm arm, double angle, boolean reset) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.arm = arm;
    
    this.angle = angle;
    this.reset = reset;
    

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

 

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //encoder gets rotation percents just how it works
    //if reset true then just whip back while held
    //otherwise do like the actual thing where it stops at position
    
    if(!reset){
        arm.spinMotor(-angle/360.0);
    }
    else
    {
        arm.justGo();
        arm.armEncoderReset();
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.stopMotor();
  }

  // Returns true when the command should end.
  //can be left as false because the binding is configured to interretup 
  //when it the buttn is realeased anyway (whileTrue)
  @Override
  public boolean isFinished() {
    return false;
  }
}
