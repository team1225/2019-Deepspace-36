
package org.usfirst.frc1225.DeepSpace36;

public final class RobotMap {
/**************************************************
 *                   CAN Ids
 **************************************************/
// Drive train motors
    public static final int rightRearMotorCANId = 1;
    public static final int leftMidMotorCANId = 2;  
    public static final int leftFrontMotorCANId = 3;
    public static final int IntakeCANId = 4;
    public static final int rightMidMotorCANId = 5;
    public static final int leftRearMotorCANId = 6;
    public static final int ArmCANId = 7;
    public static final int rightFrontMotorCANId = 8;
    public static final int PCMCANId1 = 9;
    public static final int PCMCANId2 = 10;
    
/**************************************************
 *                  Solenoids
 *************************************************/
    // PCM 1
    public static final int upleftFrontPistonId = 4; // black 
    public static final int upleftRearPistonId = 2; //green
    public static final int uprightFrontPistonId = 0; //purple
    public static final int uprightRearPistonId = 6; // blue
    public static final int downleftFrontPistonId = 5; //brown
    public static final int downleftRearPistonId = 3; // yellow
    public static final int downrightFrontPistonId = 1; //orange
    public static final int downrightRearPistonId = 7; // red
    // PCM 2
    public static final int RaiseWristChannel = 0;
    public static final int LowerWristChannel = 1;
    public static final int EjectChannel = 2;
    public static final int RetractChannel = 3;
    
 /************************************************
  *                    Settings
  ***********************************************/   
    
    // Drive train
    public static final double rampRate = 0.5;

    // Arm
    public static final double armMaxOutput = 0.5;
    public static final double armMinOutput = -0.5;
    public static final double armP = 0.035;
    public static final double armI = 0.0006;
    public static final double armD = 0.0;
    public static final double armF = 0.0;
    public static final double armTolerance = 0.0027; // equal to about one degree or one inch at 4 feet
    public static final double armCargoLength = 53.0;
    public static final double armHatchLength = 49.0;
    public static final double armCargoCenter = 7.5;
    public static final double armHatchCenter = 9.0;

    //  heights
    public static final double HatchPanel1 = 19.0;
    public static final double HatchPanel2 = 47.0;
    public static final double HatchPanel3 = 75.0;
    public static final double Cargo1 = 27.5;
    public static final double Cargo2 = 55.5;
    public static final double Cargo3 = 83.5;

    // Joystick buttons
    public static final int DRIVER_CONTROLLER = 0;
	public static final int OPERATOR_CONTROLLER = 1;

	public static final int BUTTON_X = 1;
	public static final int BUTTON_A = 2;
	public static final int BUTTON_B = 3;
	public static final int BUTTON_Y = 4;
	public static final int LEFT_BUMPER = 5;
	public static final int RIGHT_BUMPER = 6;
	public static final int LEFT_TRIGGER = 7;
	public static final int RIGHT_TRIGGER = 8;
	public static final int BACK_BUTTON = 9;
	public static final int START_BUTTON = 10;
	public static final int LEFT_STICK_BUTTON = 11;
	public static final int RIGHT_STICK_BUTTON = 12;
	
	public static final int D_LEFT_STICK_X = 0;
    public static final int D_LEFT_STICK_Y = 1;
	public static final int D_RIGHT_STICK_X = 4;
    public static final int D_RIGHT_STICK_Y = 5;

    public static final int X_LEFT_STICK_X = 0;
    public static final int X_LEFT_STICK_Y = 1;
	public static final int X_RIGHT_STICK_X = 4;
	public static final int X_RIGHT_STICK_Y = 5;
    public static final int X_LEFT_TRIGGER_STICK = 2;
    public static final int X_RIGHT_TRIGGER_STICK = 3;
}