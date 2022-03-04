package frc.robot;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.jni.CANSparkMaxJNI;

//import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/*
 * All universal variables and robot components are found here
 * 
 * Author: Francisco Fabregat, Isaac Leal
 */
public class RobotMap {
  /* Initialize drive Spark variables */
  public static CANSparkMax FrontLeftMotor;
  public static CANSparkMax MiddleLeftMotor;
  public static CANSparkMax BackLeftMotor;
  public static CANSparkMax FrontRightMotor;
  public static CANSparkMax MiddleRightMotor;
  public static CANSparkMax BackRightMotor;

  /* Initialize SpeedControllerGroups for DifferentialDrive */
  public static SpeedControllerGroup leftGroup;
  public static SpeedControllerGroup rightGroup;

  public static SpeedControllerGroup shooterGroup;
  public static SpeedControllerGroup intakeGroup;
  public static SpeedControllerGroup intakeArmGroup;
  public static SpeedControllerGroup climberGroup;

  /* Initialize DifferentialDrive */
  public static DifferentialDrive robotDrive;

  /* Initialize encoders */
  public static CANEncoder leftDriveEncoder;
  public static CANEncoder rightDriveEncoder;
  //public static CANEncoder shooterAlignEncoder;
  public static CANEncoder indexerEncoder;
  public static CANEncoder climberEncoder;
  //public static CANEncoder intakeLiftEncoder;

  /* Initialize motors */
  public static CANSparkMax indexerMotor;
  public static CANSparkMax shooterMotor;
  //public static CANSparkMax shooterAlignMotor;
  public static CANSparkMax intakeMotor;
  public static CANSparkMax intakeLiftMotor1;
  public static CANSparkMax intakeLiftMotor2;

  public static CANSparkMax indexerFrontMotor;
  public static CANSparkMax indexerMiddleMotor;
  public static CANSparkMax indexerBackMotor;

  /* Climber Motors */
  public static CANSparkMax climberMotor1;
  public static CANSparkMax climberMotor2;


  /* Initialize limit switches */
  //public static DigitalInput intakeUpSwitch;
  //public static DigitalInput intakeDownSwitch;

  /*
   * Initialize all components
   */
  public static void init() {

    /* Define drive Sparks with CAN id */
    //TalonSRX Test = new TalonSRX(1);

    FrontLeftMotor = new CANSparkMax(5, MotorType.kBrushless);
    MiddleLeftMotor = new CANSparkMax(6, MotorType.kBrushless);
    BackLeftMotor = new CANSparkMax(8, MotorType.kBrushless);
    FrontRightMotor = new CANSparkMax(2 , MotorType.kBrushless);
    MiddleRightMotor = new CANSparkMax(3 , MotorType.kBrushless);
    BackRightMotor = new CANSparkMax(7 , MotorType.kBrushless);

    /* Set ramp rate for drive motors to decrease current drawn and prevent browning out */
    FrontLeftMotor.setOpenLoopRampRate(0.5);
    MiddleLeftMotor.setOpenLoopRampRate(0.5);
    BackLeftMotor.setOpenLoopRampRate(0.5);
    FrontRightMotor.setOpenLoopRampRate(0.5);
    MiddleRightMotor.setOpenLoopRampRate(0.5);
    BackRightMotor.setOpenLoopRampRate(0.5);
    
    /* Define SpeedControllerGroups for DifferentialDrive */
    leftGroup = new SpeedControllerGroup(FrontLeftMotor, MiddleLeftMotor, BackLeftMotor);
    rightGroup = new SpeedControllerGroup(FrontRightMotor, MiddleRightMotor, BackRightMotor);
    
    /* Define robotDrive as a DifferentialDrive for drivetrain */
    robotDrive = new DifferentialDrive(leftGroup, rightGroup);

    /* Define SPARK MAX with CAN id */
    //revolverMotor = new CANSparkMax(15, MotorType.kBrushless);
    shooterMotor = new CANSparkMax(15, MotorType.kBrushless);
    //shooterAlignMotor = new CANSparkMax(9, MotorType.kBrushless);
    intakeMotor = new CANSparkMax(11, MotorType.kBrushless);
    intakeMotor.setInverted(true);


    intakeLiftMotor1 = new CANSparkMax(10, MotorType.kBrushless);
    intakeLiftMotor2 = new CANSparkMax(20, MotorType.kBrushless);
    intakeLiftMotor2.setInverted(true);
    indexerFrontMotor = new CANSparkMax(16, MotorType.kBrushless);
    indexerFrontMotor.setInverted(true);
    indexerMiddleMotor = new CANSparkMax(12, MotorType.kBrushless);
    indexerBackMotor = new CANSparkMax(1, MotorType.kBrushless);

    indexerBackMotor.setInverted(true);

    climberMotor1 = new CANSparkMax(30, MotorType.kBrushless);
    climberMotor2 = new CANSparkMax(4, MotorType.kBrushless);
    climberMotor2.setInverted(true);

    climberGroup = new SpeedControllerGroup(climberMotor1, climberMotor2);

    shooterGroup = new SpeedControllerGroup(shooterMotor, indexerBackMotor, indexerMiddleMotor);
    intakeGroup = new SpeedControllerGroup(indexerFrontMotor, intakeMotor, indexerMiddleMotor);
    intakeArmGroup = new SpeedControllerGroup(intakeLiftMotor1, intakeLiftMotor2);

    /* Define encoders */
    leftDriveEncoder = MiddleLeftMotor.getEncoder();
    rightDriveEncoder = MiddleRightMotor.getEncoder();
    //shooterAlignEncoder = shooterAlignMotor.getEncoder();
    //revolverEncoder = revolverMotor.getEncoder();
    //intakeLiftEncoder = intakeLiftMotor.getEncoder();
    /* Define limit switches */
    //intakeUpSwitch = new DigitalInput(1);
    //intakeDownSwitch = new DigitalInput(2);

    
  }
} 
//Malakai Quotes -
// im robbing people like its the 80's
// im proud to share my name with a lesbian
// i used to steal those chocolate bars from kids, and they couldnt tell their parents cause they would be snitches
//does anybody know drill bits
//your like a fucking grampa alejandro, your always telling stories
//My Favorite Ukraine Gang  Club
//move the hell out of the way
//martin luther king died in mepmphis city memphis city
//im gonna go down the waterslidecslicker than a hispanic kid
//no one is allowed to fuck my mom anymore

//Isaac Quotes
//he got that yangly ass hair
//its not racist if your racist against british people
//juan cena
