//package org.firstinspires.ftc.teamcode;
//
//import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
//import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
//import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
//import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
//
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.CRServo;
//
//import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
//import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
//import org.firstinspires.ftc.vision.VisionPortal;
//import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
//import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
//
//import java.util.List;
//
//@TeleOp(name = "MainCode2sensors", group = "Robot")
//public class MainCode1sensors {
//    CRServo turret;
//    private static final boolean USE_WEBCAM = true;  // true for webcam, false for phone camera
//
//
//    private AprilTagProcessor aprilTag;
//
//
//    private VisionPortal visionPortal;
//
//    CRServo rightpassof;
//    CRServo leftpassof;
//
//    public void init() {
//        turret = hardwareMap.get(CRServo.class,"Turret");
//        leftpassof = hardwareMap.get(CRServo.class, "leftpassof");
//        rightpassof = hardwareMap.get(CRServo.class, "rightpassof");
//        DcMotor intake = hardwareMap.get(DcMotor.class, "intake");
//        DcMotor frontLeft = hardwareMap.get(DcMotor.class, "fLeft");
//        DcMotor frontRight = hardwareMap.get(DcMotor.class, "fRight");
//        DcMotor backLeft = hardwareMap.get(DcMotor.class, "bLeft");
//        DcMotor backRight = hardwareMap.get(DcMotor.class, "bRight");
//
//
//        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
//        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
//
//        while (OpModeIsActive()) {
//            double forward = -gamepad1.left_stick_y;
//            double strafe = gamepad1.left_stick_x;
//            double turn = gamepad1.right_stick_x;
//            if (gamepad1.x) {
//                forward /= 2;
//                strafe /= 2;
//                turn /= 2;
//            }
//            double denominator = Math.max(Math.abs(forward) + Math.abs(strafe) + Math.abs(turn), 1);
//
//            frontRight.setPower((forward - strafe - turn) / denominator);
//            frontLeft.setPower((forward + strafe + turn) / denominator);
//            backLeft.setPower((forward - strafe + turn) / denominator);
//            backRight.setPower((forward + strafe + turn) / denominator);
//
//            if (gamepad1.right_bumper) {
//                leftpassof.setPower(1);
//                rightpassof.setPower(1);
//            } else {
//                leftpassof.setPower(0);
//                rightpassof.setPower(0);
//            }
//            if (gamepad1.right_bumper) {
//                intake.setPower(1);
//            } else {
//                intake.setPower(0);
//            }
//            if(gamepad1.a) {
//                turret.setPower(1);
//            }else{
//                turret.setPower(0);
//            }
//            if(gamepad1.b) {
//                turret.setPower(-1);
//            }else {
//                turret.setPower(0);
//            }
//
//            while (opModeIsActive()) {
//
//                telemetryAprilTag();
//
//                // Push telemetry to the Driver Station.
//                telemetry.update();
//            }
//
//
//        }
//
//
//    }
//
//    private boolean opModeIsActive() {
//        return false;
//    }
//
//    private boolean OpModeIsActive() {
//
//        return false;
//    }
//
//    private void telemetryAprilTag() {
//
//        List<AprilTagDetection> currentDetections = aprilTag.getDetections();
//        telemetry.addData("# AprilTags Detected", currentDetections.size());
//
//        // Step through the list of detections and display info for each one.
//        for (AprilTagDetection detection : currentDetections) {
//            if (detection.metadata != null) {
//                if (detection.id == 23) {
//                    if (detection.ftcPose.bearing < -10) {
//                        turret.setPower(-0.6);
//                    } else if (detection.ftcPose.bearing > 10) {
//                        turret.setPower(0.6);
//                    } else {
//                        turret.setPower(0);
//                    }
//
//                } else {
//                    turret.setPower(0);
//                }
//
//                telemetry.addLine(String.format("\n==== (ID %d) %s", detection.id, detection.metadata.name));
//                telemetry.addLine(String.format("XYZ %6.1f %6.1f %6.1f  (inch)", detection.ftcPose.x, detection.ftcPose.y, detection.ftcPose.z));
//                telemetry.addLine(String.format("PRY %6.1f %6.1f %6.1f  (deg)", detection.ftcPose.pitch, detection.ftcPose.roll, detection.ftcPose.yaw));
//                telemetry.addLine(String.format("RBE %6.1f %6.1f %6.1f  (inch, deg, deg)", detection.ftcPose.range, detection.ftcPose.bearing, detection.ftcPose.elevation));
//            } else {
//                telemetry.addLine(String.format("\n==== (ID %d) Unknown", detection.id));
//                telemetry.addLine(String.format("Center %6.0f %6.0f   (pixels)", detection.center.x, detection.center.y));
//                turret.setPower(0);
//
//            }
//        }   // end for() loop
//        if (currentDetections.isEmpty()) {
//            turret.setPower(0);
//        }
//        // Add "key" information to telemetry
//        telemetry.addLine("\nkey:\nXYZ = X (Right), Y (Forward), Z (Up) dist.");
//        telemetry.addLine("PRY = Pitch, Roll & Yaw (XYZ Rotation)");
//        telemetry.addLine("RBE = Range, Bearing & Elevation");
//
//    }   // end method telemetryAprilTag()
//}
