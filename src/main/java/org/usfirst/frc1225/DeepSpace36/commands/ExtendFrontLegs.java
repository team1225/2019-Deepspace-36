package org.usfirst.frc1225.DeepSpace36.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1225.DeepSpace36.Robot;

public class ExtendFrontLegs extends Command {
    public ExtendFrontLegs() {
        // setTimeout(5);
        requires(Robot.frontLegs);
    }

    @Override
    protected void initialize() {
        Robot.frontLegs.leftFrontExtend();
        Robot.frontLegs.rightFrontExtend();
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return false;// isTimedOut();
    }

    @Override
    protected void end() {
        Robot.frontLegs.leftFrontOff();
        Robot.frontLegs.rightFrontOff();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
