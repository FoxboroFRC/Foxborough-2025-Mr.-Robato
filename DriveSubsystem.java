package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.util.RoboMap;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;// Dear future coder, FUCK THIS SHIT fucking piece of fucking dogshit :)

public class DriveSubsystem extends SubsystemBase
{
    public SparkMax leftGroup = new SparkMax(RoboMap.leftMasterPort, MotorType.kBrushed);
    public SparkMax leftSlave = new SparkMax(RoboMap.leftSlavePort, MotorType.kBrushed);
    public SparkMax rightGroup = new SparkMax(RoboMap.rightMasterPort, MotorType.kBrushed);
    public SparkMax rightSlave = new SparkMax(RoboMap.rightSlavePort, MotorType.kBrushed);

    

    private final XboxController controller;  
    
    
//private Victor Lgroup = new Victor() ;      //Left side variable of tank
//private Victor Rgroup= new Victor();        //Right side variable of tank
                                            //We need to develop a file for all the port number constants to call as arguments
    //SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(leftGroup, leftSlave);
           
    public final DifferentialDrive drive = new DifferentialDrive(leftGroup, rightGroup);  

    public DriveSubsystem(XboxController controller) {
        //point slaves to masters
        
        leftSlave.set(leftGroup.get()); //same thing as .follow
        rightSlave.set(rightGroup.get());
        this.controller = controller;
    }

    
    //temp for testing senseor
    public boolean getSensorTestButton() {
       return controller.getBButtonPressed();
        
    }

    public void manualDrive(double left, double right){
        //if(move > 0.05) move = 0.05;
        //if(turn > 0.5) turn = -1;
       
        if(left > 0.5)
        {
            left = 1;
        }
        drive.tankDrive(left, right);
    }
    public void periodic() {
        drive.feed();
    }

    public void stop()
    {
        drive.tankDrive(0,0);
    }

    

    
    
}
