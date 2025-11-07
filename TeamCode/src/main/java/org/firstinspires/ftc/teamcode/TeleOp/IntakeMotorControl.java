package org.firstinspires.ftc.teamcode.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple; // For setting direction
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="IntakeMotorControl", group="Linear OpMode")

public class IntakeMotorControl extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

    }

    // Declare motor variable
    private static DcMotor intakeMotor = null;
    private static DcMotor intakeRotor = null;
   // private static Servo intakeServo = null;

    public static void init(HardwareMap hardwareMap) {

        intakeMotor = hardwareMap.get(DcMotor.class, "intake_rotor");
       // intakeServo = hardwareMap.get(Servo.class, "intake_servo");
        intakeRotor = hardwareMap.get(DcMotor.class, "intake_motor");

        intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        intakeRotor.setDirection(DcMotorSimple.Direction.FORWARD);

        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeRotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeRotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //intakeServo.setDirection(Servo.Direction.FORWARD);


    }

    public static void handleInput(Gamepad gamepad2) {


        if (gamepad2.x) {

            intakeMotor.setPower(0.2);
        } else if (gamepad2.y) {

            intakeMotor.setPower(0.5);
        }

        else {

            intakeMotor.setPower(0.0);
        }
        //double triggerValue = gamepad2.right_trigger;
        //double servoPosition = triggerValue;
        //intakeServo.setPosition(servoPosition);
        if (gamepad2.a) {

            intakeRotor.setPower(0.56);
        }
        else if (gamepad2.b) {
            intakeRotor.setPower(-0.5);
        } else {
            intakeRotor.setPower(0.0);

        }
    }
}

