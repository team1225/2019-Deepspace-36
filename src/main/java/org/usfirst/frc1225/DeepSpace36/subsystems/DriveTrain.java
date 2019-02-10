package org.usfirst.frc1225.DeepSpace36.subsystems;


import org.usfirst.frc1225.DeepSpace36.RobotMap;
import org.usfirst.frc1225.DeepSpace36.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class DriveTrain extends Subsystem {

    private AnalogGyro analogGyro1;
    private Encoder quadratureEncoder1;
    private Encoder quadratureEncoder2;
    private Encoder quadratureEncoder3;
    private Encoder quadratureEncoder4;
    private MecanumDrive drive;

    private CANSparkMax rightFront;
    private CANSparkMax leftFront;
    private CANSparkMax rightRear;
    private CANSparkMax leftRear;

    public DriveTrain() {
        analogGyro1 = new AnalogGyro(0);
        addChild("AnalogGyro 1",analogGyro1);
        analogGyro1.setSensitivity(0.007);
        
        quadratureEncoder1 = new Encoder(0, 1, false, EncodingType.k4X);
        addChild("Quadrature Encoder 1",quadratureEncoder1);
        quadratureEncoder1.setDistancePerPulse(1.0);
        quadratureEncoder1.setPIDSourceType(PIDSourceType.kRate);
        
        quadratureEncoder2 = new Encoder(2, 3, false, EncodingType.k4X);
        addChild("Quadrature Encoder 2",quadratureEncoder2);
        quadratureEncoder2.setDistancePerPulse(1.0);
        quadratureEncoder2.setPIDSourceType(PIDSourceType.kRate);
        
        quadratureEncoder3 = new Encoder(4, 5, false, EncodingType.k4X);
        addChild("Quadrature Encoder 3",quadratureEncoder3);
        quadratureEncoder3.setDistancePerPulse(1.0);
        quadratureEncoder3.setPIDSourceType(PIDSourceType.kRate);
        
        quadratureEncoder4 = new Encoder(6, 7, false, EncodingType.k4X);
        addChild("Quadrature Encoder 4",quadratureEncoder4);
        quadratureEncoder4.setDistancePerPulse(1.0);
        quadratureEncoder4.setPIDSourceType(PIDSourceType.kRate);
        
        rightFront = new CANSparkMax(RobotMap.rightFrontMotorCANId, MotorType.kBrushless);
        leftFront = new CANSparkMax(RobotMap.leftFrontMotorCANId, MotorType.kBrushless);
        rightRear = new CANSparkMax(RobotMap.rightRearMotorCANId, MotorType.kBrushless);
        leftRear = new CANSparkMax(RobotMap.leftRearMotorCANId, MotorType.kBrushless);
        
        drive = new MecanumDrive(leftFront, leftRear, rightFront, rightRear);
        addChild("Drive",drive);
        drive.setSafetyEnabled(true);
        drive.setExpiration(0.1);
        drive.setMaxOutput(1.0);
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }

    @Override
    public void periodic() {
    }

    public void TeleopDrive(Joystick joystick) {
        drive.driveCartesian(joystick.getX(), joystick.getY(), joystick.getZ());
    }

    public void Stop() {
        drive.driveCartesian(0, 0, 0);
    }
}

