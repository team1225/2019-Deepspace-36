package org.usfirst.frc1225.DeepSpace36.subsystems;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import org.usfirst.frc1225.DeepSpace36.RobotMap;


public class Intake extends Subsystem {
    private DoubleSolenoid wrist;
    private DoubleSolenoid ejector;
    private CANSparkMax rollers;


    public Intake() {
        wrist = new DoubleSolenoid(0, 0, 1);
        addChild("Wrist",wrist);
        
        ejector = new DoubleSolenoid(1, 2, 3);
        addChild("Ejector",ejector);
        
        rollers = new CANSparkMax(RobotMap.IntakeCANId, MotorType.kBrushless);
    }

    @Override
    public void initDefaultCommand() {
        // setDefaultCommand();
    }

    @Override
    public void periodic() {
    }

    public void in() {
        rollers.set(-1);
    }

    public void out() {
        rollers.set(1);    
    }

    public void stop() {
        rollers.set(0);
    }

    public void DropIntake() {
        wrist.set(DoubleSolenoid.Value.kForward);
    }

    public void RaiseIntake() {
        wrist.set(DoubleSolenoid.Value.kReverse);
    }

    

}
