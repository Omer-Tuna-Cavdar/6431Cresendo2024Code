package frc.robot;

import com.pathplanner.lib.commands.FollowPathWithEvents;
import com.pathplanner.lib.path.PathPlannerPath;

import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.Swerve;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.*;

import java.util.function.Supplier;

import com.pathplanner.lib.auto.AutoBuilder;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ElevatorCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.TeleopSwerve;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.LimelightCommand;

public class RobotContainer {

  private final PS4Controller driver = new PS4Controller(0);
  public Swerve swerve = new Swerve();
  public ElevatorSubsystem elevatorSubsystem= new ElevatorSubsystem();
  public ShooterSubsystem shooter = new ShooterSubsystem();
  public IntakeSubsystem intake = new IntakeSubsystem();
  public LimelightSubsystem limelight = new LimelightSubsystem();

  public RobotContainer() {

    ShooterCommand OmarShooter = new ShooterCommand(shooter, driver);
    TeleopSwerve Omar = new TeleopSwerve(swerve, driver);
    IntakeCommand OmarIntake = new IntakeCommand(intake, driver);
    LimelightCommand OmarLimelight = new LimelightCommand(limelight);
    ElevatorCommand Tuna = new ElevatorCommand(elevatorSubsystem, driver);
    intake.setDefaultCommand(OmarIntake);
    swerve.setDefaultCommand(Omar);
    elevatorSubsystem.setDefaultCommand(Tuna);
    shooter.setDefaultCommand(OmarShooter);
    limelight.setDefaultCommand(OmarLimelight);

  }

  public Command getAutonomousCommand() {

    return AutoBuilder.buildAuto("Düz");
  }

}
