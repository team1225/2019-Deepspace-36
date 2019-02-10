package org.usfirst.frc1225.DeepSpace36.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1225.DeepSpace36.Robot;
import org.usfirst.frc1225.DeepSpace36.RobotMap;

public class AimArm extends Command {
    private double m_level;
    public AimArm(double level, boolean cargo) {
        requires(Robot.arm);
        double length;
        double center;
        if (cargo) {
            length = RobotMap.armCargoLength;
            center = RobotMap.armCargoCenter;
        } else {
            length = RobotMap.armHatchLength;
            center = RobotMap.armHatchCenter;
        }
        double degreesPerInch = 2 * 3.1415 * length;

        this.m_level = (level - center) / degreesPerInch / 360;
    }

    @Override
    protected void initialize() {
        Robot.arm.enable();
        Robot.arm.setSetpoint(m_level);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return Robot.arm.onTarget();
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
