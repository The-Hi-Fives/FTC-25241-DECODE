package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class auto1 extends LinearOpMode {
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
                backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
                turret.setDirection(CRServo.Direction.REVERSE);

                frontLeft.setPower(-1);
                frontRight.setPower(-1);
                backRight.setPower(-1);
                backLeft.setPower(-1);
                sleep(1500);
                frontLeft.setPower(0);
                frontRight.setPower(0);
                backRight.setPower(0);
                backLeft.setPower(0);

            }
}
