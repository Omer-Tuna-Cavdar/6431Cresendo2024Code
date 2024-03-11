package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.Timer;




public class AUTOINTAKE extends Command {
    private final IntakeSubsystem intakeSubsystem;
    private final Timer timer = new Timer();
    


    public AUTOINTAKE(IntakeSubsystem intakeSubsystem) {
        addRequirements(intakeSubsystem);
        this.intakeSubsystem = intakeSubsystem;

        timer.reset();
        timer.start();
        intakeSubsystem.openIntake();
        intakeSubsystem.setIntakeSpeed(-0.5);


        if(timer.get() == 2) {
        intakeSubsystem.closeIntake();
        timer.reset();
        timer.stop();

        }


        
    }


}


// L1 Button, intake alım: intake open position, roller (-), TimeDelay 2 seconds, roller (0), intake close position.

// Yukarı yön tuşu shooter açı: shooter angle(angle1), shooter(+), TimeDelay 2 seconds, feedmotor(+), roller(+)
// Sol yön tuşu shooter açı: shooter angle(angle2), shooter(+), TimeDelay 2 seconds, feedmotor(+), roller(+)
//Sağ yön tuşu shooter açı: shooter angle(angle3), shooter(+), TimeDelay 2 seconds, feedmotor(+), roller(+)



    
    
    

    
