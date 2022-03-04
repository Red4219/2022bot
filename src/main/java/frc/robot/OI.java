package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import frc.robot.commands.AutoAlign;
//import frc.robot.commands.AutoShoot;
import frc.robot.commands.LiftIntake;
import frc.robot.commands.ManualShoot;
import frc.robot.commands.MoveIntake;
//import frc.robot.commands.MoveRevolver;
//import frc.robot.commands.MoveShooterAdjust;
import frc.robot.commands.moveClimber;

/*
 * This class defines everything related to joysticks and controls
 * 
 * Author: Francisco Fabregat
 */
public class OI {

  /* Define joysticks and controllers */
  public static Joystick driver;
  public static Joystick operator;

  /* Define joystick buttons */
  public static JoystickButton raiseIntakeButton;
  public static JoystickButton lowerIntakeButton;
  public static JoystickButton intakeButton;
  public static JoystickButton reverseIntakeButton;
  //public static JoystickButton revolverCWButton;
  public static JoystickButton autoAlignButton;
  public static JoystickButton keepIntakeHighButton;
  public static JoystickButton shootButton;
  public static JoystickButton manualShootButton;
  public static JoystickButton shooterAdjustUpButton;
  public static JoystickButton shooterAdjustDownButton;
  //public static JoystickButton revolverCCWButton;
  public static JoystickButton rotateIndexerUp;
  public static JoystickButton rotateIndexerDown;
  
  public static JoystickButton rotateClimberUp;
  public static JoystickButton rotateClimberDown;

  
  /* Allows buttons and joysticks to be accessed from anywhere */
  public OI() {

    /* Assign joystick id to joystick */
    driver = new Joystick(1);
    operator = new Joystick(0);

    /* Assign button ids to buttons */


    //FRC sex game when


    raiseIntakeButton = new JoystickButton(driver, 4);
    lowerIntakeButton = new JoystickButton(driver, 1);
    intakeButton = new JoystickButton(driver, 6);
    reverseIntakeButton = new JoystickButton(driver, 5);
    //revolverButton = new JoystickButton(driver, 2);
    //autoAlignButton = new JoystickButton(driver, 3);
    //autoAlignButton = new JoystickButton(driver, 5);
    keepIntakeHighButton = new JoystickButton(driver, 8);
    //shootButton = new JoystickButton(driver, 7);
    //shooterAdjustUpButton = new JoystickButton(driver, 4);
    //4shooterAdjustDownButton = new JoystickButton(driver, 1); 

    //driver binds above ^
    
    //shootButton = new JoystickButton(operator, 5);
    //raiseIntakeButton = new JoystickButton(operator, 6);
    //lowerIntakeButton = new JoystickButton(operator, 5);
    //intakeButton = new JoystickButton(operator, 3);
    //revolverCWButton = new JoystickButton(operator, 2);
    //shooterAdjustUpButton = new JoystickButton(operator, 4);
    //shooterAdjustDownButton = new JoystickButton(operator, 1);
    //keepIntakeHighButton = new JoystickButton(operator, 8);
    manualShootButton = new JoystickButton(operator, 6);
    //revolverCCWButton = new JoystickButton(operator, 3);
    rotateIndexerUp = new JoystickButton(operator, 4);
    rotateIndexerDown = new JoystickButton(operator, 1);
    //indexerButton = new JoystickButton(operator, 4);
    rotateClimberUp = new JoystickButton(operator, 8);
    rotateClimberDown = new JoystickButton(operator, 7);


    //operator binds aboven ^

    /* Assign commands to buttons */
    
    // TEMPORARILY DISABLED COMMANDS FOR SAFETY WHILE SENSORS ARE INSTALLED

    lowerIntakeButton.whenPressed(new LiftIntake(false));
    raiseIntakeButton.whenPressed(new LiftIntake(true));
    //shooterAdjustUpButton.whenPressed(new MoveShooterAdjust(true));
    //shooterAdjustDownButton.whenPressed(new MoveShooterAdjust(false));
    //shootButton.whenPressed(new ManualShoot());
    //UN COMMENT THIS when limelight working > shootButton.whenPressed(new AutoShoot());
    manualShootButton.whenPressed(new ManualShoot());
    //UN COMMENT THIS when limelight working>autoAlignButton.whenPressed(new AutoAlign());
    //revolverCWButton.whenPressed(new MoveRevolver(true));
    //revolverCCWButton.whenPressed(new MoveRevolver(false));
    intakeButton.whenPressed(new MoveIntake(true));
    reverseIntakeButton.whenPressed(new MoveIntake(false));
    rotateClimberUp.whenPressed(new moveClimber());
  }
}

//John Xina vs the Wok vs Tobey Maoguire