package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.Robot;



/*
 * This command moves the Indexer
 *  clockwise and counterclockwise
 * 
 * Author: Isaac Leal
 */
public class moveClimber extends CommandBase {
    
    /* Initialize variables */
    boolean moveUp = false;

    /*
     * Declares public function MoveIndexer with parameter of whether the Indexer will move clockwise
     */
    public moveClimber(boolean up) {
        addRequirements(Robot.climber);
        moveUp = up;
    }

    /*
     * Function running periodically as long as isFinished() returns false
     */
    public void execute() {
        //Robot.climber.rotateClimberUp();
        double rotateAmount = OI.operator.getRawAxis(4);
        /*if (Math.abs(rotateAmount) > 0.1) {
            //Robot.climber.rotate(rotateAmount,false);
            Robot.climber.rotateClimberUp();
        } else if (OI.rotateClimberUp.get()) {
            Robot.climber.rotateClimberUp();
            System.out.println("Climbing");
        } else if(OI.rotateClimberDown.get()) {
            System.out.println("Un-CLimbing");
            Robot.climber.rotateClimberDown();
        } else {
            Robot.climber.stop(false);
        }*/

        if (OI.rotateClimberUp.get()) {
            Robot.climber.rotateClimberUp();
            System.out.println("Climbing");
        } else if(OI.rotateClimberDown.get()) {
            System.out.println("Un-CLimbing");
            Robot.climber.rotateClimberDown();
        } else {
            Robot.climber.stop(false);
        }

        /*if(moveUp) {
            Robot.climber.rotateClimberUp();
        } else {
            Robot.climber.rotateClimberDown();
        }*/
    }

    /*
     * Sets the Indexer to stop once the command is finished
     */
    @Override
    public void end(boolean interrupted) {
        Robot.climber.stop(false);
    }

    /*
     * Determines when to end the command
     */
    @Override
    public boolean isFinished() {
        return false;
        //if (moveCw) {
            //return !OI.raiseIntakeButton.get();
        //} else {
            //return !OI.raiseIntakeButton.get();
        //}
        
    }

    /*
     * Ends the command if stopped or interrupted
     */
    protected void interrupted() {
        end(true);
    }
}
