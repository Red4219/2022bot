package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Config;
import frc.robot.OI;
import frc.robot.RobotMap;

// Indexer mans preparing the ball to shoot
//sounds like insexer

/*
Author:

Isaac Leal
*/
public class Indexer extends SubsystemBase 
{

    /* Call revolverMotor defined in RobotMap */
    CANSparkMax revolverMotor = RobotMap.revolverMotor;
    CANEncoder revolverEncoder = RobotMap.revolverEncoder;

    //Safety stuff
    int failLimit = 15;
    int failCount = 0;
    boolean isFailing = false;
    /*
     * Make this class public
     */
    public Indexer() {}



    // Safety function
    private void safetyCheck() {
        double RPM = Math.abs(revolverEncoder.getVelocity());
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
        revolverEncoder.setPosition(0.0);
    }
    public double getDistance() {
        return revolverEncoder.getPosition();
    }
    /*
     * Rotate Loading Motor upwards
     */
    public void rotateIndexerUp() {
        if (isFailing == false) {
            revolverMotor.set(Config.revolverSpeed);
            // Safety
        }
        safetyCheck();
    }

    /*
     * Rotate downwards
     */
    public void rotateIndexerDown() {
        if (isFailing == false) {
            revolverMotor.set(-Config.revolverSpeed);
            // Safety
        }
        safetyCheck();
    }

    /*
     * Rotate Indexer from raw input
     */
    public void rotate(double factor,boolean isAuto) {
        if (isFailing == false) {
            revolverMotor.set(factor * Config.revolverSpeed);
        }
        if (!isAuto) {
            safetyCheck();
        }
    }
    /*
     * Stop Indexer motor
     */
    public void stop(boolean isAuto) {
        OI.operator.setRumble(RumbleType.kLeftRumble, 0.0);
        OI.operator.setRumble(RumbleType.kRightRumble, 0.0);
        revolverMotor.stopMotor();
        if (isAuto == false) {
            isFailing = false;
            failCount = 0;
        }
    }
}

//heduwuiodwnhqjhnsdjaio;uobdhnqudnsauicdnaefnsaeuoqopd