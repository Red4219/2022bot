package frc.robot.autonomous.actions;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.FlyWheel;

public class StopIntakeAction extends CommandBase {
    public StopIntakeAction() {
        addRequirements(Robot.intake);
    }

    public void initialize() {
        
    }

    public void execute() {
        Robot.intake.stop();
        Robot.intake.stopLift();
    }

    @Override
    public boolean isFinished() {
        //Robot.intake.stopLift();
        return true;
    }

    protected void end() {
        //Robot.intake.stopLift();
    }

    protected void interrupted() {
        end();
    }
}
