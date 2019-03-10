package org.usfirst.frc1225.DeepSpace36.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc1225.DeepSpace36.Robot;
import org.usfirst.frc1225.DeepSpace36.RobotMap;

public class AimArm extends Command {
    private double m_target;
    public AimArm(double level, boolean cargo) {
        requires(Robot.arm);
        m_target = level;
        // double length;
        // double center;
        // // based on the type of target determine the length of the arm + intake
        // // and the center of the intake when it is on the floor
        // if (cargo) {
        //     length = RobotMap.armCargoLength;
        //     center = RobotMap.armCargoCenter;
        // } else {
        //     length = RobotMap.armHatchLength;
        //     center = RobotMap.armHatchCenter;
        // }

        // double height = level - center;
        // double chord = (height - RobotMap.heightOfAxle) * 2;
        // double angle = Math.toDegrees(2 * Math.sinh(chord/(2* length)));
        // double angle = Math.toDegrees(Math.acos((Math.pow(chord, 2.0) - Math.pow(length, 2.0) - Math.pow(length, 2.0)) / (-2.0 * length * length)));
        
        // clicks per degree = total clicks of the encoder / 360 degrees
        // double clicksPerDegree = RobotMap.clicksPerRotation / 360.0;
        // convert the degrees to rotate to clicks of the encoder
        // m_target = angle * clicksPerDegree;

        // SmartDashboard.putNumber("Angle", angle);

    }
    
    @Override
    protected void initialize() {
        Robot.arm.enable();
        // set the target
        Robot.arm.setSetpoint(m_target);
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
