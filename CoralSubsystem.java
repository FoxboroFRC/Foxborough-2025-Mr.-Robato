package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.util.RoboMap;

public class CoralSubsystem extends SubsystemBase{

    public SparkMax coralLauncher = new SparkMax(RoboMap.coralLauncher, MotorType.kBrushed);
    private final XboxController controller;  

public CoralSubsystem(XboxController controller) {
this.controller = controller;
}

public void coralLaunch()
{
    coralLauncher.setVoltage(1);
}

public boolean coralLaunchButtonPressed() {

    return controller.getAButtonPressed();

}

public void stopLaunch() {
    coralLauncher.setVoltage(0);

}


    
}
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.




