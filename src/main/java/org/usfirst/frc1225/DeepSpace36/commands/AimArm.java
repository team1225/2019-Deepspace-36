package org.usfirst.frc1225.DeepSpace36.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc1225.DeepSpace36.Robot;
import org.usfirst.frc1225.DeepSpace36.RobotMap;

public class AimArm extends Command {
    private double m_target;
    public AimArm(double level, boolean cargo) {
        requires(Robot.arm);
        SmartDashboard.putNumber("LEVEL", level);
        double length;
        double center;
        // based on the type of target determine the length of the arm + intake
        // and the center of the intake when it is on the floor
        if (cargo) {
            length = RobotMap.armCargoLength;
            center = RobotMap.armCargoCenter;
        } else {
            length = RobotMap.armHatchLength;
            center = RobotMap.armHatchCenter;
        }
        // 2*pi*radius = circumferance --- circumferance / 360 degrees = the length
        // of the arch of one degree
        double degreesPerInch = 2.0 * 3.1415 * length / 360.0;
        // level = center of target
        // center = center of the intake at the floor
        // the difference between the level and the center is the distance to travel from 
        // the floor to the target
        // degrees to rotate = the amount of travel / degrees per inch
        double degreesToRotate = (level - center) / degreesPerInch;
        // clicks per degree = total clicks of the encoder / 360 degrees
        double clicksPerDegree = RobotMap.clicksPerRotation / 360.0;
        // convert the degrees to rotate to clicks of the encoder
        this.m_target = degreesToRotate * clicksPerDegree;

        SmartDashboard.putNumber("AimARM/length", length);
        SmartDashboard.putNumber("AimARM/level", level);
        SmartDashboard.putNumber("AimARM/center", center);
        SmartDashboard.putNumber("AimARM/degreesInch", degreesPerInch);
        SmartDashboard.putNumber("AimARM/SetPoint", m_target);

        // set the target
        Robot.arm.setSetpoint(m_target);
    }

    @Override
    protected void initialize() {
        Robot.arm.enable();
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        // return Robot.arm.onTarget();
        return false;
    }

    @Override
    protected void end() {
        Robot.arm.disable();
    }

    @Override
    protected void interrupted() {
        Robot.arm.disable();
    }
}
