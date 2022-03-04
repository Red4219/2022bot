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
    CANSparkMax indxerMotor = RobotMap.indexerMotor;
    CANEncoder indexerEncoder = RobotMap.indexerEncoder;

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
        double RPM = Math.abs(indexerEncoder.getVelocity());
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
        indexerEncoder.setPosition(0.0);
    }
    public double getDistance() {
        return indexerEncoder.getPosition();
    }
    /*
     * Rotate Loading Motor upwards
     */
    public void rotateIndexerUp() {
        if (isFailing == false) {
            indxerMotor.set(Config.indexerSpeed);
            // Safety
        }
        safetyCheck();
    }

    /*
     * Rotate downwards
     */
    public void rotateIndexerDown() {
        if (isFailing == false) {
            indxerMotor.set(-Config.indexerSpeed);
            // Safety
        }
        safetyCheck();
    }

    /*
     * Rotate Indexer from raw input
     */
    public void rotate(double factor,boolean isAuto) {
        if (isFailing == false) {
            indxerMotor.set(factor * Config.indexerSpeed);
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
        indxerMotor.stopMotor();
        if (isAuto == false) {
            isFailing = false;
            failCount = 0;
        }
    }
}

//heduwuiodwnhqjhnsdjaio;uobdhnqudnsauicdnaefnsaeuoqopd