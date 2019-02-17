/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc1225.DeepSpace36.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1225.DeepSpace36.Robot;

public class Eject extends Command {
  public Eject() {
    requires(Robot.ejector);
    setTimeout(0.4);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.ejector.eject();
  }

  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  @Override
  protected void end() {
    Robot.ejector.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
