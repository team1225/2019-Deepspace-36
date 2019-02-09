package org.usfirst.frc1225.DeepSpace36.subsystems;

import org.usfirst.frc1225.DeepSpace36.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import org.usfirst.frc1225.DeepSpace36.RobotMap;


public class Wrist extends Subsystem {
    private DoubleSolenoid wrist;

    public Wrist() {
        wrist = new DoubleSolenoid(
            RobotMap.PCMCANId,
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
