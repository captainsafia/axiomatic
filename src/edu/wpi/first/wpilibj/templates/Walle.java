/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Walle extends SimpleRobot {
    // Variable initializations 
    RobotDrive drive;
    Joystick leftStick;
    Joystick rightStick;
    
    // Joystick constants
    int LEFT_JOYSTICK_USB = 1;
    int RIGHT_JOYSTICK_USB = 2;
    
    // Motor constants
    int FRONT_LEFT_MOTOR_PWM = 1;
    int REAR_LEFT_MOTOR_PWM = 2;
    int FRONT_RIGHT_MOTOR_PWM = 3;
    int REAR_RIGHT_MOTOR_PWM = 4;
    
    // Motor controller configurations
    Jaguar frontLeft = new Jaguar(FRONT_LEFT_MOTOR_PWM);
    Victor rearLeft = new Victor(REAR_LEFT_MOTOR_PWM);
    Jaguar frontRight = new Jaguar(FRONT_RIGHT_MOTOR_PWM);
    Victor rearRight = new Victor(REAR_RIGHT_MOTOR_PWM);

    public Walle() {
        drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
        leftStick = new Joystick(LEFT_JOYSTICK_USB);
        rightStick = new Joystick(RIGHT_JOYSTICK_USB);
    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {

    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        while (true && isOperatorControl() && isEnabled()) {
            drive.tankDrive(leftStick, rightStick);
            Timer.delay(0.005);
        }
    }

    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {

    }
}
