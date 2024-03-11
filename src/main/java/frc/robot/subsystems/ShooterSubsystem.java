package frc.robot.subsystems;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;



public class ShooterSubsystem extends SubsystemBase {

  

  private SparkPIDController PIDController;

  
  CANSparkMax shooterLeft = new CANSparkMax(12, MotorType.kBrushless);
  CANSparkMax shooterRight = new CANSparkMax(13, MotorType.kBrushless);
  CANSparkMax ortadanMotor = new CANSparkMax(14, MotorType.kBrushless);
  RelativeEncoder ortadanEncoder = ortadanMotor.getEncoder();


  public PWMSparkMax FeederMtr;

  public ShooterSubsystem(){


    FeederMtr = new PWMSparkMax(0);

    shooterLeft.restoreFactoryDefaults();
    shooterRight.restoreFactoryDefaults();


    ortadanMotor.setSmartCurrentLimit(60);
    ortadanEncoder.setPosition(0);

    shooterLeft.setIdleMode(IdleMode.kCoast);
    shooterRight.setIdleMode(IdleMode.kCoast);
    ortadanMotor.setIdleMode(IdleMode.kBrake);
    shooterRight.setInverted(false);
    shooterRight.follow(shooterLeft, false);

    PIDController = shooterLeft.getPIDController();
    PIDController.setP(1);
    PIDController.setI(0.1);
    PIDController.setD(0.1);
    shooterLeft.getEncoder().setVelocityConversionFactor(1);

  }

  public double getFlywheelRPM(){

    return shooterLeft.getEncoder().getVelocity();
  }


  public void shootFlywheelOnRPM(double rpm) {

    PIDController.setReference(rpm, ControlType.kVelocity);
  }

  public void ShootertoPosition (double position) {
    ortadanMotor.getPIDController().setReference(position, ControlType.kPosition, 0, 0.1); 
  }

  public void stopMotors() {

   shooterLeft.set(0);
   shooterRight.set(0);
   FeederMtr.set(0);

 }

  public void getShooterPosition () {
    System.out.println(ortadanEncoder.getPosition());
  }


}

