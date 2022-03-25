package frc.robot.autonomous.actions;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.FlyWheel;

public class NewShoot extends CommandBase {
    public NewShoot() {
        addRequirements(Robot.flyWheel);
        addRequirements(Robot.shooter);
    }

    public void initialize() {
        
    }

    public void execute() {
        Robot.flyWheel.runFlyWheel();
        Timer.delay(3);
        Robot.shooter.on();
        Timer.delay(3);
        Robot.flyWheel.stop(true);
        Robot.shooter.stop();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    protected void end() {
        Robot.shooter.stop();
        Robot.flyWheel.stop(true);
    }

    protected void interrupted() {
        end();
    }
}
