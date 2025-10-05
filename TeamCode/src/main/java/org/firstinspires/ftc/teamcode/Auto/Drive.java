package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Drive {
    private static DcMotor motorFL, motorFR, motorBL, motorBR;

    // Inits the drive system in brake mode, ready to take input with encoders.
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
        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    // Sets the mode of all motors.
    private static void setMode(DcMotor.RunMode mode) {
        motorFL.setMode(mode);
        motorFR.setMode(mode);
        motorBL.setMode(mode);
        motorBR.setMode(mode);
    }

    // Converts millimeters into the correct encoder ticks.
    private static int mm2Ticks(int mm) {
        /*
            Formula:
            (mm * Gear Ratio * Motor Ticks per Revolution) / (Wheel Circumference in mm)

            Values:
            return (int) Math.round((mm * 2 * 384.5) / (Math.PI * 96));

            Simplified:
            return (int) Math.round(mm * 2.54979481745);
        */

        return (int) Math.round(mm * 2.549795);
    }

    // Moves each motor the specifiec amount with the specified speed.
    public static void moveTo(int motorFLMM, int motorFRMM, int motorBLMM, int motorBRMM, double speed) {
        if (speed < 0) {
            throw new IllegalArgumentException("Speed cannot be negative");
        }

        motorFL.setTargetPosition(mm2Ticks(motorFLMM));
        motorFR.setTargetPosition(mm2Ticks(motorFRMM));
        motorBL.setTargetPosition(mm2Ticks(motorBLMM));
        motorBR.setTargetPosition(mm2Ticks(motorBRMM));
        motorFL.setPower(speed);
        motorFR.setPower(speed);
        motorBL.setPower(speed);
        motorBR.setPower(speed);

        setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (motorFL.isBusy() || motorFR.isBusy() || motorBL.isBusy() || motorBR.isBusy()) {
            // Intentional
        }

        setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
}