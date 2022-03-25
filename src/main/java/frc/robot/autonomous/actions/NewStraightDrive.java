package frc.robot.autonomous.actions;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class NewStraightDrive extends CommandBase {

    boolean forwardMovement;
    double startTime;
    double moveTime;

    public NewStraightDrive(boolean forward, double time) {
        addRequirements(Robot.driveTrain);

        forwardMovement = forward;
        moveTime = time;
    }

    public void initialize() {
        startTime = Timer.getFPGATimestamp();
    }

    public void execute() {
        if (forwardMovement) {
            Robot.driveTrain.tankDrive(-0.5, -0.5);
        } else {
            Robot.driveTrain.tankDrive(0.5, 0.5);
        }
    }

    @Override
    public boolean isFinished() {
        if (Timer.getFPGATimestamp() - startTime > moveTime) {
            return true;
        } else {
            return false;
        }
    }

    protected void end() {
        Robot.driveTrain.stopTank();
    }

    protected void interrupted() {
        end();
    }
}
