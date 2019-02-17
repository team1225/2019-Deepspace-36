package org.usfirst.frc1225.DeepSpace36.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1225.DeepSpace36.Robot;

public class RetractFrontLegs extends Command {
    public RetractFrontLegs() {
        requires(Robot.frontLegs);
    }

    @Override
    protected void initialize() {
        Robot.frontLegs.leftFrontRetract();
        Robot.frontLegs.rightFrontRetract();
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
