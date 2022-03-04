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
public class Climber extends SubsystemBase 
{

    /* Call revolverMotor defined in RobotMap */
    //CANSparkMax climberMotor = RobotMap.climberMotor;
    SpeedControllerGroup climberGroup = RobotMap.climberGroup;
    CANEncoder climberEncoder = RobotMap.climberEncoder;

    //Safety stuff
    int failLimit = 15;
    int failCount = 0;
    boolean isFailing = false;
    /*
     * Make this class public
     */
    public Climber() {}

    public void execute() {
        System.out.println("asdf");
    }

    



    // Safety function
    private void safetyCheck() {
        double RPM = Math.abs(climberEncoder.getVelocity());
        System.out.println("REV RPM: " + RPM);
        if (RPM < 350) {
            failCount ++;
        }
        if (failCount >= failLimit) {
            isFailing = true;
            //stop(true);
            OI.operator.setRumble(RumbleType.kLeftRumble, 0.5);
            OI.operator.setRumble(RumbleType.kRightRumble, 0.5);
        }
    }

    // take from revolver ^


    // Encoder stuff
    public void resetEncoder() {
        climberEncoder.setPosition(0.0);
    }
    public double getDistance() {
        return climberEncoder.getPosition();
    }
    /*
     * Rotate Loading Motor upwards
     */
    public void rotateClimberUp() {
        //if (isFailing == false) {
            //climberMotor.set(Config.climberSpeed);
            climberGroup.set(Config.climberSpeed);
            // Safety
        //}
        //safetyCheck();
    }

    /*
     * Rotate downwards
     */
    public void rotateClimberDown() {
        //if (isFailing == false) {
            //climberGroup.set(-Config.climberSpeed);
            climberGroup.set(-Config.climberSpeed);
            // Safety
        //}
        safetyCheck();
    }

    /*
     * Rotate Indexer from raw input
     */
    public void rotate(double factor,boolean isAuto) {
        //if (isFailing == false) {
            climberGroup.set(factor * Config.climberSpeed);
        //}
        //if (!isAuto) {
            //safetyCheck();
        //}
    }
    /*
     * Stop Indexer motor
     */
    public void stop(boolean isAuto) {
        OI.operator.setRumble(RumbleType.kLeftRumble, 0.0);
        OI.operator.setRumble(RumbleType.kRightRumble, 0.0);
        climberGroup.stopMotor();
        if (isAuto == false) {
            isFailing = false;
            failCount = 0;
        }
    }
}

//heduwuiodwnhqjhnsdjaio;uobdhnqudnsauicdnaefnsaeuoqopd