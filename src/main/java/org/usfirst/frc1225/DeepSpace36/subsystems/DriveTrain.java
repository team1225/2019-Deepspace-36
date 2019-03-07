package org.usfirst.frc1225.DeepSpace36.subsystems;


import org.usfirst.frc1225.DeepSpace36.RobotMap;
import org.usfirst.frc1225.DeepSpace36.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class DriveTrain extends Subsystem {

    private ADIS16448_IMU gyro;
    private CANEncoder leftFrontEncoder;
    private CANEncoder leftRearEncoder;
    private CANEncoder rightFrontEncoder;
    private CANEncoder rightRearEncoder;
    private MecanumDrive drive;

    private CANSparkMax rightFront;
    private CANSparkMax leftFront;
    private CANSparkMax rightRear;
    private CANSparkMax leftRear;
    private CANSparkMax rightMid;
    private CANSparkMax leftMid;

    public DriveTrain() {
        gyro = new ADIS16448_IMU();
        addChild("Gyro",gyro);
        gyro.reset();
        rightFront = new CANSparkMax(RobotMap.rightFrontMotorCANId, MotorType.kBrushless);
        leftFront = new CANSparkMax(RobotMap.leftFrontMotorCANId, MotorType.kBrushless);
        rightRear = new CANSparkMax(RobotMap.rightRearMotorCANId, MotorType.kBrushless);
        leftRear = new CANSparkMax(RobotMap.leftRearMotorCANId, MotorType.kBrushless);
        rightMid = new CANSparkMax(RobotMap.rightMidMotorCANId, MotorType.kBrushless);
        leftMid = new CANSparkMax(RobotMap.leftMidMotorCANId, MotorType.kBrushless);

        rightFront.restoreFactoryDefaults();
        leftFront.restoreFactoryDefaults();
        leftRear.restoreFactoryDefaults();
        rightRear.restoreFactoryDefaults();
        rightMid.restoreFactoryDefaults();
        leftMid.restoreFactoryDefaults();

        rightFront.setIdleMode(IdleMode.kBrake);
        leftFront.setIdleMode(IdleMode.kBrake);
        leftMid.setIdleMode(IdleMode.kBrake);
        rightMid.setIdleMode(IdleMode.kBrake);
        leftRear.setIdleMode(IdleMode.kBrake);
        rightRear.setIdleMode(IdleMode.kBrake);

        rightFrontEncoder = rightFront.getEncoder();
        rightRearEncoder = rightRear.getEncoder();
        leftRearEncoder = leftRear.getEncoder();
        leftFrontEncoder = leftFront.getEncoder();

        
        leftRear.setOpenLoopRampRate(RobotMap.rampRate);
        leftFront.setOpenLoopRampRate(RobotMap.rampRate);
        rightFront.setOpenLoopRampRate(RobotMap.rampRate);
        rightRear.setOpenLoopRampRate(RobotMap.rampRate);
        
        rightMid.follow(rightRear);
        leftMid.follow(leftRear);
        
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
        SmartDashboard.putNumber("Gyro X", gyro.getAngleX());
        SmartDashboard.putNumber("Gyro Y", gyro.getAngleY());
        SmartDashboard.putNumber("Gyro Z", gyro.getAngleZ());
    }

    public void TeleopDrive(Joystick joystick) {
        drive.driveCartesian(joystick.getX(), -joystick.getY(), joystick.getZ()); //, gyro.getAngleX());
    }

    public void Test() {
        leftFront.set(0.05);
        leftRear.set(0.05);
        rightFront.set(0.05);
        rightRear.set(0.05);
    }

    public void Stop() {
        drive.driveCartesian(0, 0, 0);
    }
}

