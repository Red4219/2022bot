package frc.robot.autonomous.actions;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.FlyWheel;

public class StopFlywheelAction extends CommandBase {
    public StopFlywheelAction() {
        addRequirements(Robot.flyWheel);
    }

    public void initialize() {

    }

    public void execute() {
        Robot.flyWheel.stop(false);
    }

    @Override
    public boolean isFinished() {
        //Robot.flyWheel.stop(false);
        return true;
    }

    protected void end() {
        //Robot.flyWheel.stop(false);
    }

    protected void interrupted() {
        end();
    }
}