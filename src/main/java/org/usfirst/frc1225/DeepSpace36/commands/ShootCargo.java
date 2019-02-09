package org.usfirst.frc1225.DeepSpace36.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1225.DeepSpace36.Robot;

public class ShootCargo extends Command {
    public ShootCargo() {
        requires(Robot.intake);

    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.intake.out();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.intake.stop();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
