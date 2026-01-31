package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class MainCode222 extends LinearOpMode{

    DcMotor rightshooter;
    DcMotor leftShooter;
    CRServo Turret;
    CRServo leftpassof;
    CRServo rightpassof;
    DcMotor intake;
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    Servo aimer;
    public void runOpMode(){
        waitForStart();
        Turret = hardwareMap.get(CRServo.class,"Turret");
        leftpassof = hardwareMap.get(CRServo.class, "leftpassof");
        rightpassof = hardwareMap.get(CRServo.class, "rightpassof");
        intake = hardwareMap.get(DcMotor.class, "intake");
        frontLeft = hardwareMap.get(DcMotor.class, "fLeft");
        frontRight = hardwareMap.get(DcMotor.class, "fRight");
        backLeft = hardwareMap.get(DcMotor.class, "bLeft");
        backRight = hardwareMap.get(DcMotor.class, "bRight");
        rightshooter = hardwareMap.get(DcMotor.class, "rightshooter");
        leftShooter = hardwareMap.get(DcMotor.class, "leftshooter");
        aimer = hardwareMap.get(Servo.class, "aimer");
        leftpassof.setDirection(CRServo.Direction.REVERSE);

        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        Turret.setDirection(CRServo.Direction.REVERSE);
        aimer.setDirection(Servo.Direction.REVERSE);

        while (OpModeIsActive()) {
            double forward = - gamepad1.left_stick_y;
            double strafe = gamepad1.left_stick_x;
            double turn = gamepad1.right_stick_x;
            double denominator = Math.max(Math.abs(forward)+Math.abs(strafe)+Math.abs(turn),1);

            if (gamepad1.left_bumper) {
                forward /= 2;
                strafe /= 2;
                turn /= 2;
            }

            frontRight.setPower((forward - strafe - turn)/ denominator);
            frontLeft.setPower((forward + strafe + turn)/ denominator);
            backLeft.setPower((forward - strafe + turn)/ denominator);
            backRight.setPower((forward+ strafe-turn)/denominator);
                Turret.setPower((gamepad2.left_stick_x) / 2);



            if(gamepad2.a) {
                leftpassof.setPower(1);
                rightpassof.setPower(1);
            } else {
                leftpassof.setPower(0);
                rightpassof.setPower(0);
            }
            if(gamepad2.left_bumper) {
                intake.setPower(1);
            }else{
                intake.setPower(0);
            }
            //hello


            if(gamepad2.right_bumper) {
                leftShooter.setPower(1);
                rightshooter.setPower(1);
            }else{
                leftShooter.setPower(0);
                rightshooter.setPower(0);
            }
            if(gamepad1.dpad_left){
                aimer.setPosition(0.98);
            }
            if(gamepad1.dpad_up){
                aimer.setPosition(0.88);
            }
            if(gamepad1.dpad_right){
                aimer.setPosition(0.75);
            }
            if(gamepad1.dpad_down) {
                aimer.setPosition(0.67);
            }






        }



    }

    private boolean OpModeIsActive() {
        return true;
    }


}
