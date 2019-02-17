package org.usfirst.frc1225.DeepSpace36.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1225.DeepSpace36.Robot;

public class ExtendRearLegs extends Command {
    public ExtendRearLegs() {
        // setTimeout(1);
        requires(Robot.rearLegs);
    }

    @Override
    protected void initialize() {
        Robot.rearLegs.leftRearExtend();
        Robot.rearLegs.rightRearExtend();
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
        Robot.rearLegs.leftRearOff();
        Robot.rearLegs.rightRearOff();

    }

    @Override
    protected void interrupted() {
        end();
    }
}
