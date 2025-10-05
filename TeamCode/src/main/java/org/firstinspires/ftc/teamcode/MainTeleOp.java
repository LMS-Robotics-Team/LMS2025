package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.TeleOp.Drive;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class MainTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() {
        // Init code, run when start button is clicked.
        Drive.init(hardwareMap);

        // Waits for the play button to be clicked.
        waitForStart();

        // Repeatedly runs game code while op mode is still running.
        while (opModeIsActive()) {
            Drive.handleInput(gamepad1);
        }
    }
}
