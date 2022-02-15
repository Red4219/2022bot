package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.Robot;



/*
 * This command moves the Indexer
 *  clockwise and counterclockwise
 * 
 * Author: Francisco Fabregat
 */
public class moveIndexer extends CommandBase {
    
    /* Initialize variables */
    boolean moveCw = false;

    /*
     * Declares public function MoveIndexer with parameter of whether the Indexer will move clockwise
     */
    public moveIndexer() {
        addRequirements(Robot.indexer);

        //moveCw = cw;
    }

    /*
     * Function running periodically as long as isFinished() returns false
     */
    public void execute() {
        double rotateAmount = OI.operator.getRawAxis(4);
        if (Math.abs(rotateAmount) > 0.1) {
            Robot.indexer.rotate(rotateAmount,false);
        } else if (OI.rotateIndexerUp.get()) {
            Robot.indexer.rotateIndexerUp();
            System.out.println("CW");
        } else if(OI.rotateIndexerDown.get()) {
            System.out.println("CCW");
            Robot.indexer.rotateIndexerDown();
        } else {
            Robot.indexer.stop(false);
        }
    }

    /*
     * Sets the Indexer to stop once the command is finished
     */
    @Override
    public void end(boolean interrupted) {
        Robot.indexer.stop(false);
    }

    /*
     * Determines when to end the command
     */
    @Override
    public boolean isFinished() {
        return false;
        /*if (moveCw) {
            return !OI.IndexerCWButton.get();
        } else {
            return !OI.IndexerCCWButton.get();
        }*/
        
    }

    /*
     * Ends the command if stopped or interrupted
     */
    protected void interrupted() {
        end(true);
    }
}
