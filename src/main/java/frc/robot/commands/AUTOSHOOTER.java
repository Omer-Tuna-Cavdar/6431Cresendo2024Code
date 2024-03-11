package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.Timer;




public class AUTOSHOOTER extends Command {
    private final ShooterSubsystem shooterSubsystem;
    private IntakeSubsystem intake;
    private Timer timer = new Timer();



    public AUTOSHOOTER(ShooterSubsystem shooterSubsystem, IntakeSubsystem intake) {
        addRequirements(shooterSubsystem);
        addRequirements(intake);
        this.intake = intake;
        this.shooterSubsystem = shooterSubsystem;
        timer.reset();
        timer.start();
        shooterSubsystem.ShootertoPosition(0.04);

        if(timer.get() == 2)
        {
        intake.setIntakeSpeed(0.5);
        shooterSubsystem.FeederMtr.set(0.5);
        shooterSubsystem.shootFlywheelOnRPM(8000); 

        }

    }   


    }
    
    // Yukarı yön tuşu shooter açı: shooter angle(angle1), shooter(+), TimeDelay 2 seconds, feedmotor(+), roller(+)

    