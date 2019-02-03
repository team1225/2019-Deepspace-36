package org.usfirst.frc1225.DeepSpace36.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1225.DeepSpace36.Robot;

public class ExtendFrontLegs extends Command {
    public ExtendFrontLegs() {
        setTimeout(1);
        requires(Robot.legs);
    }

    @Override
    protected void initialize() {
        Robot.legs.rightFrontExtend();
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
