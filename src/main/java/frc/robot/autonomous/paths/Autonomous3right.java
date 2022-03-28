package frc.robot.autonomous.paths;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.autonomous.actions.FlywheelAction;
import frc.robot.autonomous.actions.IntakeAction;
import frc.robot.autonomous.actions.LowerIntakeAction;
import frc.robot.autonomous.actions.NewShoot;
import frc.robot.autonomous.actions.NewStraightDrive;
import frc.robot.autonomous.actions.OperatorIntakeAction;
import frc.robot.autonomous.actions.RotateDrive;

public class Autonomous3right extends SequentialCommandGroup {
    public Autonomous3right() {
        addCommands(
            //new NewShoot(),
            new RotateDrive(false, 1.95),
            new LowerIntakeAction(),
            new IntakeAction(),
            new NewStraightDrive(true, 1.5),
            new RotateDrive(false, 0.8),
            new NewStraightDrive(true, 1.6),
            new RotateDrive(false, 1.0)
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
