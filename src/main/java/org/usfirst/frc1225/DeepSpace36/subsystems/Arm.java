package org.usfirst.frc1225.DeepSpace36.subsystems;

import org.usfirst.frc1225.DeepSpace36.RobotMap;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.CANSparkMax.IdleMode;

public class Arm extends PIDSubsystem {
    private CANSparkMax m_motor;
    private CANEncoder m_encoder;

    public Arm() {
        super("Arm", 
            RobotMap.armP,
            RobotMap.armI,
            RobotMap.armD,
            RobotMap.armF
        );
        setAbsoluteTolerance(RobotMap.armTolerance);
        getPIDController().setContinuous(false);
        getPIDController().setOutputRange(RobotMap.armMinOutput, RobotMap.armMaxOutput);
        getPIDController().setName("Arm", "Arm Controller");
        LiveWindow.add(getPIDController());

        m_motor = new CANSparkMax(RobotMap.ArmCANId, MotorType.kBrushless);
        m_encoder = m_motor.getEncoder();
        m_encoder.setPosition(0);
        m_motor.setIdleMode(IdleMode.kBrake);
        m_motor.setInverted(true);
        
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
        m_motor.set(0.25);
    }

    public void lower() {
        m_motor.set(-0.15);
    }

    public void stop() {
        m_motor.set(0);
    }
}

