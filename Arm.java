package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase{

    private final SparkMax armMotor;
    private final SparkClosedLoopController pidController;
    public final RelativeEncoder armEncoder;

    public Arm(int motorId) {

        armMotor = new SparkMax(motorId, MotorType.kBrushless);
    SparkMaxConfig config = new SparkMaxConfig();
    config.smartCurrentLimit(90, 90);
    config.idleMode(IdleMode.kBrake);
    config.inverted(false);
    armMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    pidController = armMotor.getClosedLoopController();
    armEncoder = armMotor.getEncoder();
    }


    public void spinMotor(double angle) {
        pidController.setReference(angle, ControlType.kPosition);
        
      }

      public void justGo() {
        armMotor.set(-1);
      }
    
      public void stopMotor() {
        armMotor.stopMotor();
      }
    
      @Override
      public void periodic() {
        // This method will be called once per scheduler run
      }

      public void armEncoderReset() {
        armEncoder.setPosition(0);
      }

}
