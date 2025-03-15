package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Climb;

public class climbCommand extends Command{
    

  //variables usable everywhere in this file
    private final Climb climb;
    private double speed;


    public climbCommand(Climb climb, double speed) {
        this.climb = climb;
        this.speed = speed;
    }


    @Override
  public void initialize() {}

  //called every time the scheduler runs while the command is scheduled 
@Override
  public void execute() {
    climb.spinMotor(speed);
  }


  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climb.stopMotor();
  }

  // Returns true when the command should end.
  //can be left as false because the binding is configured to interretup 
  //when it the buttn is realeased anyway (whileTrue)
  @Override
  public boolean isFinished() {
    return false;
  }












}
