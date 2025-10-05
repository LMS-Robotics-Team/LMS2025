package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Auto.Drive;

@com.qualcomm.robotcore.eventloop.opmode.Autonomous
public class DemoAuto extends LinearOpMode {
    @Override
    public void runOpMode() {
        // Init code, run when start button is clicked.
        Drive.init(hardwareMap);

        // Waits for the play button to be clicked.
        waitForStart();

        // Run code, run when play button is clicked.
        // Makes forward left motor move 1150 mm, forward right motor -1150mm, back left motor -1150 mm, and back right motor 0 mm at half speed.
        Drive.moveTo(1150, -1150, -1150, 0, 0.5);
    }
}
