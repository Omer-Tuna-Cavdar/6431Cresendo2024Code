package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ElevatorSubsystem extends SubsystemBase {
  CANSparkMax leftMotor = new CANSparkMax(11, MotorType.kBrushless);
  CANSparkMax rightMotor = new CANSparkMax(31, MotorType.kBrushless);
  
  RelativeEncoder leftMotorEncoder = leftMotor.getEncoder();
  RelativeEncoder rightMotorEncoder = rightMotor.getEncoder();

  public ElevatorSubsystem() {


    leftMotor.setIdleMode(IdleMode.kBrake);
    rightMotor.setIdleMode(IdleMode.kBrake);

    leftMotor.getPIDController().setP(0.1);
    leftMotor.getPIDController().setI(0);
    leftMotor.getPIDController().setD(0);

    rightMotor.getPIDController().setP(0.1);
    rightMotor.getPIDController().setI(0);
    rightMotor.getPIDController().setD(0);



    
    leftMotor.getEncoder().setVelocityConversionFactor(1);


  }

     public void getElevatorPosition() {

      System.out.println(leftMotorEncoder.getPosition());

     }

   public void setPosition(double position) {

    leftMotor.getPIDController().setReference(position, ControlType.kPosition);
    rightMotor.getPIDController().setReference(position, ControlType.kPosition);



   }

}

 