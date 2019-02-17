package org.usfirst.frc1225.DeepSpace36.subsystems;

import org.usfirst.frc1225.DeepSpace36.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import org.usfirst.frc1225.DeepSpace36.RobotMap;


public class Ejector extends Subsystem {
    private DoubleSolenoid ejector;

    public Ejector() {
        ejector = new DoubleSolenoid(RobotMap.PCMCANId2, RobotMap.EjectChannel, RobotMap.RetractChannel);
        addChild("Ejector",ejector);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new RetractEjector());
    }

    @Override
    public void periodic() {
    }

    public void eject() {
        ejector.set(DoubleSolenoid.Value.kForward);
    }

    public void stop() {
        ejector.set(DoubleSolenoid.Value.kReverse);
    }
    
}
