package org.usfirst.frc1225.DeepSpace36.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1225.DeepSpace36.Robot;

public class RaiseArm extends Command {
    public RaiseArm() {
        requires(Robot.arm);
    }

    @Override
    protected void initialize() {
    }
    
    @Override
    protected void execute() {
        Robot.arm.raise();
        
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.arm.stop();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
