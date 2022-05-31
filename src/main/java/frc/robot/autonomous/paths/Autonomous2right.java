package frc.robot.autonomous.paths;

import javax.management.MBeanNotificationInfo;

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

public class Autonomous2right extends SequentialCommandGroup {
    public Autonomous2right() {
        addCommands(
            //new NewShoot()
            //new NewStraightDrive(false, 1.5)
            //new RotateDrive(false, 45.0),
            
            new LowerIntakeAction(),
            new IntakeAction(),
            new NewStraightDrive(true, 1.16),
            new NewStraightDrive(false, 1.32),
            new StopIntakeAction(),
            //new NewStraightDrive(true, 1.66),
            //new StopIntakeAction(),
            new RotateDrive(true, 0.42),
            new FlywheelAction(),
            new OperatorIntakeAction(),
            new StopFlywheelAction()
        );
    }
}
