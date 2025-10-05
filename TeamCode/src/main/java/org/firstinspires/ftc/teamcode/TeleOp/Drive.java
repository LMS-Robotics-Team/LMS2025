package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive {
    private static DcMotor motorFL, motorFR, motorBL, motorBR;
    private static final double SLOW_SPEED = 0.5, NORMAL_SPEED = 1;

    // Inits the drive system in brake mode, ready to move.
    public static void init(HardwareMap hardwareMap) {
        motorFL = hardwareMap.get(DcMotor.class, "driveMotorFL");
        motorFR = hardwareMap.get(DcMotor.class, "driveMotorFR");
        motorBL = hardwareMap.get(DcMotor.class, "driveMotorBL");
        motorBR = hardwareMap.get(DcMotor.class, "driveMotorBR");

        motorFL.setDirection(DcMotor.Direction.REVERSE);
        motorBL.setDirection(DcMotor.Direction.REVERSE);
        motorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    // Ran every tick, moves the robot based on gamepad1.
    public static void handleInput(Gamepad gamepad1) {
        double forwardBackward = -gamepad1.left_stick_y;
        double leftRight = gamepad1.right_stick_x;
        double rotate = gamepad1.right_trigger - gamepad1.left_trigger;

        double scale = gamepad1.a ? SLOW_SPEED : NORMAL_SPEED;
        double powerFL = scale * (forwardBackward + leftRight + rotate);
        double powerFR = scale * (forwardBackward - leftRight - rotate);
        double powerBL = scale * (forwardBackward - leftRight + rotate);
        double powerBR = scale * (forwardBackward + leftRight - rotate);

        motorFL.setPower(powerFL);
        motorFR.setPower(powerFR);
        motorBL.setPower(powerBL);
        motorBR.setPower(powerBR);
    }
}