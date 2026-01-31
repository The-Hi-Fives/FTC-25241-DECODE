package org.firstinspires.ftc.teamcode;

import static com.qualcomm.hardware.dfrobot.HuskyLens.Algorithm.TAG_RECOGNITION;

import com.qualcomm.hardware.dfrobot.HuskyLens;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import java.util.ArrayList;




import java.util.List;


@TeleOp
public class apirltags extends LinearOpMode {
    CRServo turret;
    HuskyLens huskyLens;



    private AprilTagProcessor aprilTag;




    @Override
    public void runOpMode() {
        turret = hardwareMap.get(CRServo.class,"Turret");
        huskyLens = hardwareMap.get(HuskyLens.class, "huskylens");
        huskyLens.selectAlgorithm(TAG_RECOGNITION);
        initAprilTag();


        telemetry.addData(">", "Touch START to start OpMode");
        telemetry.update();
        waitForStart();

        if (opModeIsActive()) {
            while (opModeIsActive()) {

                telemetryAprilTag();

                // Push telemetry to the Driver Station.
                telemetry.update();

                // Save CPU resources; can resume streaming when needed.


                // Share the CPU.

            }
        }

        // Save more CPU resources when camera is no longer needed.


    }   // end method runOpMode()

    private void initAprilTag() {

        // Create the AprilTag processor.
    }

    /**
     * Add telemetry about AprilTag detections.
     */
    private void telemetryAprilTag() {

        List<AprilTagDetection> currentDetections = aprilTag.getDetections();
        telemetry.addData("# AprilTags Detected", currentDetections.size());

        // Step through the list of detections and display info for each one.
        for (AprilTagDetection detection : currentDetections) {
            if (detection.metadata != null) {
                if (detection.id == 23) {
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

}   // end class


