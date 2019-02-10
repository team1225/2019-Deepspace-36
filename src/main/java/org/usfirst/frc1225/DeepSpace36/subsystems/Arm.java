package org.usfirst.frc1225.DeepSpace36.subsystems;

import org.usfirst.frc1225.DeepSpace36.RobotMap;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends PIDSubsystem {
    private CANSparkMax m_motor;
    private CANEncoder m_encoder;

    public Arm() {
        super("Arm", 1.0, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        getPIDController().setName("Arm", "Arm Controller");
        LiveWindow.add(getPIDController());

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

    protected double returnPIDInput() {
    	return m_encoder.getPosition(); // returns the sensor value that is providing the feedback for the system
    }

    protected void usePIDOutput(double output) {
    	m_motor.pidWrite(output); // this is where the computed output value from the PIDController is applied to the motor
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
}

