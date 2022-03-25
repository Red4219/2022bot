package frc.robot.autonomous.paths;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.autonomous.actions.NewShoot;
import frc.robot.autonomous.actions.NewStraightDrive;

public class ShootAndMove extends SequentialCommandGroup {
    public ShootAndMove() {
        addCommands(
            new NewShoot(),
            new NewStraightDrive(false, 1.5)
        );
    }
}
