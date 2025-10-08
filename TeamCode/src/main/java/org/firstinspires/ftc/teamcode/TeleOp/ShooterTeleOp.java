package org.firstinspires.ftc.teamcode.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp(name="ShooterTeleOp", group="Concept")
public class ShooterTeleOp extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

    }
    // Declare OpMode members.

    private static DcMotor shooterMotor1 = null;
    private static DcMotor shooterMotor2 = null;

    public static void init(HardwareMap hardwareMap) {

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during robot configuration.
        shooterMotor1 = hardwareMap.get(DcMotor.class, "shooterMotor1");
        shooterMotor2 = hardwareMap.get(DcMotor.class, "shooterMotor2");

        // Most robots need the motors to be reversed. You will need to determine which motor
        // to reverse based on your robot's physical configuration.
        shooterMotor1.setDirection(DcMotorSimple.Direction.FORWARD);
        shooterMotor2.setDirection(DcMotorSimple.Direction.REVERSE); // Adjust as needed

        // Set motor modes
        shooterMotor1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        shooterMotor2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Wait for the game to start (driver presses PLAY)
        //telemetry.addData("Status", "Running");
        // telemetry.update();

        // Run until the end of the match (driver presses STOP)
    }
    public static void handleInput(Gamepad gamepad1) {
        // Control the shooter motors with a gamepad button (e.g., gamepad1.a)
        if (gamepad1.b) {
            // Set power to the shooter motors (adjust power level as needed)
            shooterMotor1.setPower(0.8); // Example power level
            shooterMotor2.setPower(0.8); // Example power level
        } else {
            // Stop the shooter motors when the button is not pressed
            shooterMotor1.setPower(0.0);
            shooterMotor2.setPower(0.0);
        }

        // You can add more complex controls, such as variable speed based on joystick input
        // For example, using gamepad1.right_trigger for variable power:
        // double shooterPower = gamepad1.right_trigger;
        // shooterMotor1.setPower(shooterPower);
        // shooterMotor2.setPower(shooterPower);

        //telemetry.addData("Shooter Motor 1 Power", shooterMotor1.getPower());
        //telemetry.addData("Shooter Motor 2 Power", shooterMotor2.getPower());
        //telemetry.update();
    }
}