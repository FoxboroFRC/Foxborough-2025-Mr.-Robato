package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.util.RoboMap;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;// Dear future coder, FUCK THIS SHIT fucking piece of fucking dogshit :)

public class DriveSubsystem extends SubsystemBase
{
    public SparkMax leftGroup = new SparkMax(RoboMap.leftMasterPort, MotorType.kBrushed);
    public SparkMax leftSlave = new SparkMax(RoboMap.leftSlavePort, MotorType.kBrushed);
    public SparkMax rightGroup = new SparkMax(RoboMap.rightMasterPort, MotorType.kBrushed);
    public SparkMax rightSlave = new SparkMax(RoboMap.rightSlavePort, MotorType.kBrushed);
    
    
//private Victor Lgroup = new Victor() ;      //Left side variable of tank
//private Victor Rgroup= new Victor();        //Right side variable of tank
                                            //We need to develop a file for all the port number constants to call as arguments
    //SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(leftGroup, leftSlave);
           
    public final DifferentialDrive drive = new DifferentialDrive(leftGroup, rightGroup);  

    public DriveSubsystem() {
        //point slaves to masters
        
        leftSlave.set(leftGroup.get()); //same thing as .follow
        rightSlave.set(rightGroup.get());
        
    }

    public void manualDrive(double left, double right){
        //if(move > 0.05) move = 0.05;
        //if(turn > 0.5) turn = -1;
       
       
        drive.tankDrive(left, right);
    }
    public void periodic() {
        drive.feed();
    }

    public void setMotorSpeeds(double left, double right)
    {
        leftGroup.setVoltage(left);
        rightGroup.setVoltage(right);
    }

    
    
}
