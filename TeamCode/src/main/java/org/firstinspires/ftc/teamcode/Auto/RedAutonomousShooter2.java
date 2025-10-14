package org.firstinspires.ftc.teamcode.Auto;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="Basic Autonomous Red2", group="Concept")
public class RedAutonomousShooter2 extends LinearOpMode {

    // Declare OpMode members.
    private DcMotor frontLeftMotor = null;
    private DcMotor frontRightMotor = null;
    private DcMotor backLeftMotor = null;
    private DcMotor backRightMotor = null;
    private DcMotor shooterMotor1 = null;
    private DcMotor shooterMotor2 = null;
    private Servo shooterServo1 = null;
    private Servo shooterServo2 = null;

    // Constants for robot movement
    static final double DRIVE_SPEED = 0.5;
    static final double TURN_SPEED = 0.4;
    static final double SHOOTER_POWER = 1.0;
    static final double SERVO_OPEN_POSITION = 0.30; // Adjust as needed
    static final double SERVO_CLOSED_POSITION = 0.5; // Adjust as needed

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Initialize the hardware variables.
        frontLeftMotor = hardwareMap.get(DcMotor.class, "driveMotorFL");
        frontRightMotor = hardwareMap.get(DcMotor.class, "driveMotorFR");
        backLeftMotor = hardwareMap.get(DcMotor.class, "driveMotorBL");
        backRightMotor = hardwareMap.get(DcMotor.class, "driveMotorBR");
        shooterMotor1 = hardwareMap.get(DcMotor.class, "shooter_motor_1");
        shooterMotor2 = hardwareMap.get(DcMotor.class, "shooter_motor_2");
        shooterServo1 = hardwareMap.get(Servo.class, "aimer_servo");
        shooterServo2 = hardwareMap.get(Servo.class, "loader_servo");

        // Most robots need the motor on one side to be reversed to drive forward.
        frontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        backRightMotor.setDirection(DcMotor.Direction.FORWARD);
        shooterMotor1.setDirection(DcMotor.Direction.REVERSE);
        shooterMotor2.setDirection(DcMotor.Direction.FORWARD);
        shooterServo1.setDirection(Servo.Direction.FORWARD);
        shooterServo2.setDirection(Servo.Direction.REVERSE);

        // Set motor modes
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        shooterMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        shooterMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        shooterServo1.setPosition(SERVO_CLOSED_POSITION);
        shooterServo2.setPosition(SERVO_CLOSED_POSITION);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Step 1: Drive straight forward for a few millimeters (adjust time as needed)
        driveStraight(DRIVE_SPEED, 5); // Drive for 1 second
        stopRobot();

        // Step 2: Turn right (adjust time as needed)
        turnRight(TURN_SPEED, 0.8); // Turn for 0.8 seconds
        stopRobot();

        // Step 3: Drive straight forward for a few millimeters (adjust time as needed)
        //driveStraight(DRIVE_SPEED, 1.5); // Drive for 1.5 seconds
        //stopRobot();

        // Step 4: Activate shooter mechanism
        activateShooter();
        sleep(6000); // Allow shooter to operate for 6 seconds
        //deactivateShooter();
        stopRobot();

        telemetry.addData("Status", "Complete");
        telemetry.update();
    }

    // Helper method to drive straight
    public void driveStraight(double speed, double time) {
        frontLeftMotor.setPower(speed);
        frontRightMotor.setPower(speed);
        backLeftMotor.setPower(speed);
        backRightMotor.setPower(speed);
        sleep((long) (time * 1000));
    }

    // Helper method to turn right
    public void turnRight(double speed, double time) {
        frontLeftMotor.setPower(speed);
        backLeftMotor.setPower(speed);
        frontRightMotor.setPower(-speed);
        backRightMotor.setPower(-speed);
        sleep((long) (time * 1000));
    }

    // Helper method to stop the robot
    public void stopRobot() {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }

    // Helper method to activate shooter
    public void activateShooter() {
        shooterMotor1.setPower(SHOOTER_POWER);
        shooterMotor2.setPower(SHOOTER_POWER);
        shooterServo1.setPosition(SERVO_OPEN_POSITION);
        shooterServo2.setPosition(SERVO_OPEN_POSITION);
    }

    // Helper method to deactivate shooter
    public void deactivateShooter() {
        shooterMotor1.setPower(0);
        shooterMotor2.setPower(0);
        shooterServo1.setPosition(SERVO_CLOSED_POSITION);
        shooterServo2.setPosition(SERVO_CLOSED_POSITION);
    }
}