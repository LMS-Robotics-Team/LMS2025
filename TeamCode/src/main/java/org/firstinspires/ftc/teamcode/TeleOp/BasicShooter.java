package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
@TeleOp(name="BasicShooter", group="FTC")
public class BasicShooter extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

    }

    private static DcMotor shooterMotor1 = null;
    private static DcMotor shooterMotor2 = null;
    private static Servo aimerServo = null;
    private static Servo loaderServo = null;

    // Servo positions (example values, adjust as needed)
    private static final double AIM_UP_POSITION = 0.8;
    private static final double AIM_DOWN_POSITION = 0.2;
    private static final double LOADER_LOAD_POSITION = 0.8;
    private static final double LOADER_RELEASE_POSITION = 0.2;

    public static void init(HardwareMap hardwareMap) {
        // Initialize hardware
        shooterMotor1 = hardwareMap.get(DcMotor.class, "shooter_motor_1");
        shooterMotor2 = hardwareMap.get(DcMotor.class, "shooter_motor_2");
        aimerServo = hardwareMap.get(Servo.class, "aimer_servo");
        loaderServo = hardwareMap.get(Servo.class, "loader_servo");

        // Set motor directions (adjust based on your robot's wiring)
        shooterMotor1.setDirection(DcMotor.Direction.FORWARD);
        shooterMotor2.setDirection(DcMotor.Direction.REVERSE); // Or FORWARD if both motors spin same way

        // Set motor zero power behavior
        shooterMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        shooterMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Initial servo positions
        aimerServo.setPosition(AIM_DOWN_POSITION);
        loaderServo.setPosition(LOADER_RELEASE_POSITION);
    }

    public static void handleInput(Gamepad gamepad1) {
        if (gamepad1.right_bumper) {
            shooterMotor1.setPower(1.0); // Full power
            shooterMotor2.setPower(1.0);
        } else {
            shooterMotor1.setPower(0.0);
            shooterMotor2.setPower(0.0);
        }

        // Aimer servo control
        if (gamepad1.dpad_up) {
            aimerServo.setPosition(AIM_UP_POSITION);
            loaderServo.setPosition(LOADER_LOAD_POSITION);
        } else {//if (gamepad1.dpad_down) {
            aimerServo.setPosition(AIM_DOWN_POSITION);
            loaderServo.setPosition(LOADER_RELEASE_POSITION);
        }

        // Loader servo control
       // if (gamepad1.left_bumper) {

        //} else {

        //}
    }
}
