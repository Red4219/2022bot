package frc.robot.autonomous.actions;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Config;
import frc.robot.Robot;
import frc.robot.RobotMap;

/*
 * This command moves the robot straight a certain distance
 * 
 * Author: Francisco Fabregat
 */
public class StraightDrive extends CommandBase {

    /* Initialize variables */
    boolean forwardMovement;
    double driveDistance;
    double startDistanceL;
    double startDistanceR;
    boolean setIntake;
    int counter = 0;
    double startTime;
    Robot robot;

    /*
     * Declares public function that takes direction and distance in feet and inches
     */
    public StraightDrive(boolean forward, double userFeet, double userInches, boolean intake) {

        /* Require the necessary subsystems */
        addRequirements(Robot.driveTrain);

        /* Sets wether the movement is forward or not */
        forwardMovement = forward;

        /* Determine distance to move in feet */
        driveDistance = (userFeet + (userInches / 12));

        /* Determine whether to start the intake or not while moving */
        setIntake = intake;
    }

    public StraightDrive(Robot robot) {
        this.robot = robot;
    }

    /*
     * Function runs only once when the command starts
     */
    public void initialize() {

        /*
         * Reset encoder values
         */
        // Robot.driveTrain.resetDriveEncoders();

        // /* Determine the starting (current) distance for both sides */
        // startDistanceR = Robot.driveTrain.getRightDistance();
        // startDistanceL = Robot.driveTrain.getLeftDistance();

        // /* Print debug information in console */
        // System.out.println("Drive Distance: " + driveDistance);
        // System.out.println("Starting Distance: " + Robot.driveTrain.getRightDistance());

        startTime = Timer.getFPGATimestamp();
    }

    /*
     * Function running periodically as long as isFinished() returns false
     */
    public void execute() {

        /* Get distance moved since command started */
        // double currentL = 0.0;
        // double currentR = 0.0;

        
        // currentL = Math.abs(startDistanceL - Robot.driveTrain.getLeftDistance());
        // currentR = Math.abs(startDistanceR - Robot.driveTrain.getRightDistance());

        // // compensate for potential motor inconsistencies. Will help with slight drift to 1 side
        // double rSpeed = 0.4;
        // double lSpeed = 0.4;
        // /*if (currentL > currentR) {
        //     rSpeed *= (currentR/currentL);
        // } else if (currentR > currentL) {
        //     lSpeed *= (currentL/currentR);
        // }*/

        // // SAFETY JUST INCASE MY MATH SUCKS

        // if (rSpeed > 0.5 || lSpeed > 0.5) {
        //     rSpeed = 0.4;
        //     lSpeed = 0.4;
        //     System.out.println("VERY BAD AUTONOMOUS CODE");
        // }

        // ///
        // /* Find an average of both distances moved to calculate an appropriate speed */
        // // double averageDistance = (currentL + currentR) / 2;

        // /* Set a tank drive movement with speed returning from getSpeed() */
        // if (forwardMovement) {
        //     // Robot.driveTrain.tankDrive(getSpeed(currentL, driveDistance) * -1,
        //     // getSpeed(currentL, driveDistance) * -1);
        //     Robot.driveTrain.tankDrive(-lSpeed, -rSpeed);
        // } else {
        //     // Robot.driveTrain.tankDrive(getSpeed(currentL, driveDistance),
        //     // getSpeed(currentL, driveDistance));
        //     Robot.driveTrain.tankDrive(lSpeed, rSpeed);
        // }
        // /* Print debug information in console */
        // System.out.println("Distance: " + Robot.driveTrain.getRightDistance());

        if (Timer.getFPGATimestamp() - startTime > 1) {
            // Robot.straightDrive.on();
            //Robot.driveTrain.tankDrive(.5,.5);
            RobotMap.leftGroup.set(.5);
            RobotMap.rightGroup.set(.5);
        } else if (Timer.getFPGATimestamp() - startTime > 3) {
            robot.mode = 1;
        }
        
    }

    /*
     * Determines when to end the command
     */
    @Override
    public boolean isFinished() {
        return Math.abs(startDistanceR - Robot.driveTrain.getRightDistance()) >= driveDistance;
    }

    /*
     * Stops drivetrain when command ends
     */
    protected void end() {
        Robot.driveTrain.stopTank();
        Robot.driveTrain.resetDriveEncoders();
    }

    /*
     * Ends the command of autonomous is stopped or interrupted
     */
    protected void interrupted() {
        end();
    }

    /*
     * Calculates speed based on distance to target. Demo of this function can be
     * found here: https://www.desmos.com/calculator/mjxmn8nmug
     */
    private double getSpeed(double current, double total) {
        double speed = (-1 / ((-1 - ((total - 1) / 2)) * (-1 - ((total - 1) / 2))));
        speed = speed * (current - ((total - 1) / 2)) * (current - ((total - 1) / 2));
        speed = speed + 1;
        if (speed < Config.moveMinSpeed) {
            speed = Config.moveMinSpeed;
        }
        return speed;
    }
}