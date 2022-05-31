package frc.robot.autonomous.paths;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.autonomous.actions.FlywheelAction;
import frc.robot.autonomous.actions.IntakeAction;
import frc.robot.autonomous.actions.LowerIntakeAction;
import frc.robot.autonomous.actions.NewShoot;
import frc.robot.autonomous.actions.NewStraightDrive;
import frc.robot.autonomous.actions.OperatorIntakeAction;
import frc.robot.autonomous.actions.RotateDrive;
import frc.robot.autonomous.actions.RotateDriveByDegrees;
import frc.robot.autonomous.actions.StopFlywheelAction;
import frc.robot.autonomous.actions.StopIntakeAction;

public class Autonomous3right extends SequentialCommandGroup {
    public Autonomous3right() {
        addCommands(
            //new NewShoot(),
            //new RotateDriveByDegrees(false, 45)


            ////
            /*new LowerIntakeAction(),
            new IntakeAction(),
            new NewStraightDrive(true, 1.5),
            new RotateDrive(false, 0.6),
            new StopIntakeAction(),
            new NewStraightDrive(true, 1.8),
            new FlywheelAction(),
            new OperatorIntakeAction(),
            new StopFlywheelAction(),

            new IntakeAction(),
            new RotateDrive(false, 0.44),
            new NewStraightDrive(true, 3.0),
            new RotateDrive(true, 0.58),
            new StopIntakeAction(),
            new FlywheelAction(),
            new NewStraightDrive(true, 1.8),
            new RotateDrive(false, 0.2),
            new NewStraightDrive(true, 0.7),
            new OperatorIntakeAction(),
            new StopFlywheelAction()*/

            /////

            new LowerIntakeAction(),
            new IntakeAction(),
            new NewStraightDrive(true, 1.2),
            new NewStraightDrive(false, 1.22),
            //new RotateDrive(false, 0.57),
            new StopIntakeAction(),
            //new NewStraightDrive(true, 1.66),
            //new StopIntakeAction(),
            new RotateDrive(true, 0.42),
            new FlywheelAction(),
            new OperatorIntakeAction(),
            new StopFlywheelAction(),

            new RotateDrive(false, 0.20),
            new IntakeAction(),

            new NewStraightDrive(true, 2.0)


            //new FlywheelAction(),
            //new OperatorIntakeAction()
            
            //new NewStraightDrive(true, 0.7)

            //new NewStraightDrive(false, 1.5)
            //new RotateDrive(false, 45.0),
            
            /*new LowerIntakeAction(),
            new IntakeAction(),
            new NewStraightDrive(true, 1.5),
            new RotateDrive(false, 2.0),
            new NewStraightDrive(true, 1.0),
            new FlywheelAction(),
            new OperatorIntakeAction()*/
        );
    }
}
