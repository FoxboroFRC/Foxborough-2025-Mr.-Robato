package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.RoboMap;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;// Dear future coder, FUCK THIS SHIT fucking piece of fucking dogshit :)

public class DriveSubsystem extends SubsystemBase
{
    public Spark leftGroup = new Spark(RoboMap.leftMasterPort);
    public Spark leftSlave = new Spark(RoboMap.leftSlavePort);
    public Spark rightGroup = new Spark(RoboMap.rightMasterPort);
    public Spark rightSlave = new Spark(RoboMap.rightSlavePort);
    
//private Victor Lgroup = new Victor() ;      //Left side variable of tank
//private Victor Rgroup= new Victor();        //Right side variable of tank
                                            //We need to develop a file for all the port number constants to call as arguments
    //SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(leftGroup, leftSlave);
           
    public DifferentialDrive drive = new DifferentialDrive(leftGroup, rightGroup);  

    public DriveSubsystem() {
        //point slaves to masters
        leftSlave.set(leftGroup.get()); //same thing as .follow
        rightSlave.set(rightGroup.get());
        leftGroup.setSafetyEnabled(false);
        rightGroup.setSafetyEnabled(false);
    }

    public void manualDrive(double move, double turn){
        //if(move > 0.05) move = 0.05;
        //if(turn > 0.5) turn = -1;
        drive.arcadeDrive(move, turn);
    }
}
