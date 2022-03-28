package frc.robot.autonomous.actions;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.FlyWheel;

public class FlywheelAction extends CommandBase {
    public FlywheelAction() {
        addRequirements(Robot.flyWheel);
    }

    public void initialize() {
        
    }

    public void execute() {
        /*Robot.operatorIntake.raise();
        Timer.delay(1);
        Robot.operatorIntake.stopLift();
        Timer.delay(1);
        Robot.operatorIntake.raise();
        Timer.delay(1);*/
        Robot.flyWheel.runFlyWheel();
        Timer.delay(1);
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
