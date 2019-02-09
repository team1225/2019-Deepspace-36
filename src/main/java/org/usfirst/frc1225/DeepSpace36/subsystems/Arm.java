package org.usfirst.frc1225.DeepSpace36.subsystems;

import org.usfirst.frc1225.DeepSpace36.RobotMap;
import org.usfirst.frc1225.DeepSpace36.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends Subsystem {
    private Encoder quadratureEncoder1;

    private CANSparkMax m_motor;
    private CANEncoder m_encoder;

    public Arm() {
        quadratureEncoder1 = new Encoder(8, 9, false, EncodingType.k4X);
        addChild("Quadrature Encoder 1",quadratureEncoder1);
        quadratureEncoder1.setDistancePerPulse(1.0);
        quadratureEncoder1.setPIDSourceType(PIDSourceType.kRate);
        m_motor = new CANSparkMax(RobotMap.ArmCANId, MotorType.kBrushless);
        m_encoder = m_motor.getEncoder();
    }

    @Override
    public void initDefaultCommand() {
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Encoder Position", m_encoder.getPosition());
    }

    public void raise() {
        m_motor.set(1);
    }

    public void lower() {
        m_motor.set(-1);
    }

    public void stop() {
        m_motor.set(0);
    }

    public double encoderValue() {
        return this.m_encoder.getPosition();
    }
}

