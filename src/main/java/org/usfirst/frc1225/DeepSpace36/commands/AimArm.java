package org.usfirst.frc1225.DeepSpace36.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1225.DeepSpace36.Robot;

public class AimArm extends Command {
    private double m_level;
    public AimArm(double level) {
        requires(Robot.arm);
        this.m_level = level;
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
