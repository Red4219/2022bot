// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import javax.swing.GroupLayout.Alignment;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.autonomous.actions.DriveTillDistance;
import frc.robot.autonomous.actions.Shoot;
import frc.robot.autonomous.actions.StraightDrive;
import frc.robot.autonomous.paths.Autonomous2;
import frc.robot.autonomous.paths.Autonomous2right;
import frc.robot.autonomous.paths.Autonomous3right;
import frc.robot.autonomous.paths.ForwardAndRotate;
import frc.robot.autonomous.paths.ShootAndMove;
import frc.robot.autonomous.paths.Straight;
//import frc.robot.autonomous.paths.StraightAndShoot;
import frc.robot.commands.TankDrive;
//import frc.robot.commands.MoveShooterAdjust;
//import frc.robot.commands.MoveRevolver;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.OperatorIntake;
import frc.robot.subsystems.OperatorLiftIntake;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;
//import frc.robot.subsystems.ShooterAlign;
import frc.robot.subsystems.Turret;
//import frc.robot.Aligner;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Climber;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
// camera libraries ^
/*
 * This is the "main" class
 * 
 * Authors: Francisco Fabregat, Isaac Leal
 * Contributor: Harrison Lewis
 * 
 * 
 * alejandro was here suc my nutz ;)
 * 
 * Sussy Amongus Baka Juan Cena John Xina
 * 
 * Deezer
 * 
 * The Legend of the 7/16
 */
public class Robot extends TimedRobot {

  //public static final Subsystem Indexer = null;
  //public static final Indexer indexer = null;

/* Initialize autonomousCommand to store chosen command */
  Command autonomousCommand;

  /* Initialize OI and Subsystems */
  public static OI oi;
  public static Drive driveTrain;
  public static Intake intake;
  public static OperatorIntake operatorIntake;
  public static OperatorLiftIntake operatorLiftIntake;
  //public static Revolver revolver;
  //public static Indexer indexer;
  public static Shooter shooter;
  public static StraightDrive straightDrive;
  //public static ShooterAlign shooterAlign;
  public static Turret turret;
  public static Indexer indexer;
  public static Climber climber;
  public static FlyWheel flyWheel;

  //
  private double lastPeriodTime;

  /* Define default autonomous mode id */
  public int mode = 0;

  /* Initialize and define autonomous modes list */
  String[] autoList = { "Move Straight", "DO NOT SELECT (Yet)", "el rotate" };

  /* Initialize Dashboard */
  public static Dashboard dashboard = new Dashboard();

  /* Initialize Limelight */
  public static Limelight limelight = new Limelight();

  // Init aligner
  //public static Aligner aligner = new Aligner();

  public ShootAndMove shootAndMove1;
  public Autonomous2 autonomous2;
  public Autonomous3right autonomous3right;
  public Autonomous2right autonomous2right;

  SendableChooser<Command> m_chooser;

  /*
   * This function is executed only once when the robot boots up
   */
  @Override
  public void robotInit() {
    CameraServer.startAutomaticCapture(0);
    CameraServer.startAutomaticCapture(1);

    

    CameraServer.getServer();
    /* Initialize RobotMap */
    RobotMap.init();
    /* Define OI and Subsystems */
    driveTrain = new Drive();
    intake = new Intake();
    //revolver = new Revolver();
    indexer = new Indexer();
    shooter = new Shooter();
    straightDrive = new StraightDrive(this);
    //shooterAlign = new ShooterAlign();
    turret = new Turret();
    climber = new Climber();
    operatorIntake = new OperatorIntake();
    operatorLiftIntake = new OperatorLiftIntake();

    flyWheel = new FlyWheel();

    oi = new OI();
    lastPeriodTime = Timer.getFPGATimestamp();
    /* Set Default Commands for Subsystems */
    driveTrain.setDefaultCommand(new TankDrive());
    //shooterAlign.setDefaultCommand(new MoveShooterAdjust());
    //revolver.setDefaultCommand(new MoveRevolver());

    /* Push autonomous list to Dashboard */
    //dashboard.setAutonomousList(autoList);


    /* Select default autonomous mode */
    //dashboard.setAutonomous(0);

    /* Reset shooter align encoder */
    //shooterAlign.reset();

    // Make sure the limelight light is off by default
    //limelight.setDrive();

    shootAndMove1 = new ShootAndMove();
    autonomous2 = new Autonomous2();
    autonomous3right = new Autonomous3right();
    autonomous2right = new Autonomous2right();


    m_chooser = new SendableChooser<Command>();

    m_chooser.setDefaultOption("default", shootAndMove1);
    m_chooser.addOption("2 right", autonomous2);
    m_chooser.addOption("3 right", autonomous3right);
    m_chooser.addOption("2 left", autonomous2right);

    SmartDashboard.putData("autos",m_chooser);

  }

