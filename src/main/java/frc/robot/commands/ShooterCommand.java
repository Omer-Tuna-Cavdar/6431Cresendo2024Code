package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

import com.revrobotics.CANSparkBase.ControlType;

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

        if(driver.getTriangleButton()) {

            shooterSubsystem.ortadan.set(1);


            shooterSubsystem.ShootertoPosition(0.3);
        }

        if(driver.getCircleButton()) {

            shooterSubsystem.ShootertoPosition(20);
        }

        if(driver.getSquareButton()) {

            shooterSubsystem.ShootertoPosition(30);
        }

      
        if (driver.getCircleButton()) {
            shooterSubsystem.shootFlywheelOnRPM(7000); } 
            
        if(driver.getR2Button()) {
            shooterSubsystem.shootFlywheelOnRPM(0);

        }
      }
    
    }

    