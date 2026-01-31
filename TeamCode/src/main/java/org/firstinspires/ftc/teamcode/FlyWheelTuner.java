package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


public class FlyWheelTuner extends OpMode {
    DcMotor leftshooter;
    DcMotor rightshooter;
    public double highvelocity=1500;
    public double lowvelocity=900;
    @Override
    public void init(){
        leftshooter = hardwareMap.get(DcMotor.class, "leftshooter");
        rightshooter = hardwareMap.get(DcMotor.class, "rightshooter");

    }
    @Override
    public void loop(){

    }
}
