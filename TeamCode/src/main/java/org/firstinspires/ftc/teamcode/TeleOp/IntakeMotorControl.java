package org.firstinspires.ftc.teamcode.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple; // For setting direction
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp(name="IntakeMotorControl", group="Linear OpMode")

public class IntakeMotorControl extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

    }
    // Declare motor variable
    private static DcMotor intakeMotor = null;

    public static void init(HardwareMap hardwareMap) {

        intakeMotor = hardwareMap.get(DcMotor.class, "intake_motor");


        intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);


        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        }

        public static void handleInput(Gamepad gamepad1) {


        if (gamepad1.x) {

            intakeMotor.setPower(1.0);
        } else if (gamepad1.y) {

            intakeMotor.setPower(-1.0);
        } else {

            intakeMotor.setPower(0.0);
        }
}

}
