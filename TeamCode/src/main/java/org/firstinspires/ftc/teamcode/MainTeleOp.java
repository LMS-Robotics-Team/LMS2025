package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.TeleOp.BasicShooter;
import org.firstinspires.ftc.teamcode.TeleOp.Drive;
import org.firstinspires.ftc.teamcode.TeleOp.IntakeMotorControl;
import org.firstinspires.ftc.teamcode.TeleOp.ShooterTeleOp;
//import com.qualcomm.robotcore.hardware.HuskyLens; // Import the HuskyLens class
import com.qualcomm.hardware.dfrobot.HuskyLens;
import com.qualcomm.robotcore.hardware.HardwareMap;
import java.util.ArrayList;
import java.util.List;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class MainTeleOp extends LinearOpMode {

    private HuskyLens huskyLens;

    @Override
    public void runOpMode() {

        // Initialize the HuskyLens using the hardwareMap
        huskyLens = hardwareMap.get(HuskyLens.class, "huskylens"); // "huskylens" must match the name in your configuration

        // Init code, run when start button is clicked.
        Drive.init(hardwareMap);
        IntakeMotorControl.init(hardwareMap);
        // ShooterTeleOp.init(hardwareMap);
        BasicShooter.init(hardwareMap);


        // Set the HuskyLens algorithm to QR Recognition
        huskyLens.selectAlgorithm(HuskyLens.Algorithm.TAG_RECOGNITION);
        telemetry.addData(">> Status:", "HuskyLens ready and set to QR Recognition");
        telemetry.update();
        // Waits for the play button to be clicked.
        waitForStart();

        // Repeatedly runs game code while op mode is still running.
        while (opModeIsActive()) {
            // Request data from the HuskyLens
            HuskyLens.Block[] blocks = huskyLens.blocks();

            // Check if any QR codes are detected
            if (blocks.length > 0) {
                // Iterate over all detected blocks
                for (int i = 0; i < blocks.length; i++) {
                    // In QR recognition mode, the "tag" or "ID" actually contains the QR code data itself
                     int qrData = blocks[i].id;
                    telemetry.addData("QR Code Detected:", "ID%d: %s", i + 1, qrData);
                    telemetry.addData("Position (X, Y):", "%d, %d", blocks[i].x, blocks[i].y);
                }
            } else {
                telemetry.addData("Status:", "No QR code detected");
            }

            // Update the telemetry display on the Driver Station
            telemetry.update();

            // Optional: add a small delay to prevent spamming the I2C bus too quickly
            sleep(50);

            Drive.handleInput(gamepad1);
            IntakeMotorControl.handleInput(gamepad2);
            //  ShooterTeleOp.handleInput(gamepad1);
            BasicShooter.handleInput(gamepad2);
        }
    }
}