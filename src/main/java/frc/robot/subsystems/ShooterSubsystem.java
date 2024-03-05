package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;


public class ShooterSubsystem extends SubsystemBase {

  

  private SparkPIDController PIDController;

  private final DutyCycleEncoder sabitTutucu;

  
  CANSparkMax shooterLeft;
  CANSparkMax shooterRight;
  public CANSparkMax ortadan;

  public ShooterSubsystem(){
    sabitTutucu = new DutyCycleEncoder(1);
    shooterLeft = new CANSparkMax(12, MotorType.kBrushless);
    shooterRight = new CANSparkMax(13, MotorType.kBrushless);
    ortadan = new CANSparkMax(14, MotorType.kBrushless);

    shooterLeft.restoreFactoryDefaults();
    shooterRight.restoreFactoryDefaults();

    ortadan.setSmartCurrentLimit(60);

    shooterLeft.setIdleMode(IdleMode.kCoast);
    shooterRight.setIdleMode(IdleMode.kCoast);
    ortadan.setIdleMode(IdleMode.kBrake);
    shooterRight.setInverted(false);
    shooterRight.follow(shooterLeft, false);

    PIDController = shooterLeft.getPIDController();
    PIDController.setP(15);
    PIDController.setI(0);
    PIDController.setD(0);

    shooterLeft.getEncoder().setVelocityConversionFactor(1);

  }

  public double getFlywheelRPM(){

    return shooterLeft.getEncoder().getVelocity();
  }

  public DutyCycleEncoder getsabit() {

    return sabitTutucu;
  }

  public void shootFlywheelOnRPM(double rpm) {

    PIDController.setReference(rpm, ControlType.kVelocity);
  }

  public void ShootertoPosition (double position) {
    ortadan.getPIDController().setReference(position, ControlType.kPosition);
}


}