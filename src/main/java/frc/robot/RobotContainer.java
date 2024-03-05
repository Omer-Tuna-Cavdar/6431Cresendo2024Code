package frc.robot;

import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.ShooterSubsystem;
import com.pathplanner.lib.auto.AutoBuilder;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.TeleopSwerve;
import frc.robot.commands.ShooterCommand;


public class RobotContainer {
  private final PS4Controller driver = new PS4Controller(0);
  public Swerve swerve = new Swerve();
  public ShooterSubsystem shooter = new ShooterSubsystem();
  public IntakeSubsystem intake = new IntakeSubsystem();

  public RobotContainer() {

    ShooterCommand OmarShooter = new ShooterCommand(shooter, driver); 
    TeleopSwerve Omar = new TeleopSwerve(swerve, driver);
    IntakeCommand OmarIntake = new IntakeCommand(intake, driver, false);

    intake.setDefaultCommand(OmarIntake);
    swerve.setDefaultCommand(Omar);
    shooter.setDefaultCommand(OmarShooter);

  }



   public Command getAutonomousCommand() {
    return AutoBuilder.buildAuto("Example Auto");
  }

}

