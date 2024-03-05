package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {

    private final CANSparkMax intakeMotor;
    private final CANSparkMax pivotMotor;
    private final DutyCycleEncoder pivotEncoder;

    public final double openPosition = 0.0; //TODO Placeholder - set to actual encoder value for open
    public final double closedPosition = 20; //TODO Placeholder - set to actual encoder value for closed

    public IntakeSubsystem() {
        intakeMotor = new CANSparkMax(10, MotorType.kBrushless);
        pivotMotor = new CANSparkMax(9, MotorType.kBrushless);
        pivotEncoder = new DutyCycleEncoder(0);

        pivotMotor.getPIDController().setP(0.1); // Adjust PID values as needed
        pivotMotor.getPIDController().setI(0.0);
        pivotMotor.getPIDController().setD(0.0);
        pivotMotor.getPIDController().setFF(1.0 / 5800.0);
        pivotEncoder.setPositionOffset(0);
        intakeMotor.setIdleMode(IdleMode.kCoast);
        pivotMotor.setIdleMode(IdleMode.kBrake);



        pivotMotor.setSmartCurrentLimit(45);

        intakeMotor.setSmartCurrentLimit(25);
    }

    public void setIntakeSpeed(double speed) {
        intakeMotor.set(speed);
    }

    public void pivotToPosition(double position) {
        pivotMotor.getPIDController().setReference(position, ControlType.kPosition);
    }

    public boolean isPivotAtTarget(double targetPosition) {
        return Math.abs(pivotEncoder.get() - targetPosition) < 0.05; // Adjust tolerance as needed
    }

    public void openIntake() {
        pivotToPosition(openPosition);
        setIntakeSpeed(0.3);
    }

    public void closeIntake() {
        pivotToPosition(closedPosition);
         setIntakeSpeed(0);
    }

    public double getPivotPosition() {
        return pivotEncoder.get();
    }

    public void runIntake() {
            setIntakeSpeed(1.0); // Adjust speed as needed
        SmartDashboard.putNumber("Intake Pivot Encoder", pivotEncoder.getAbsolutePosition());
    }
}
