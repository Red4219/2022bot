package frc.robot.autonomous.actions;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.FlyWheel;

public class LowerIntakeAction extends CommandBase {
    public LowerIntakeAction() {
        addRequirements(Robot.intake);
    }

    public void initialize() {
        
    }

    public void execute() {
        Robot.intake.raise();
        Timer.delay(1);
    }

    @Override
    public boolean isFinished() {
        Robot.intake.stopLift();
        return true;
    }

    protected void end() {
        Robot.intake.stopLift();
    }

    protected void interrupted() {
        end();
    }
}
