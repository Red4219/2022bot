package frc.robot.autonomous.actions;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.FlyWheel;

public class OperatorIntakeAction extends CommandBase {
    public OperatorIntakeAction() {
        addRequirements(Robot.operatorIntake);
    }

    public void initialize() {
        
    }

    public void execute() {
        Robot.operatorIntake.raise();
        Timer.delay(1);
        Robot.operatorIntake.stopLift();
        Timer.delay(1);
        Robot.operatorIntake.raise();
        Timer.delay(1);
    }

    @Override
    public boolean isFinished() {
        Robot.operatorIntake.stopLift();
        return true;
    }

    protected void end() {
        Robot.operatorIntake.stopLift();
    }

    protected void interrupted() {
        end();
    }
}
