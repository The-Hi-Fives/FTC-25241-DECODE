package org.firstinspires.ftc.teamcode;




import android.annotation.SuppressLint;
import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagGameDatabase;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

@TeleOp
public class MainCode2sensors extends LinearOpMode {
    CRServo turret;
    private static final boolean USE_WEBCAM = true;  // true for webcam, false for phone camera


    private AprilTagProcessor aprilTag;


    private VisionPortal visionPortal;



    CRServo rightpassof;
    CRServo leftpassof;
    DcMotor shooter;
    DcMotor intake;
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    Servo aimer;
    public void runOpMode() {
        waitForStart();
        turret = hardwareMap.get(CRServo.class,"Turret");
        leftpassof = hardwareMap.get(CRServo.class, "leftpassof");
        rightpassof = hardwareMap.get(CRServo.class, "rightpassof");
        intake = hardwareMap.get(DcMotor.class, "intake");
        frontLeft = hardwareMap.get(DcMotor.class, "fLeft");
        frontRight = hardwareMap.get(DcMotor.class, "fRight");
        backLeft = hardwareMap.get(DcMotor.class, "bLeft");
        backRight = hardwareMap.get(DcMotor.class, "bRight");
        shooter = hardwareMap.get(DcMotor.class, "shooter");
        aimer = hardwareMap.get(Servo.class, "aimer");


        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
      if(opModeIsActive()) {
          while (OpModeIsActive()) {


              if (gamepad2.a) {
                  leftpassof.setPower(1);
                  rightpassof.setPower(1);
              } else {
                  leftpassof.setPower(0);
                  rightpassof.setPower(0);
              }
              if (gamepad2.right_bumper) {
                  intake.setPower(1);
              } else {
                  intake.setPower(0);
              }
              if (gamepad2.left_bumper) {
                  shooter.setPower(1);
              } else {
                  shooter.setPower(0);
              }



              telemetry.update();
              if (gamepad2.dpad_left) {
                  aimer.setPosition(0.98);
              }
              if (gamepad2.dpad_up) {
                  aimer.setPosition(0.9);
              }
              if (gamepad2.dpad_right) {
                  aimer.setPosition(0.8);
              }
              if(gamepad2.dpad_down){
                  aimer.setPosition(0.76);
              }
              telemetryAprilTag();

              sleep(20);


              waitForStart();


          }

          visionPortal.close();
      }
    }

    private boolean OpModeIsActive() {
        return true;
    }
    private void initAprilTag() {
        // Create the AprilTag processor.

        aprilTag = new AprilTagProcessor.Builder()

                // The following default settings are available to un-comment and edit as needed.
                .setDrawAxes(false)
                .setDrawCubeProjection(false)
                .setDrawTagOutline(true)
                .setTagFamily(AprilTagProcessor.TagFamily.TAG_36h11)
                .setTagLibrary(AprilTagGameDatabase.getCenterStageTagLibrary())
                .setOutputUnits(DistanceUnit.INCH, AngleUnit.DEGREES)

                // == CAMERA CALIBRATION ==
                // If you do not manually specify calibration parameters, the SDK will attempt
                // to load a predefined calibration for your camera.
                .setLensIntrinsics(1416.87, 1416.87, 490.629, 427.258)
                // ... these parameters are fx, fy, cx, cy.

                .build();


        aprilTag.setDecimation(3);

        // Create the vision portal by using a builder.
        VisionPortal.Builder builder = new VisionPortal.Builder();


        if (USE_WEBCAM) {
            builder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"));
        } else {
            builder.setCamera(BuiltinCameraDirection.BACK);
        }

        // Choose a camera resolution. Not all cameras support all resolutions.
        builder.setCameraResolution(new Size(640, 480));

        // Enable the RC preview (LiveView).  Set "false" to omit camera monitoring.
        builder.setLiveViewContainerId(1);


        builder.setStreamFormat(VisionPortal.StreamFormat.YUY2);



        // Set and enable the processor.
        builder.addProcessor(aprilTag);

        // Build the Vision Portal, using the above settings.
        visionPortal = builder.build();

        // Disable or re-enable the aprilTag processor at any time.
        visionPortal.setProcessorEnabled(aprilTag, true);

//        // Create the AprilTag processor the easy way.
        aprilTag = AprilTagProcessor.easyCreateWithDefaults();
//
//        // Create the vision portal the easy way.
        if (USE_WEBCAM) {
            visionPortal = VisionPortal.easyCreateWithDefaults(
                    hardwareMap.get(WebcamName.class, "Webcam 1"), aprilTag);
        } else {
            visionPortal = VisionPortal.easyCreateWithDefaults(
                    BuiltinCameraDirection.BACK, aprilTag);
        }

    }   // end method initAprilTag()



    @SuppressLint("DefaultLocale")
    private void telemetryAprilTag() {

        List<AprilTagDetection> currentDetections = aprilTag.getDetections();
        telemetry.addData("# AprilTags Detected", currentDetections.size());

        // Step through the list of detections and display info for each one.
        for (AprilTagDetection detection : currentDetections) {
            if (detection.metadata != null) {
                if (detection.id == 24) {
                    if (detection.ftcPose.bearing < -10) {
                        turret.setPower(-0.6);
                    } else if (detection.ftcPose.bearing > 10) {
                        turret.setPower(0.6);
                    } else {
                        turret.setPower(0);
                    }

                } else {
                    turret.setPower(0);
                }

                telemetry.addLine(String.format("\n==== (ID %d) %s", detection.id, detection.metadata.name));
                telemetry.addLine(String.format("XYZ %6.1f %6.1f %6.1f  (inch)", detection.ftcPose.x, detection.ftcPose.y, detection.ftcPose.z));
                telemetry.addLine(String.format("PRY %6.1f %6.1f %6.1f  (deg)", detection.ftcPose.pitch, detection.ftcPose.roll, detection.ftcPose.yaw));
                telemetry.addLine(String.format("RBE %6.1f %6.1f %6.1f  (inch, deg, deg)", detection.ftcPose.range, detection.ftcPose.bearing, detection.ftcPose.elevation));
            } else {
                telemetry.addLine(String.format("\n==== (ID %d) Unknown", detection.id));
                telemetry.addLine(String.format("Center %6.0f %6.0f   (pixels)", detection.center.x, detection.center.y));
                turret.setPower(0);

            }
        }   // end for() loop
        if (currentDetections.isEmpty()) {
            turret.setPower(0);
        }
        // Add "key" information to telemetry
        telemetry.addLine("\nkey:\nXYZ = X (Right), Y (Forward), Z (Up) dist.");
        telemetry.addLine("PRY = Pitch, Roll & Yaw (XYZ Rotation)");
        telemetry.addLine("RBE = Range, Bearing & Elevation");

    }   // end method telemetryAprilTag()
}