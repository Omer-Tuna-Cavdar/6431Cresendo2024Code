package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.lang.Math;
import org.photonvision.PhotonCamera;
import edu.wpi.first.math.util.Units;


public class LimelightSubsystem extends SubsystemBase {
  
  NetworkTable limelightTable;
  double ty, tv, tx, angle, distance;
  double min_command = 0.05;
  PIDController alignController = new PIDController(0.1, 0, 0);
  PhotonCamera camera;
  private static LimelightSubsystem limelight = null;
 

  public LimelightSubsystem() {
    camera = new PhotonCamera("hüseyin");
  }

  private double getDistance() {
    double noteOffsetAngle_Vertical = getY();
    double angleToNoteDegrees = 30 + noteOffsetAngle_Vertical;
    double angleToNoteRadians = Units.degreesToRadians(angleToNoteDegrees);
    double distanceFromLightToNote = (16-2.5) / Math.tan(angleToNoteRadians);

    return distanceFromLightToNote;
  }

  public static LimelightSubsystem getInstance(){
    return LimelightSubsystem.limelight;
  }

  public double getDesiredRPM(){
   return 0.149827*(Math.pow(1.04964, (4.99985*this.getDistance()) + 29.9996) + 28.4836);
  }

  public double getDesiredAngle(){
    var result = camera.getLatestResult();
    var res = result.getBestTarget().getBestCameraToTarget();
    double x = res.getX();
    double y = res.getY();
    angle = Math.atan(x/y);
    
    
    return angle; }

  public double getY(){
    return camera.getLatestResult().getBestTarget().getBestCameraToTarget().getY();
  }

  public double getX(){
    return camera.getLatestResult().getBestTarget().getBestCameraToTarget().getX();
  }


  
  
}
