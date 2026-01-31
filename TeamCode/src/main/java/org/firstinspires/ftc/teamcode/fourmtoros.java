package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Robot: Field Relative four motors Drive", group = "Robot")
public class fourmtoros {
    public void init() {
        DcMotor frontLeft = hardwareMap.get(DcMotor.class, "fLeft");
        DcMotor frontRight = hardwareMap.get(DcMotor.class, "fRight");
        DcMotor backLeft = hardwareMap.get(DcMotor.class, "bLeft");
        DcMotor backRight = hardwareMap.get(DcMotor.class, "bRight");
        DcMotor launcher = hardwareMap.get(DcMotor.class, "launcher");
        CRServo rightservo = hardwareMap.get(CRServo.class,"rightServo");
        CRServo Leftservo = hardwareMap.get(CRServo.class,"leftServo");
        Leftservo.setDirection(CRServo.Direction.REVERSE);



        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

         while (OpModeIsActive()) {
         double forward = - gamepad1.left_stick_y;
         double strafe = gamepad1.left_stick_x;
         double turn = gamepad1.right_stick_x;
             if (gamepad1.right_bumper) {
             forward /= 2;
             strafe /= 2;
             turn /= 2;
             }
         double denominator = Math.max(Math.abs(forward)+Math.abs(strafe)+Math.abs(turn),1);

            frontRight.setPower((forward - strafe - turn)/ denominator);
            frontLeft.setPower((forward + strafe + turn)/ denominator);
            backLeft.setPower((forward - strafe + turn)/ denominator);
            backRight.setPower((forward + strafe + turn)/ denominator);
             if(gamepad2.left_bumper) {
                 launcher.setPower(0.45);
             } else {
                 launcher.setPower(0);
             }
             if(gamepad2.right_bumper) {
                 rightservo.setPower(0.5);
                 Leftservo.setPower(0.5);
             } else {
                 rightservo.setPower(0);
                 Leftservo.setPower(0);
             }




        }



    }

    private boolean OpModeIsActive() {

        return false;
    }

}