  /*
   * This function is executed periodically in any mode (disabled, teleop,
   * autonomous, etc.)
   */
  @Override
  public void robotPeriodic() {

    /* Run Command Scheduler */
    CommandScheduler.getInstance().run();

    // trigger safety functions
    double currentTime = Timer.getFPGATimestamp();
    shooter.checkSafety(currentTime - lastPeriodTime);
    lastPeriodTime = currentTime;

    // Send shooter RPM to dashboard //
    dashboard.setShooterRPM(shooter.RPM);

    /* Send battery voltage to Dashboard */
    dashboard.setBattery(RobotController.getBatteryVoltage());

    /* Send remaining time to Dashboard */
    dashboard.setTime(DriverStation.getMatchTime());
    
    //Hood encoder
    //dashboard.setShootAdjustEncoder(shooterAlign.getPosition());
    //System.out.println("POINTER: " + shooterAlign.getPosition());
    //System.out.println("DISTANC: " + limelight.getDistance());


    /* Send distance to dashboard ONLY if tape is detected by the Limelight */
    if (limelight.hasTarget()) {
      dashboard.setDistance(limelight.getDistance());
    } else {
      dashboard.setDistance(0.0);
    }

    // TODO remove test code
    //System.out.println("Right middle motor inverted: " + RobotMap.MiddleRightMotor.getInverted());
    //System.out.println("Left middle motor inverted: " + RobotMap.MiddleLeftMotor.getInverted());

    // Safety for motor toggle
    //if (shooter)
  }

  /*
   * This function is executed only once when the robot changes into disabled mode
   */
  @Override
  public void disabledInit() {}

  /*
   * This function is executed periodically when in disabled mode
   */
  @Override
  public void disabledPeriodic() {}

  /*
   * This function is executed only once when the robot changes into autonomous
   * mode
   */
  @Override
  public void autonomousInit() {
    /* Set mode variable to the chosen autonomous mode id */
    //mode = dashboard.getSelectedAutonomous();

    m_chooser.getSelected().schedule();

    /* Set autonomousCommand to the right command according to the mode variable */
    /*if (mode == 0) {
      //autonomousCommand = (Command) new Straight();
      //autonomousCommand = (Command) new Shoot();
      //RobotMap.leftGroup.set(.5);
      //RobotMap.rightGroup.set(.5);
      //autonomousCommand = (Command) new StraightDrive(this);
      //System.out.println("called");

      //autonomousCommand = (Command) new Shoot();

      //autonomousCommand.andThen(new DriveTillDistance(5));

      autonomousCommand = (Command) new ShootAndMove();

    } else if (mode == 1) {
      autonomousCommand = (Command) new Shoot();
     // autonomousCommand = (Command) new StraightAndShoot();
    } else if (mode == 2) {
      autonomousCommand = (Command) new ForwardAndRotate();
    } else {
      autonomousCommand = (Command) new Straight();
    }*/

    /* Start the autonomous command if it has not been started already */
    /*if (autonomousCommand != null) {
      autonomousCommand.schedule();
    }*/
  }

  /*
   * This function is executed periodically when in autonomous mode
   */
  @Override
  public void autonomousPeriodic() {
    //CommandScheduler.getInstance().run();
  }

  /*
   * This function is executed only once when the robot changes into teleop mode
   */
  @Override
  public void teleopInit() {
    /* Stop the autonomous if it is still running */
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  /*
   * This function is executed periodically when in teleop mode
   */
  @Override
  public void teleopPeriodic() {
    intake.periodicIntake();
    dashboard.setLeftMotorPower(RobotMap.MiddleLeftMotor.get());
    dashboard.setRightMotorPower(RobotMap.MiddleRightMotor.get());
    //dashboard.setIntakeMotorPower(RobotMap.intakeMotor.get());
    //dashboard.setIntakeLiftMotorPower(RobotMap.intakeLiftMotor.get());
    //dashboard.setShooterMotorPower(RobotMap.shooterMotor.get());
    //dashboard.setRevolverMotorPower(RobotMap.revolverMotor.get());
    //dashboard.setAdjusterMotorPower(RobotMap.shooterAlignMotor.get());

    turret.teleopPeriodic();
  
    //System.out.println("Bottom Switch: "+RobotMap.intakeDownSwitch.get());
  }

  /*
   * This function is executed only once when the robot changes into test mode
   */
  @Override
  public void testInit() {
    /* Cancels all running commands at the start of test mode */
    CommandScheduler.getInstance().cancelAll();
  }

  /*
   * This function is executed periodically when in test mode
   */
  @Override
  public void testPeriodic() {}
}
