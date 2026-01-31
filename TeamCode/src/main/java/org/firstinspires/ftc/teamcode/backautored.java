package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class backautored extends LinearOpMode {
    DcMotor shooter;
    CRServo turret;
    CRServo leftpassof;
    CRServo rightpassof;
    DcMotor intake;
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    Servo aimer;


    @Override
    public void runOpMode() throws InterruptedException {
        turret = hardwareMap.get(CRServo.class, "Turret");
        leftpassof = hardwareMap.get(CRServo.class, "leftpassof");
        rightpassof = hardwareMap.get(CRServo.class, "rightpassof");
        intake = hardwareMap.get(DcMotor.class, "intake");
        frontLeft = hardwareMap.get(DcMotor.class, "fLeft");
        frontRight = hardwareMap.get(DcMotor.class, "fRight");
        backLeft = hardwareMap.get(DcMotor.class, "bLeft");
        backRight = hardwareMap.get(DcMotor.class, "bRight");
        shooter = hardwareMap.get(DcMotor.class, "shooter");
        aimer = hardwareMap.get(Servo.class, "aimer");
        leftpassof.setDirection(CRServo.Direction.REVERSE);

        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        turret.setDirection(CRServo.Direction.REVERSE);
        waitForStart();
        shooter.setPower(1);
        frontLeft.setPower(0.5);
        frontRight.setPower(0.5);
        backRight.setPower(0.5);
        backLeft.setPower(0.5);
        sleep(200);
        frontLeft.setPower(-0.75);
        frontRight.setPower(0.75);
        backRight.setPower(-0.75);
        backLeft.setPower(0.75);
        sleep(600);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
        sleep(1500);
        leftpassof.setPower(1);
        rightpassof.setPower(1);
        intake.setPower(1);
        sleep(750);
        intake.setPower(0);
        leftpassof.setPower(0);
        rightpassof.setPower(0);
        sleep(750);
        intake.setPower(1);
        leftpassof.setPower(1);
        rightpassof.setPower(1);
        sleep(750);
        intake.setPower(0);
        leftpassof.setPower(0);
        rightpassof.setPower(0);
        sleep(750);
        intake.setPower(1);
        leftpassof.setPower(1);
        rightpassof.setPower(1);
        sleep(500);
        leftpassof.setPower(0);
        rightpassof.setPower(0);
        intake.setPower(0);
        shooter.setPower(0);
        sleep(300);
        frontLeft.setPower(0.75);
        frontRight.setPower(0.75);
        backRight.setPower(0.75);
        backLeft.setPower(0.75);
        sleep(500);
        frontLeft.setPower(0.75);
        frontRight.setPower(-0.75);
        backRight.setPower(-0.75);
        backLeft.setPower(0.75);
        sleep(600);
        intake.setPower(1);
        rightpassof.setPower(1);
        leftpassof.setPower(1);
        frontLeft.setPower(0.5);
        frontRight.setPower(0.5);
        backRight.setPower(0.5);
        backLeft.setPower(0.5);
        sleep(1800);
        frontLeft.setPower(-0.5);
        frontRight.setPower(-0.5);
        backRight.setPower(-0.5);
        backLeft.setPower(-0.5);
        intake.setPower(0);
        rightpassof.setPower(0);
        leftpassof.setPower(0);
        shooter.setPower(1);
        sleep(1800);
        frontLeft.setPower(-0.5);
        frontRight.setPower(0.5);
        backRight.setPower(0.5);
        backLeft.setPower(-0.5);
        sleep(600);
        frontLeft.setPower(-0.75);
        frontRight.setPower(-0.75);
        backRight.setPower(-0.75);
        backLeft.setPower(-0.75);
        sleep(300);
        frontLeft.setPower(0.5);
        frontRight.setPower(-0.5);
        backRight.setPower(-0.5);
        backLeft.setPower(0.5);
        sleep(150);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
        leftpassof.setPower(1);
        rightpassof.setPower(1);
        intake.setPower(1);
        sleep(750);
        intake.setPower(0);
        leftpassof.setPower(0);
        rightpassof.setPower(0);
        sleep(750);
        intake.setPower(1);
        leftpassof.setPower(1);
        rightpassof.setPower(1);
        sleep(750);
        intake.setPower(0);
        leftpassof.setPower(0);
        rightpassof.setPower(0);
        sleep(750);
        intake.setPower(1);
        leftpassof.setPower(1);
        rightpassof.setPower(1);
        sleep(500);
        leftpassof.setPower(0);
        rightpassof.setPower(0);
        intake.setPower(0);
        frontLeft.setPower(0.5);
        frontRight.setPower(0.5);
        backRight.setPower(0.5);
        backLeft.setPower(0.5);
        sleep(500);
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);





    }
}

