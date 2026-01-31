package org.firstinspires.ftc.teamcode;

import static com.qualcomm.hardware.dfrobot.HuskyLens.Algorithm.TAG_RECOGNITION;

import androidx.annotation.NonNull;

import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;

import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

public class testing extends OpMode {
    private HuskyLens huskylens;
    private CRServo Turret;
    @Override
    public void init() {
        Turret = hardwareMap.get(CRServo.class,"Turret");
        huskylens = hardwareMap.get(HuskyLens.class, "huskylens");
        huskylens.selectAlgorithm(TAG_RECOGNITION);

    }




    public void loop() {
        AprilTagDetection[] currentDetections = new AprilTagDetection[0];
        for (AprilTagDetection detection : currentDetections) {
            if (detection.metadata != null) {
                if (detection.id == 23) {
                    if (detection.ftcPose.bearing < -10) {
                        Turret.setPower(-0.6);
                    } else if (detection.ftcPose.bearing > 10) {
                        Turret.setPower(0.6);
                    } else {
                        Turret.setPower(0);
                    }

                } else {
                    Turret.setPower(0);
                }

                telemetry.addLine(String.format("\n==== (ID %d) %s", detection.id, detection.metadata.name));
                telemetry.addLine(String.format("XYZ %6.1f %6.1f %6.1f  (inch)", detection.ftcPose.x, detection.ftcPose.y, detection.ftcPose.z));
                telemetry.addLine(String.format("PRY %6.1f %6.1f %6.1f  (deg)", detection.ftcPose.pitch, detection.ftcPose.roll, detection.ftcPose.yaw));
                telemetry.addLine(String.format("RBE %6.1f %6.1f %6.1f  (inch, deg, deg)", detection.ftcPose.range, detection.ftcPose.bearing, detection.ftcPose.elevation));
            } else {
                telemetry.addLine(String.format("\n==== (ID %d) Unknown", detection.id));
                telemetry.addLine(String.format("Center %6.0f %6.0f   (pixels)", detection.center.x, detection.center.y));
                Turret.setPower(0);

            }
        }   // end for() loop

    }
}
