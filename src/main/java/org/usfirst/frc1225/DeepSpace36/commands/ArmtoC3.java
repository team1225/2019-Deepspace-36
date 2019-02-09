package org.usfirst.frc1225.DeepSpace36.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1225.DeepSpace36.Robot;
import org.usfirst.frc1225.DeepSpace36.RobotMap;

public class ArmtoC3 extends Command {
    public ArmtoC3() {
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
        return Robot.arm.encoderValue() == RobotMap.Cargo3;
    }

    @Override
    protected void end() {
        Robot.arm.stop();
    }

    @Override
    protected void interrupted() {
    }

    
}
