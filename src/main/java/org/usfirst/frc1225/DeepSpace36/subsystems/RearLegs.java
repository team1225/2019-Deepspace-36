package org.usfirst.frc1225.DeepSpace36.subsystems;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import org.usfirst.frc1225.DeepSpace36.RobotMap;
import org.usfirst.frc1225.DeepSpace36.commands.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class RearLegs extends Subsystem {
    private DoubleSolenoid rightRear;
    private DoubleSolenoid leftRear;

    public RearLegs() {
        rightRear = new DoubleSolenoid(RobotMap.PCMCANId1, RobotMap.uprightRearPistonId, RobotMap.downrightRearPistonId);
        addChild("RightRear",rightRear);
        
        leftRear = new DoubleSolenoid(RobotMap.PCMCANId1, RobotMap.upleftRearPistonId, RobotMap.downleftRearPistonId);
        addChild("LeftRear",leftRear);
    }

    @Override
    public void initDefaultCommand() {
        // setDefaultCommand(new RetractRearLegs());
    }

    @Override
    public void periodic() {
    }

    public void rightRearExtend() {
        rightRear.set(DoubleSolenoid.Value.kForward);
    }

    public void rightRearRetract() {
        rightRear.set(Value.kReverse);
    }

    public void rightRearOff() {
        rightRear.set(Value.kOff);
    }

    public void leftRearExtend() {
        leftRear.set(DoubleSolenoid.Value.kForward);
    }

    public void leftRearRetract() {
        leftRear.set(Value.kReverse);
    }

    public void leftRearOff() {
        leftRear.set(Value.kOff);
    }
}
