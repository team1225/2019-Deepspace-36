package org.usfirst.frc1225.DeepSpace36.subsystems;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import org.usfirst.frc1225.DeepSpace36.RobotMap;
import org.usfirst.frc1225.DeepSpace36.commands.RetractFrontLegs;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class FrontLegs extends Subsystem {
    private DoubleSolenoid rightFront;
    private DoubleSolenoid leftFront;

    public FrontLegs() {
        rightFront = new DoubleSolenoid(RobotMap.PCMCANId1, RobotMap.upleftFrontPistonId, RobotMap.downleftFrontPistonId);
        addChild("RightFront",rightFront);
        
        leftFront = new DoubleSolenoid(RobotMap.PCMCANId1, RobotMap.uprightFrontPistonId, RobotMap.downrightFrontPistonId);
        addChild("LeftFront",leftFront);
    }

    @Override
    public void initDefaultCommand() {
        // setDefaultCommand(new RetractFrontLegs());
    }

    @Override
    public void periodic() {
    }

    public void rightFrontExtend() {
        rightFront.set(DoubleSolenoid.Value.kForward);
    }

    public void rightFrontRetract() {
        rightFront.set(Value.kReverse);
    }

    public void rightFrontOff() {
        rightFront.set(Value.kOff);
    } 
    
    public void leftFrontExtend() {
        leftFront.set(DoubleSolenoid.Value.kForward);
    }

    public void leftFrontRetract() {
        leftFront.set(Value.kReverse);
    }

    public void leftFrontOff() {
        // leftFront.set(Value.kOff);
    }
}
