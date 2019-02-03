package org.usfirst.frc1225.DeepSpace36.subsystems;

import org.usfirst.frc1225.DeepSpace36.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;

public class Arm extends Subsystem {
    private Encoder quadratureEncoder1;
    private WPI_TalonSRX talonSRX1;

    public Arm() {
        quadratureEncoder1 = new Encoder(8, 9, false, EncodingType.k4X);
        addChild("Quadrature Encoder 1",quadratureEncoder1);
        quadratureEncoder1.setDistancePerPulse(1.0);
        quadratureEncoder1.setPIDSourceType(PIDSourceType.kRate);
        
        talonSRX1 = new WPI_TalonSRX(11);
    }

    @Override
    public void initDefaultCommand() {
    }

    @Override
    public void periodic() {

    }
}

