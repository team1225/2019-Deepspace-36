package org.usfirst.frc1225.DeepSpace36.subsystems;


import org.usfirst.frc1225.DeepSpace36.RobotMap;
import org.usfirst.frc1225.DeepSpace36.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
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
        
        rightFront = new CANSparkMax(RobotMap.rightFrontMotorCANId, MotorType.kBrushless);
        leftFront = new CANSparkMax(RobotMap.leftFrontMotorCANId, MotorType.kBrushless);
        rightRear = new CANSparkMax(RobotMap.rightRearMotorCANId, MotorType.kBrushless);
        leftRear = new CANSparkMax(RobotMap.leftRearMotorCANId, MotorType.kBrushless);
        rightMid = new CANSparkMax(RobotMap.rightRearMotorCANId, MotorType.kBrushless);
        leftMid = new CANSparkMax(RobotMap.leftRearMotorCANId, MotorType.kBrushless);

        rightFront.setOpenLoopRampRate(RobotMap.rampRate);
        rightFrontEncoder = rightFront.getEncoder();
    
        leftRear.setOpenLoopRampRate(RobotMap.rampRate);
        leftRearEncoder = leftRear.getEncoder();
    
        leftFront.setOpenLoopRampRate(RobotMap.rampRate);
        leftFrontEncoder = leftFront.getEncoder();
    
        rightRear.setOpenLoopRampRate(RobotMap.rampRate);
        rightRearEncoder = rightRear.getEncoder();
    
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
    }

    public void TeleopDrive(Joystick joystick) {
        drive.driveCartesian(joystick.getX(), joystick.getY(), joystick.getZ(), gyro.getAngleZ());
    }

    public void Stop() {
        drive.driveCartesian(0, 0, 0);
    }
}

