// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2228.VisionSandbox2020.subsystems;

import org.usfirst.frc2228.VisionSandbox2020.Robot;
import org.usfirst.frc2228.VisionSandbox2020.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class VisionProcessor extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
    public static final String VISION_DATA_TABLE_KEY = "datatable";
    public static final String TABLE_ENTRY_TARGET_STATE = "targState";
    public static final String TABLE_ENTRY_DIST_TO_TARGET = "distTargetIn";
    public static final String TABLE_ENTRY_HORIZ_OFFSET_INCHES = "horzOffToIn";
    public static final int DEFAULT_TABLE_ENTRY_VALUE = 42069666;
    public static final int TARGET_STATE_SEARCHNG = 0;
    public static final int TARGET_STATE_ACQUIRING = 1;
    public static final int TARGET_STATE_LOCKED = 2;
    public static final int MINIMUM_TARGET_DISTANCE = 18;
    public static final int MAXIMUM_TARGET_DISTANCE = 48;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private NetworkTableInstance visionDataTableInst;
    private NetworkTable visionDataTable;
    private Command moveCameraForward;
    private Command moveCameraBackward;
    private Command stopCamera;

    // state, 0 for searching, 1 for acquiring, or 2 for locked
    private NetworkTableEntry targStateNTE;
    // distance to target in inches,
    private NetworkTableEntry distTargInNTE;
    // horizontal distance from center of target, positive being to the right
    private NetworkTableEntry horzOffInNTE;
    private boolean inRange = false;

    public VisionProcessor() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        visionDataTableInst = NetworkTableInstance.getDefault();
        visionDataTable = visionDataTableInst.getTable(VISION_DATA_TABLE_KEY);
        targStateNTE = visionDataTable.getEntry(TABLE_ENTRY_TARGET_STATE);
        distTargInNTE = visionDataTable.getEntry(TABLE_ENTRY_DIST_TO_TARGET);
        horzOffInNTE = visionDataTable.getEntry(TABLE_ENTRY_HORIZ_OFFSET_INCHES);

        moveCameraBackward = (new moveCameraBackward());
        moveCameraForward = (new moveCameraForward());
        stopCamera = (new stopCamera());
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
        if ((getDistanceFromTarget() < MAXIMUM_TARGET_DISTANCE)
                && (getDistanceFromTarget() > MINIMUM_TARGET_DISTANCE)) {
            if (getCameraState() == TARGET_STATE_LOCKED) {
                inRange = true;

                double horizontalOffset = getHorizOffsetFromCenter();
                // System.out.println("horizontalOffset: " + horizontalOffset);

                if (horizontalOffset < ((-1) * (RobotConstants.VISION_TARGET_TOLERANCE_IN_INCHES))) {
                    if (!Robot.cameraDriveSystem.getIsMoving()) {
                        moveCameraBackward.start();
                    }
                } else if (horizontalOffset > RobotConstants.VISION_TARGET_TOLERANCE_IN_INCHES) {
                    if (!Robot.cameraDriveSystem.getIsMoving()) {
                        moveCameraForward.start();
                    }
                } else {
                    if (Robot.cameraDriveSystem.getIsMoving()) {
                        stopCamera.start();
                    }
                }
            } else {
                inRange = false;

                if (Robot.cameraDriveSystem.getIsMoving()) {
                    stopCamera.start();
                }
            }
        } else {
            inRange = false;

            if (Robot.cameraDriveSystem.getIsMoving()) {
                stopCamera.start();
            }
        }

        SmartDashboard.putBoolean("In Range", inRange);
        /*
         * SmartDashboard.putNumber("Target State",
         * targState.getDouble(DEFAULT_TABLE_ENTRY_VALUE));
         * SmartDashboard.putNumber("Distance to Target (in)",
         * distTargIn.getDouble(DEFAULT_TABLE_ENTRY_VALUE));
         * SmartDashboard.putNumber("Horiz. Offset in (in)",
         * horzOffToIn.getDouble(DEFAULT_TABLE_ENTRY_VALUE));
         */
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public double getDistanceFromTarget() {
        return distTargInNTE.getDouble(DEFAULT_TABLE_ENTRY_VALUE);
    }

    public double getHorizOffsetFromCenter() {
        return horzOffInNTE.getDouble(DEFAULT_TABLE_ENTRY_VALUE);
    }

    public int getCameraState() {
        return (int) targStateNTE.getDouble(DEFAULT_TABLE_ENTRY_VALUE);
    }
}
