package org.usfirst.frc1225.DeepSpace36.subsystems;


import org.usfirst.frc1225.DeepSpace36.RobotMap;
import org.usfirst.frc1225.DeepSpace36.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class DriveTrain extends Subsystem {

    private AnalogGyro analogGyro1;
    private CANEncoder leftFrontEncoder;
    private CANEncoder leftRearEncoder;
    private CANEncoder rightFrontEncoder;
    private CANEncoder rightRearEncoder;
    private MecanumDrive drive;

    private CANSparkMax rightFront;
    private CANSparkMax leftFront;
    private CANSparkMax rightRear;
    private CANSparkMax leftRear;

    public DriveTrain() {
        analogGyro1 = new AnalogGyro(0);
        addChild("AnalogGyro 1",analogGyro1);
        analogGyro1.setSensitivity(0.007);
        
        rightFront = new CANSparkMax(RobotMap.rightFrontMotorCANId, MotorType.kBrushless);
        leftFront = new CANSparkMax(RobotMap.leftFrontMotorCANId, MotorType.kBrushless);
        rightRear = new CANSparkMax(RobotMap.rightRearMotorCANId, MotorType.kBrushless);
        leftRear = new CANSparkMax(RobotMap.leftRearMotorCANId, MotorType.kBrushless);
        
        leftRear.setRampRate(RobotMap.rampRate);
        leftFront.setRampRate(RobotMap.rampRate);
        rightRear.setRampRate(RobotMap.rampRate);
        rightFront.setRampRate(RobotMap.rampRate);

        leftFrontEncoder = leftFront.getEncoder();
        leftRearEncoder = leftRear.getEncoder();
        rightRearEncoder = rightRear.getEncoder();
        rightFrontEncoder = rightFront.getEncoder();

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

