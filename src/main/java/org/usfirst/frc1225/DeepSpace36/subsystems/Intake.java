package org.usfirst.frc1225.DeepSpace36.subsystems;

import org.usfirst.frc1225.DeepSpace36.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class Intake extends Subsystem {
    private DoubleSolenoid wrist;
    private DoubleSolenoid ejector;
    private WPI_VictorSPX rollers;

    public Intake() {
        wrist = new DoubleSolenoid(0, 0, 1);
        addChild("Wrist",wrist);
        
        ejector = new DoubleSolenoid(1, 2, 3);
        addChild("Ejector",ejector);
        
        rollers = new WPI_VictorSPX(6);
    }

    @Override
    public void initDefaultCommand() {
    }

    @Override
    public void periodic() {
    }
}
