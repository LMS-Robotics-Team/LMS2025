package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
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
    //private static final double AIM_UP_POSITION = 0.5;
    //private static final double AIM_DOWN_POSITION = 0.3;
    //private static final double LOADER_LOAD_POSITION = 0.5;
    //private static final double LOADER_RELEASE_POSITION = 0.3;
    private static final double POSITION_ZERO = 0.5; // Example position 0
    private static final double POSITION_ONE = 0.38; // Example position 1
    private static final double POSITION_TWO = 0.3; // Example position 2 (middle)
    private static final double POSITION_THREE = 0.25; // Example position 3

    public static void init(HardwareMap hardwareMap) {
        // Initialize hardware
        shooterMotor1 = hardwareMap.get(DcMotor.class, "shooter_motor_1");
        shooterMotor2 = hardwareMap.get(DcMotor.class, "shooter_motor_2");
        aimerServo = hardwareMap.get(Servo.class, "aimer_servo");
        loaderServo = hardwareMap.get(Servo.class, "loader_servo");

        // Set motor and servo directions (adjust based on your robot's wiring)
        shooterMotor1.setDirection(DcMotor.Direction.REVERSE);
        shooterMotor2.setDirection(DcMotor.Direction.FORWARD); // Or FORWARD if both motors spin same way
        aimerServo.setDirection(Servo.Direction.FORWARD);
        loaderServo.setDirection(Servo.Direction.REVERSE);

        // Set motor zero power behavior
        shooterMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        shooterMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Initial servo positions

        aimerServo.setPosition(POSITION_ZERO);
        loaderServo.setPosition(POSITION_ZERO);
    }

    public static void handleInput(Gamepad gamepad2) {
        if (gamepad2.left_bumper) {
            shooterMotor1.setPower(0.75); // Full power
            shooterMotor2.setPower(0.75);
        } else if (gamepad2.right_bumper){
                shooterMotor1.setPower(1.0); // Full power
                shooterMotor2.setPower(1.0);
            }
        else{
            shooterMotor1.setPower(0.0);
            shooterMotor2.setPower(0.0);
        }


        // Aimer servo control
        //if (gamepad1.left_bumper) {
        //    aimerServo.setPosition(AIM_UP_POSITION);
         //   loaderServo.setPosition(LOADER_LOAD_POSITION);
       //  else {if (gamepad1.dpad_down) {
        //    aimerServo.setPosition(AIM_DOWN_POSITION);
        //    loaderServo.setPosition(LOADER_RELEASE_POSITION);
        //
        if (gamepad2.b) {
            // Set servos to Position 1
            aimerServo.setPosition(POSITION_ONE);
            loaderServo.setPosition(POSITION_ONE);
            //telemetry.addData("Servos", "Set to Position 1");
            //telemetry.update();
            //sleep(200); // Small delay to prevent rapid input
        //} else if (gamepad2.a) {
            // Set servos to Position 2
            //aimerServo.setPosition(POSITION_TWO);
            //loaderServo.setPosition(POSITION_TWO);
            //telemetry.addData("Servos", "Set to Position 2");
            //telemetry.update();
            //sleep(200);
        }
        //else if (gamepad2.y) {
            // Set servos to Position 3
          //  aimerServo.setPosition(POSITION_THREE);
            //loaderServo.setPosition(POSITION_THREE);
            //telemetry.addData("Servos", "Set to Position 3");
            //telemetry.update();
            //sleep(200);

        else {
            aimerServo.setPosition(0.5);
            loaderServo.setPosition(0.5);
        }
    }
}
