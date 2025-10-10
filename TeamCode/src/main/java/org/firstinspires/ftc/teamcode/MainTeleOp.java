package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.TeleOp.BasicShooter;
import org.firstinspires.ftc.teamcode.TeleOp.Drive;
import org.firstinspires.ftc.teamcode.TeleOp.IntakeMotorControl;
import org.firstinspires.ftc.teamcode.TeleOp.ShooterTeleOp;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class MainTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() {
        // Init code, run when start button is clicked.
        Drive.init(hardwareMap);
        IntakeMotorControl.init(hardwareMap);
       // ShooterTeleOp.init(hardwareMap);
        BasicShooter.init(hardwareMap);
        // Waits for the play button to be clicked.
        waitForStart();

        // Repeatedly runs game code while op mode is still running.
        while (opModeIsActive()) {
            Drive.handleInput(gamepad1);
            IntakeMotorControl.handleInput(gamepad2);
          //  ShooterTeleOp.handleInput(gamepad1);
            BasicShooter.handleInput(gamepad2);
        }
    }
}
