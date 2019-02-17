package org.usfirst.frc1225.DeepSpace36.commands;

import org.usfirst.frc1225.DeepSpace36.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command {
  public Drive() {
    requires(Robot.driveTrain);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.driveTrain.TeleopDrive(Robot.oi.getdriverJoystick());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.driveTrain.Stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
