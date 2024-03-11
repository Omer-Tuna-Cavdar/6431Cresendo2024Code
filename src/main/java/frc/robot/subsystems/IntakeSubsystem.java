package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class IntakeSubsystem extends SubsystemBase {

        CANSparkMax intakeMotor = new CANSparkMax(10, MotorType.kBrushless);
        CANSparkMax pivotMotor = new CANSparkMax(9, MotorType.kBrushless);
        RelativeEncoder pivotEncoder = pivotMotor.getEncoder();

    public final double openPosition = -38; 
    public final double closedPosition =-2; 

    public IntakeSubsystem() {



        pivotMotor.getPIDController().setP(0.1); 
        pivotMotor.getPIDController().setI(0.0);
        pivotMotor.getPIDController().setD(0.0);
        intakeMotor.setIdleMode(IdleMode.kCoast);
        pivotMotor.setIdleMode(IdleMode.kBrake);


        pivotMotor.setSmartCurrentLimit(45);
        pivotEncoder.setPosition(0);

        intakeMotor.setSmartCurrentLimit(25);


    }

    public void setIntakeSpeed(double speed) {
        intakeMotor.set(speed);
    }

    public void pivotToPosition(double position) {

        pivotMotor.getPIDController().setReference(position, ControlType.kPosition);
    }

    public void openIntake() {
        pivotToPosition(openPosition);
    }

    public void closeIntake() {
        pivotToPosition(closedPosition);
    }

    public double getPivotPosition() {
        return pivotEncoder.getPosition();
    }

    public void stopMotors() {

        setIntakeSpeed(0);
    }


}