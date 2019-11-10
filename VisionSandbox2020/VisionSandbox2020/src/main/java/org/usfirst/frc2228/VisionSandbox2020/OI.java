// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2228.VisionSandbox2020;

import org.usfirst.frc2228.VisionSandbox2020.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private XboxController xbox;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        xbox = new XboxController(0);
        


        // SmartDashboard Buttons
        SmartDashboard.putData("moveCameraForward", new moveCameraForward());
        SmartDashboard.putData("moveCameraBackward", new moveCameraBackward());
        SmartDashboard.putData("stopCamera", new stopCamera());

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
     public boolean getXboxAButton() { return xbox.getAButton(); }
public boolean getXboxBButton() { return xbox.getBButton(); }
public boolean getXboxXButton() { return xbox.getXButton(); }
public boolean getXboxYButton() { return xbox.getYButton(); }
public boolean getXboxStartButton() { return xbox.getStartButton(); }
public boolean getXboxBackButton() { return xbox.getBackButton(); }
public boolean getXboxRightBumper() { return xbox.getBumper(Hand.kRight); }
public boolean getXboxLeftBumper() { return xbox.getBumper(Hand.kLeft); }
public boolean getXboxLeftJoystickPress() { return xbox.getStickButton(Hand.kLeft); }
public boolean getXboxRightJoystickPress() { return xbox.getStickButton(Hand.kRight); }
public double getXboxRightTrigger() { return xbox.getTriggerAxis(Hand.kRight); }
public double getXboxLeftTrigger() { return xbox.getTriggerAxis(Hand.kLeft); }
public double getXboxRightJoystickX() { return xbox.getX(Hand.kRight); }
public double getXboxRightJoystickY() { return xbox.getY(Hand.kRight); }
public double getXboxLeftJoystickX() { return xbox.getX(Hand.kLeft); }
public double getXboxLeftJoystickY() { return xbox.getY(Hand.kLeft); }
public boolean getXboxDpadUp() { int pov = xbox.getPOV(0); return (((pov >= 0) && (pov <= 45)) || ((pov >= 315) && (pov <= 360))); }
public boolean getXboxDpadRight() { int pov = xbox.getPOV(0); return ((pov >= 45) && (pov <= 135)); }
public boolean getDpadDown() { int pov = xbox.getPOV(0); return ((pov >= 135) && (pov <= 225)); }
public boolean getDpadLeft() { int pov = xbox.getPOV(0); return ((pov >= 225) && (pov <= 315)); }
public void setXboxRumbleSpeed(double rumbleSpeed) { xbox.setRumble(RumbleType.kLeftRumble, rumbleSpeed); xbox.setRumble(RumbleType.kRightRumble, rumbleSpeed); }
public void setXboxLeftRumbleSpeed(double rumbleSpeed) { xbox.setRumble(RumbleType.kLeftRumble, rumbleSpeed); }
public void setXboxRightRumbleSpeed(double rumbleSpeed) { xbox.setRumble(RumbleType.kRightRumble, rumbleSpeed); }
public void setXboxRumbleStop() { this.setXboxRumbleSpeed(0); }
public double getThrottleValue() { return this.getXboxLeftJoystickY(); }
public double getStrafeValue() { return this.getXboxLeftJoystickX(); }
public double getTurnValue() { return this.getXboxRightJoystickX(); } 


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

