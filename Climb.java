package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Climb extends SubsystemBase{
    /*Creates a new Climb */
    //subsystems has the methods that the commands call on

    private SparkMax climbMotor;

    public Climb(int motorID) {
        climbMotor = new SparkMax(motorID, MotorType.kBrushed);
        //can also config in rev software
        //but doing it here makes it easier to replace hardware
    SparkMaxConfig config = new SparkMaxConfig();
    config.smartCurrentLimit(60, 60);
    config.idleMode(IdleMode.kBrake);
    config.inverted(false);
    climbMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void spinMotor(double speed) {
        climbMotor.set(speed);
      }
    
      public void stopMotor() {
        climbMotor.stopMotor();
      }
    
      @Override
      public void periodic() {
        // This method will be called once per scheduler run
      }

}
