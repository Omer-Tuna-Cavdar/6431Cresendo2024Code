package frc.robot.commands;

import frc.robot.subsystems.LimelightSubsystem;
import edu.wpi.first.wpilibj2.command.Command;




public class LimelightCommand extends Command {
    private final LimelightSubsystem limelightSubsystem;


    public LimelightCommand(LimelightSubsystem limelightSubsystem) {
        addRequirements(limelightSubsystem);
         
        this.limelightSubsystem = limelightSubsystem;
        
    }

    @Override
    public void execute() {

        limelightSubsystem.getY();
        limelightSubsystem.getX();
        limelightSubsystem.getDesiredAngle();




    }

}