
package frc.robot.commands;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.util.RoboMap;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

//basically sensor distance is getVoltage();

public class SensorTest extends Command {
  private final DriveSubsystem driveSubsystem;
  private final XboxController controller;
  public AnalogInput ultraSonicSensor = new AnalogInput(RoboMap.ultraSonicSensorPort);

  public SensorTest(DriveSubsystem driveSubsystem, XboxController controller) {
    this.driveSubsystem = driveSubsystem;
    this.controller = controller;
    addRequirements(driveSubsystem);
  }

  @Override
  public void initialize() {
    //reset sensor

    
  }

  @Override
  public void execute() {
   

double voltage, cm;

   voltage = ultraSonicSensor.getVoltage();

   cm = voltage*102.4;

   System.out.println(voltage);
}




  

  @Override
  public boolean isFinished() {
    return controller.getBButton();
  }

  @Override
  public void end(boolean interrupted) {
    
  }
}

