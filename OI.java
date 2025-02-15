package frc.robot.util;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
    public Joystick stick;

    public OI() {
        stick = new Joystick(0); // Ensure this matches the port in RoboMap
    }
}
