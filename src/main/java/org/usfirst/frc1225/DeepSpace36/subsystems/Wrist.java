package org.usfirst.frc1225.DeepSpace36.subsystems;

import org.usfirst.frc1225.DeepSpace36.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import org.usfirst.frc1225.DeepSpace36.RobotMap;

public class Wrist extends Subsystem {
    private DoubleSolenoid wrist;

    public Wrist() {
        wrist = new DoubleSolenoid(
            RobotMap.PCMCANId2,
            RobotMap.RaiseWristChannel,
            RobotMap.LowerWristChannel
        );
        addChild("Wrist",wrist);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new RaiseWrist());
    }

    @Override
    public void periodic() {
    }

    public void Drop() {
        wrist.set(DoubleSolenoid.Value.kForward);
    }

    public void Raise() {
        wrist.set(DoubleSolenoid.Value.kReverse);
    }
}
