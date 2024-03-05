package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.PS4Controller;




public class IntakeCommand extends Command {
    private final IntakeSubsystem intakeSubsystem;
    private PS4Controller driver;
    private boolean isOpen;


    public IntakeCommand(IntakeSubsystem intakeSubsystem, PS4Controller driver, boolean isOpen) {
        addRequirements(intakeSubsystem);
         
        this.intakeSubsystem = intakeSubsystem;
        this.driver = driver;
        this.isOpen = isOpen;

        
    }

    @Override
    public void execute() {

        isFinished();
      
        if (driver.getL1Button()) {
            intakeSubsystem.openIntake();

        } else if(driver.getR1Button()) {

            intakeSubsystem.closeIntake();
        }
      }

    @Override
    public boolean isFinished() {
        return intakeSubsystem.isPivotAtTarget(isOpen ? intakeSubsystem.openPosition : intakeSubsystem.closedPosition);
    }
    
    
    }

    
