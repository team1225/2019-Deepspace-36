package org.usfirst.frc1225.DeepSpace36.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1225.DeepSpace36.Robot;
import org.usfirst.frc1225.DeepSpace36.RobotMap;

public class ArmtoC1 extends Command {
    public ArmtoC1() {
        requires(Robot.arm);
        setTimeout(1);
    }

    @Override
    protected void initialize() {
        Robot.arm.raise();
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return Robot.arm.encoderValue() == RobotMap.Cargo1;
    }

    @Override
    protected void end() {
        Robot.arm.stop();
    }

    @Override
    protected void interrupted() {
    }

    
}
