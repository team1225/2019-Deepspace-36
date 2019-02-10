package org.usfirst.frc1225.DeepSpace36.subsystems;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Legs extends Subsystem {
    private DoubleSolenoid rightFront;
    private DoubleSolenoid leftFront;
    private DoubleSolenoid rightRear;
    private DoubleSolenoid leftRear;

    public Legs() {
        rightFront = new DoubleSolenoid(6, 0, 1);
        addChild("RightFront",rightFront);
        
        leftFront = new DoubleSolenoid(0, 4, 5);
        addChild("LeftFront",leftFront);
        
        rightRear = new DoubleSolenoid(0, 6, 7);
        addChild("RightRear",rightRear);
        
        leftRear = new DoubleSolenoid(1, 0, 1);
        addChild("LeftRear",leftRear);
    }

    @Override
    public void initDefaultCommand() {
        // setDefaultCommand();
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
}
