package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;


import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp(name = "testMainCode", group = "Robot")
public class testMainCode {
    CRServo aimer;
    public void init() throws InterruptedException {
        CRServo turret = hardwareMap.get(CRServo.class,"Turret");
        CRServo leftpassof = hardwareMap.get(CRServo.class, "leftpassof");
        CRServo rightpassof = hardwareMap.get(CRServo.class, "rightpassof");
        DcMotor intake = hardwareMap.get(DcMotor.class, "intake");
        DcMotor frontLeft = hardwareMap.get(DcMotor.class, "fLeft");
        DcMotor frontRight = hardwareMap.get(DcMotor.class, "fRight");
        DcMotor backLeft = hardwareMap.get(DcMotor.class, "bLeft");
        DcMotor backRight = hardwareMap.get(DcMotor.class, "bRight");
        aimer = hardwareMap.get(CRServo.class, "aimer");


        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

        while (OpModeIsActive()) {
            double forward = - gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;
            double denominator = Math.max(Math.abs(forward)+Math.abs(strafe)+Math.abs(turn),1);
            if (gamepad1.x) {
                forward /= 2;
                strafe /= 2;
                turn /= 2;
            }

            frontRight.setPower((forward - strafe - turn)/ denominator);
            frontLeft.setPower((forward + strafe + turn)/ denominator);
            backLeft.setPower((forward - strafe + turn)/ denominator);
            backRight.setPower((forward + strafe + turn)/ denominator);
            turret.setPower(gamepad2.left_stick_x);

            if(gamepad2.left_bumper) {
                leftpassof.setPower(1);
                rightpassof.setPower(1);
            } else {
                leftpassof.setPower(0);
                rightpassof.setPower(0);
            }
            if(gamepad1.right_bumper) {
                intake.setPower(1);
            }else{
                intake.setPower(0);
            }
            if(gamepad2.y) {
                aimer.setPower(1);
                sleep(300);
                aimer.setPower(0);
            }
            if(gamepad2.x){
                aimer.setPower(1);
                sleep(200);
                aimer.setPower(0);
            }
            if(gamepad2.b){
            aimer.setPower(-1);
            sleep(200);
            aimer.setPower(0);
            }
            if(gamepad2.a){
                aimer.setPower(-1);
                sleep(300);
                aimer.setPower(0);
            }


        }



    }

    private boolean OpModeIsActive() {

        return false;
    }

}

