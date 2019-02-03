package org.usfirst.frc1225.DeepSpace36.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1225.DeepSpace36.Robot;

public class RetractFrontLegs extends Command {
    public RetractFrontLegs() {
        requires(Robot.legs);
        setTimeout(1);
    }

    @Override
    protected void initialize() {
        Robot.legs.rightFrontRetract();
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        Robot.legs.rightFrontOff();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
