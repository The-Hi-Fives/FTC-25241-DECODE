package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@Autonomous
public class auto2 extends LinearOpMode {
    DcMotor shooter;
    CRServo turret;
    CRServo leftpassof;
    CRServo rightpassof;
    DcMotor intake;
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    CRServo aimer;
    public void runOpMode() {


        turret = hardwareMap.get(CRServo.class,"Turret");
        leftpassof = hardwareMap.get(CRServo.class, "leftpassof");
        rightpassof = hardwareMap.get(CRServo.class, "rightpassof");
        intake = hardwareMap.get(DcMotor.class, "intake");
        frontLeft = hardwareMap.get(DcMotor.class, "fLeft");
        frontRight = hardwareMap.get(DcMotor.class, "fRight");
        backLeft = hardwareMap.get(DcMotor.class, "bLeft");
        backRight = hardwareMap.get(DcMotor.class, "bRight");
        shooter = hardwareMap.get(DcMotor.class, "shooter");
        aimer = hardwareMap.get(CRServo.class,"aimer");
        leftpassof.setDirection(CRServo.Direction.REVERSE);
        intake.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        turret.setDirection(CRServo.Direction.REVERSE);

        shooter.setPower(1);
        frontLeft.setPower(-1);
        frontRight.setPower(-1);
        backRight.setPower(-1);
        backLeft.setPower(-1);
        sleep(500);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
        intake.setPower(1);
        leftpassof.setPower(1);
        rightpassof.setPower(1);
        sleep(550);
        intake.setPower(0);
        leftpassof.setPower(0);
        rightpassof.setPower(0);
        sleep(350);
        intake.setPower(1);
        leftpassof.setPower(1);
        rightpassof.setPower(1);
        sleep(350);
        intake.setPower(0);
        leftpassof.setPower(0);
        rightpassof.setPower(0);
       sleep(350);
        intake.setPower(1);
        leftpassof.setPower(1);
        rightpassof.setPower(1);
        sleep(350);
        intake.setPower(0);
        leftpassof.setPower(0);
        rightpassof.setPower(0);
        sleep(350);
        intake.setPower(1);
        leftpassof.setPower(1);
        rightpassof.setPower(1);
        frontLeft.setPower(1);
        frontRight.setPower(1);
        backRight.setPower(1);
        backLeft.setPower(1);
        sleep(400);
        shooter.setPower(0);
        frontLeft.setPower(0.6);
        frontRight.setPower(-0.6);
        backRight.setPower(-0.6);
        backLeft.setPower(0.6);
        sleep(750);
        frontLeft.setPower(1);
        frontRight.setPower(1);
        backRight.setPower(1);
        backLeft.setPower(1);
        sleep(1000);
        frontLeft.setPower(-1);
        frontRight.setPower(-1);
        backRight.setPower(-1);
        backLeft.setPower(-1);
        sleep(1000);
        shooter.setPower(1);
        frontLeft.setPower(-0.6);
        frontRight.setPower(0.6);
        backRight.setPower(0.6);
        backLeft.setPower(-0.6);
        sleep(750);
        frontLeft.setPower(1);
        frontRight.setPower(1);
        backRight.setPower(1);
        backLeft.setPower(1);
        sleep(400);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
        intake.setPower(1);
        leftpassof.setPower(1);
        rightpassof.setPower(1);
        sleep(550);
        intake.setPower(0);
        leftpassof.setPower(0);
        rightpassof.setPower(0);
        sleep(350);
        intake.setPower(1);
        leftpassof.setPower(1);
        rightpassof.setPower(1);
        sleep(350);
        intake.setPower(0);
        leftpassof.setPower(0);
        rightpassof.setPower(0);
        sleep(350);
        intake.setPower(1);
        leftpassof.setPower(1);
        rightpassof.setPower(1);
        sleep(350);
        intake.setPower(0);
        leftpassof.setPower(0);
        rightpassof.setPower(0);
        sleep(350);
        intake.setPower(0);
        leftpassof.setPower(0);
        rightpassof.setPower(0);
        shooter.setPower(0);







    }
}