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
public class MoveFlyWheel extends CommandBase {
    
    /* Initialize variables */
    boolean moveUp = false;

    /*
     * Declares public function MoveIndexer with parameter of whether the Indexer will move clockwise
     */
    public MoveFlyWheel() {
        addRequirements(Robot.flyWheel);
    }

    /*
     * Function running periodically as long as isFinished() returns false
     */
    public void execute() {

        //double rotateAmount = OI.operator.getRawAxis(4);

        /*if (OI.rotateClimberUp.get()) {
            Robot.climber.rotateClimberUp();
            System.out.println("Climbing");
        } else if(OI.rotateClimberDown.get()) {
            System.out.println("Un-CLimbing");
            Robot.climber.rotateClimberDown();
        } else {
            Robot.climber.stop(false);
        }*/

        if(OI.flyWheelButton.get()) {
            Robot.flyWheel.runFlyWheel();
        }
    }

    /*
     * Sets the Indexer to stop once the command is finished
     */
    @Override
    public void end(boolean interrupted) {
        Robot.flyWheel.stop(false);
    }

    /*
     * Determines when to end the command
     */
    @Override
    public boolean isFinished() {
        return !OI.flyWheelButton.get();  
    }

    /*
     * Ends the command if stopped or interrupted
     */
    protected void interrupted() {
        end(true);
    }
}
