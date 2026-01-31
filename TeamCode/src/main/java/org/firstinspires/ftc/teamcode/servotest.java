package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;

public class servotest extends LinearOpMode {

    CRServo rightpassof;
    CRServo  leftpassof;
    public void runOpMode() {
        leftpassof = hardwareMap.get(CRServo.class, "leftpassof");
        rightpassof = hardwareMap.get(CRServo.class, "rightpassof");

        if(gamepad1.right_bumper) {
            leftpassof.setPower(1);
            rightpassof.setPower(1);
        } else {
            leftpassof.setPower(0);
            rightpassof.setPower(0);
        }

    }



}
