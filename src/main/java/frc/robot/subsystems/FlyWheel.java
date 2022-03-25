package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Config;
import frc.robot.OI;
import frc.robot.RobotMap;

//climber stuff

/*
Author:

Isaac Leal
*/
public class FlyWheel extends SubsystemBase 
{

    /* Call revolverMotor defined in RobotMap */
    //CANSparkMax climberMotor = RobotMap.climberMotor;
    CANSparkMax flyWheelMotor = RobotMap.shooterMotor;
    //CANEncoder climberEncoder = RobotMap.climberEncoder;

    //Safety stuff
    int failLimit = 15;
    int failCount = 0;
    boolean isFailing = false;
    /*
     * Make this class public
     */
    public FlyWheel() {}

    public void execute() {
        
    }

    public void runFlyWheel() {
       flyWheelMotor.set(Config.shooterSpeed);
    }

    /*
     * Stop Indexer motor
     */
    public void stop(boolean isAuto) {
        /*OI.operator.setRumble(RumbleType.kLeftRumble, 0.0);
        OI.operator.setRumble(RumbleType.kRightRumble, 0.0);
        climberGroup.stopMotor();
        if (isAuto == false) {
            isFailing = false;
            failCount = 0;
        }*/
        flyWheelMotor.stopMotor();
    }
}

//heduwuiodwnhqjhnsdjaio;uobdhnqudnsauicdnaefnsaeuoqopd