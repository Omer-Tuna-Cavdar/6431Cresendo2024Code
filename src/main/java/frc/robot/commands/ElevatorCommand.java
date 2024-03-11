package frc.robot.commands;

import frc.robot.subsystems.ElevatorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj.PS4Controller;




public class ElevatorCommand extends Command {
    private final ElevatorSubsystem elevatorSubsystem;
    private PS4Controller driver;


    public ElevatorCommand(ElevatorSubsystem elevatorSubsystem, PS4Controller driver) {
        addRequirements(elevatorSubsystem);

        this.elevatorSubsystem = elevatorSubsystem; 
        this.driver = driver;

        
    }

   @Override
    public void execute() {

       elevatorSubsystem.getElevatorPosition();

        if(driver.getTriangleButton()) {

            elevatorSubsystem.setPosition(-138);

        }

        if(driver.getCrossButton()) {

            elevatorSubsystem.setPosition(0);

        }

      } 
    
    }

    