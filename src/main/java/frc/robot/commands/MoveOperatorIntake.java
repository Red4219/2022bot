package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

/*
 * This command lowers and rises the intake
 * 
 * Author: Francisco Fabregat
 */
public class MoveOperatorIntake extends CommandBase {

    /* Initialize variables */
    boolean moveUp = false;

    /*
     * Declares public function LiftIntake with parameter of whether the intake will move up
     */
    public MoveOperatorIntake(boolean up) {
        addRequirements(Robot.operatorIntake);

        moveUp = up;
    }

    /*
     * Function running periodically as long as isFinished() returns false
     */
    //boolean executed = false;
    public void initialize() {
        //executed = false;
    }
    public void execute() {
        System.out.println("moving up");
        //System.out.println("execute called");
        //System.out.println("upswitch: " + RobotMap.intakeUpSwitch.get());
        //System.out.println("downswitch: " + RobotMap.intakeDownSwitch.get());
        if (moveUp) {
            //System.out.println("raise moveUp:" + moveUp);
            //System.out.println("upswitch: " + RobotMap.intakeUpSwitch.get());
            //if (!RobotMap.intakeUpSwitch.get()) {
                Robot.operatorIntake.raise();
            //}
        } else {
            //System.out.println("downswitch: " + RobotMap.intakeDownSwitch.get());
        //    if (!RobotMap.intakeDownSwitch.get()) {
                //System.out.println("lower moveUp:" + moveUp);
                Robot.operatorIntake.lower();
          //  }
        }
        //executed = true;
    }

    /*
     * Sets the intake to stop once the command is finished
     */
    @Override
    public void end(boolean interrupted) {
        //if (interrupted) {
        //    Robot.intake.stopLift();
        //}
        Robot.operatorIntake.stopLift();
        
    }

    /*
     * Determines when to end the command
     */
    @Override
    public boolean isFinished() {
        //return executed;
        if (moveUp) {
            return !OI.operatorIntakeForward.get();
            //return RobotMap.intakeUpSwitch.get();
        } else {
            return !OI.operatorIntakeBackard.get();
            //return RobotMap.intakeDownSwitch.get();
        }
    }

    /*
     * Ends the command if stopped or interrupted
     */
    protected void interrupted() {
        end(true);
    }
    
}