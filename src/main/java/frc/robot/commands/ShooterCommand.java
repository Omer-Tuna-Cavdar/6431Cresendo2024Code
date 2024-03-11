package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.PS4Controller;



public class ShooterCommand extends Command {
    private final ShooterSubsystem shooterSubsystem;
    private PS4Controller driver;



    public ShooterCommand(ShooterSubsystem shooterSubsystem, PS4Controller driver) {
        addRequirements(shooterSubsystem);
         
        this.shooterSubsystem = shooterSubsystem;
        this.driver = driver;

        
    }

    @Override
    public void execute() {

        shooterSubsystem.getShooterPosition();

        if(driver.getL1Button()) {

         shooterSubsystem.ShootertoPosition(0.15);

        }


        if(driver.getTriangleButton()) {

           shooterSubsystem.shootFlywheelOnRPM(8000); 
            shooterSubsystem.shootFlywheelOnRPM(8000); 

     
        }

        if(driver.getR2Button())  {
        shooterSubsystem.FeederMtr.set(0.6);
        }


        if(driver.getCrossButton()) {

         shooterSubsystem.ShootertoPosition(0.05);
        }

        if(driver.getCircleButton()) {

            shooterSubsystem.stopMotors();
        }
        
      }

    }

    // Yukarı yön tuşu shooter açı: shooter angle(angle1), shooter(+), TimeDelay 2 seconds, feedmotor(+), roller(+)

