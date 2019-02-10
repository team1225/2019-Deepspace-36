package org.usfirst.frc1225.DeepSpace36.subsystems;

import org.usfirst.frc1225.DeepSpace36.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

import javax.swing.plaf.TreeUI;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import org.usfirst.frc1225.DeepSpace36.RobotMap;


public class Ejector extends Subsystem {
    private Solenoid ejector;
    private CANSparkMax rollers;

    public Ejector() {
        ejector = new Solenoid(
            RobotMap.PCMCANId,
            3
            );
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

    public void eject() {
        ejector.set(true);
    }

    public void stop() {
        ejector.set(false);
    }
    
}
