
package org.usfirst.frc1225.DeepSpace36;

public final class RobotMap {
    // Drive train motors
    public static final int leftFrontMotorCANId = 11;
    public static final int leftRearMotorCANId = 12;
    public static final int rightFrontMotorCANId = 13;
    public static final int rightRearMotorCANId = 14;
    public static final int rightMidMotorCANId = 10;
    public static final int leftMidMotorCANId = 9;  

    public static final double rampRate = 0;

    // Arm
    public static final int ArmCANId = 10;
    public static final double armMaxOutput = 1.0;
    public static final double armMinOutput = -1.0;
    public static final double armP = 0.035;
    public static final double armI = 0.0006;
    public static final double armD = 0.0;
    public static final double armF = 0.0;
    public static final double armTolerance = 0.0027; // equal to about one degree or one inch at 4 feet

    // Intake
    public static final int IntakeCANId = 9;
    public static final int IntakeJointCANId = 8;

    // 
    public static final int leftFrontPistonId = 0;
    public static final int leftRearPistonId = 1;
    public static final int rightFrontPistonId = 2;
    public static final int rightRearPistonId = 3;

    //  Pneumatics 
    public static final int PCMCANId = 0;
    public static final int RaiseWristChannel = 0;
    public static final int LowerWristChannel = 1;
    
    //  heights
    public static final double HatchPanel1 = 1.0;
    public static final double HatchPanel2 = 2.0;
    public static final double HatchPanel3 = 3.0;
    public static final double Cargo1 = 1.1;
    public static final double Cargo2 = 2.2;
    public static final double Cargo3 = 3.3;

    // Joystick buttons
    public static final int DRIVER_CONTROLLER = 0;
	public static final int OPERATOR_CONTROLLER = 1;

	public static final int BUTTON_A = 1;
	public static final int BUTTON_B = 2;
	public static final int BUTTON_X = 3;
	public static final int BUTTON_Y = 4;
	public static final int LEFT_BUMPER = 5;
	public static final int RIGHT_BUMPER = 6;
	public static final int BACK_BUTTON = 7;
	public static final int START_BUTTON = 8;
	public static final int LEFT_STICK_BUTTON = 9;
	public static final int RIGHT_STICK_BUTTON = 10;
	
	public static final int LEFT_STICK_X = 0;
	public static final int LEFT_STICK_Y = 1;
	public static final int RIGHT_STICK_Y = 5;
	public static final int RIGHT_STICK_X = 4;
	
	public static final int LEFT_TRIGGER = 2;
	public static final int RIGHT_TRIGGER = 3;
}