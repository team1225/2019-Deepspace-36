package org.usfirst.frc1225.DeepSpace36.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1225.DeepSpace36.Robot;

public class RetractRearLegs extends Command {
    public RetractRearLegs() {
        requires(Robot.rearLegs);
    }

    @Override
    protected void initialize() {
        Robot.rearLegs.leftRearRetract();
        Robot.rearLegs.rightRearRetract();
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
