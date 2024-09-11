package org.firstinspires.ftc.teamcode.Previous.Outdated_CenterStage.Our.Autonomous;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

@Autonomous(name="BFAuto", group="Linear OpMode")

@Disabled
public class ZBFAuto extends LinearOpMode {

    //Motor and Servo Assignment
    private DcMotor BACK_R;
    private DcMotor FRONT_L;
    private DcMotor FRONT_R;
    private DcMotor BACK_L;
    private Servo claw;
    //private Servo claw2;
    private DcMotor shoulder;

    //Sensors
    private IMU imu_IMU;
    private DistanceSensor distance;

    //Speed Variable
    float Speed_Movement_Multiplier;

    //Wheel variables influenced by IMU
    AngularVelocity Angular_Velocity;
    YawPitchRollAngles Orientation2;
    double Gyro_Degrees;
    double Gyro_Radians;

    // Shoulder Variables
    double shoulderStick;
    int shoulder_Position;
    int PixelLevel = 1;
    int ShoulderLevel;

    //Encoder Movement
    double DistanceInCM;
    double circumference = Math.PI * 9.6;
    double WheelSpeed;
    int StepNum = 1;

    //IMU influenced Turn/Yaw
    int Angle;

    //Distance Sensor
    double DistanceSensor;

    private void InitialSetup () {

        Speed_Movement_Multiplier = 0.4f;
        Angle = 0;

        //Wheel Setup
        BACK_L = hardwareMap.get(DcMotor.class, "BACK_L");
        BACK_R = hardwareMap.get(DcMotor.class, "BACK_R");
        FRONT_L = hardwareMap.get(DcMotor.class, "FRONT_L");
        FRONT_R = hardwareMap.get(DcMotor.class, "FRONT_R");
        shoulder = hardwareMap. get(DcMotor.class, "shoulder");
        claw = hardwareMap. get(Servo.class, "claw");
        //claw2 = hardwareMap.get(Servo.class, "claw2");
        imu_IMU = hardwareMap.get(IMU.class, "imu");
        distance = hardwareMap.get(DistanceSensor.class, "distance");
        claw.scaleRange(0, 1);
        //claw2.scaleRange(0,1);
        //claw2.setPosition(1);
        claw.setPosition(1);

        FRONT_R.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        FRONT_L.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BACK_R.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        BACK_L.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shoulder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        FRONT_R.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FRONT_L.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BACK_R.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BACK_L.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        shoulder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


    }
    private void IMU () {

        //Imu Initialize and Reset
        imu_IMU.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.FORWARD)));
        imu_IMU.resetYaw();
    }

    private void MoveForward () {

        double rotations = DistanceInCM/circumference;
        int encoderTarget = (int) (rotations *537.6);

        FRONT_R.setTargetPosition(encoderTarget);
        FRONT_L.setTargetPosition(encoderTarget);
        BACK_R.setTargetPosition(encoderTarget);
        BACK_L.setTargetPosition(encoderTarget);

        FRONT_R.setPower(WheelSpeed);
        FRONT_L.setPower(WheelSpeed);
        BACK_R.setPower(WheelSpeed);
        BACK_L.setPower(WheelSpeed);

        FRONT_R.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FRONT_L.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BACK_R.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BACK_L.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }
    private void ReleasePurplePixel () {
        claw.setPosition(0);
    }
    /*

    private void ReleaseYellowPixel () {
        claw2.setPosition(0);
    }

    */
    private void MoveRight () {

        double rotations = DistanceInCM/circumference;
        int encoderTarget = (int) (rotations *537.6);

        FRONT_R.setTargetPosition(encoderTarget);
        FRONT_L.setTargetPosition(-encoderTarget);
        BACK_R.setTargetPosition(-encoderTarget);
        BACK_L.setTargetPosition(encoderTarget);

        FRONT_R.setPower(WheelSpeed);
        FRONT_L.setPower(WheelSpeed);
        BACK_R.setPower(WheelSpeed);
        BACK_L.setPower(WheelSpeed);

        FRONT_R.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FRONT_L.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BACK_R.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BACK_L.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }
    private void MoveLeft () {

        double rotations = DistanceInCM/circumference;
        int encoderTarget = (int) (rotations *537.6);

        FRONT_R.setTargetPosition(-encoderTarget);
        FRONT_L.setTargetPosition(encoderTarget);
        BACK_R.setTargetPosition(encoderTarget);
        BACK_L.setTargetPosition(-encoderTarget);

        FRONT_R.setPower(-WheelSpeed);
        FRONT_L.setPower(WheelSpeed);
        BACK_R.setPower(WheelSpeed);
        BACK_L.setPower(-WheelSpeed);

        FRONT_R.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FRONT_L.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BACK_R.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BACK_L.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }
    private void MoveBackward () {

        double rotations = DistanceInCM/circumference;
        int encoderTarget = (int) (rotations *537.6);

        FRONT_R.setTargetPosition(-encoderTarget);
        FRONT_L.setTargetPosition(-encoderTarget);
        BACK_R.setTargetPosition(-encoderTarget);
        BACK_L.setTargetPosition(-encoderTarget);

        FRONT_R.setPower(WheelSpeed);
        FRONT_L.setPower(WheelSpeed);
        BACK_R.setPower(WheelSpeed);
        BACK_L.setPower(WheelSpeed);

        FRONT_R.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FRONT_L.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BACK_R.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BACK_L.setMode(DcMotor.RunMode.RUN_TO_POSITION);

    }
    private void TurnRight () {

        FRONT_R.setPower(-WheelSpeed);
        FRONT_L.setPower(WheelSpeed);
        BACK_R.setPower(-WheelSpeed);
        BACK_L.setPower(WheelSpeed);

        if (Gyro_Degrees >= Angle) {
            FRONT_R.setPower(0);
            FRONT_L.setPower(0);
            BACK_R.setPower(0);
            BACK_L.setPower(0);
        }

    }
    private void TurnLeft () {

        FRONT_R.setPower(WheelSpeed);
        FRONT_L.setPower(-WheelSpeed);
        BACK_R.setPower(WheelSpeed);
        BACK_L.setPower(-WheelSpeed);

        if (Gyro_Degrees <= Angle) {
            FRONT_R.setPower(0);
            FRONT_L.setPower(0);
            BACK_R.setPower(0);
            BACK_L.setPower(0);
        }

    }
    private void RaiseArm () {

        shoulder.setTargetPosition(-300);
        shoulder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        shoulder.setPower(1);
        //where timer would start and eventually cause claw to release pixel


    }
    private void LowerArm () {

        shoulder.setTargetPosition(0);
        shoulder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        shoulder.setPower(1);

    }
    private void YellowPixelwDistanceSensor () {


        if(DistanceSensor>6 && DistanceSensor < 8) {
            RaiseArm();
            WheelSpeed = .5;
            DistanceInCM = 3;
            MoveForward();
            //ReleaseYellowPixel();
            DistanceInCM = 5;
            MoveBackward();
            LowerArm();
            Angle = 0;
            TurnRight();
        }

        double rotations = DistanceInCM/circumference;
        int encoderTarget = (int) (rotations *537.6);

        FRONT_R.setTargetPosition(encoderTarget);
        FRONT_L.setTargetPosition(encoderTarget);
        BACK_R.setTargetPosition(encoderTarget);
        BACK_L.setTargetPosition(encoderTarget);

        FRONT_R.setPower(WheelSpeed);
        FRONT_L.setPower(WheelSpeed);
        BACK_R.setPower(WheelSpeed);
        BACK_L.setPower(WheelSpeed);

        FRONT_R.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        FRONT_L.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BACK_R.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        BACK_L.setMode(DcMotor.RunMode.RUN_TO_POSITION);



    }
    private void TurnLeftandMove () {

        FRONT_R.setPower(WheelSpeed);
        FRONT_L.setPower(-WheelSpeed);
        BACK_R.setPower(WheelSpeed);
        BACK_L.setPower(-WheelSpeed);

        //if left spike
        if(Gyro_Degrees<-30 && DistanceSensor < 75) {

            //Reset gyro to 0 degrees
            FRONT_R.setPower(-WheelSpeed);
            FRONT_L.setPower(WheelSpeed);
            BACK_R.setPower(-WheelSpeed);
            BACK_L.setPower(WheelSpeed);

            if (Gyro_Degrees < 2 && Gyro_Degrees > -2) {
                FRONT_R.setPower(0);
                FRONT_L.setPower(0);
                BACK_R.setPower(0);
                BACK_L.setPower(0);
            }

            WheelSpeed = .85;
            DistanceInCM = 45;
            MoveForward();
            Angle = -90;
            TurnLeft();
            DistanceInCM = 8;
            MoveForward();
            ReleasePurplePixel();
            DistanceInCM = 8;
            MoveBackward();
            DistanceInCM =25;
            MoveLeft();
            WheelSpeed = .9;
            DistanceInCM = 300;
            YellowPixelwDistanceSensor();


            //if middle spike
        } else if (Gyro_Degrees>-20 && Gyro_Degrees <20 && DistanceSensor < 75 ) {

            //Reset gyro to 0 degrees
            FRONT_R.setPower(WheelSpeed);
            FRONT_L.setPower(-WheelSpeed);
            BACK_R.setPower(WheelSpeed);
            BACK_L.setPower(-WheelSpeed);

            if (Gyro_Degrees > -2 && Gyro_Degrees < 2) {
                FRONT_R.setPower(0);
                FRONT_L.setPower(0);
                BACK_R.setPower(0);
                BACK_L.setPower(0);
            }

            DistanceInCM = 10;
            MoveLeft();
            DistanceInCM = 43;
            MoveForward();
            ReleasePurplePixel();
            DistanceInCM = 8;
            MoveBackward();
            Angle = -90;
            TurnLeft();
            WheelSpeed = .9;
            DistanceInCM = 190;
            MoveForward();
            DistanceInCM = 10;
            MoveLeft();
            DistanceInCM = 300;
            YellowPixelwDistanceSensor();

            //if right spike
        } else if (Gyro_Degrees>30 && DistanceSensor < 75 ) {

            //Reset gyro to 0 degrees
            FRONT_R.setPower(WheelSpeed);
            FRONT_L.setPower(-WheelSpeed);
            BACK_R.setPower(WheelSpeed);
            BACK_L.setPower(-WheelSpeed);

            if (Gyro_Degrees < 2 && Gyro_Degrees > -2) {
                FRONT_R.setPower(0);
                FRONT_L.setPower(0);
                BACK_R.setPower(0);
                BACK_L.setPower(0);
            }

            //Move Right
            DistanceInCM = 31;
            WheelSpeed = .9;
            MoveForward();
            Angle = 90;
            TurnRight();
            DistanceInCM = 15;
            MoveForward();
            ReleasePurplePixel();
            DistanceInCM = 8;
            MoveBackward();
            DistanceInCM = 10;
            MoveRight();
            Angle = -90;
            TurnLeft();
            WheelSpeed = .9;
            DistanceInCM = 265;
            MoveForward();
            DistanceInCM = 8;
            MoveRight();
            DistanceInCM = 300;
            YellowPixelwDistanceSensor();


        } else if (Gyro_Degrees >= Angle) {

            FRONT_R.setPower(0);
            FRONT_L.setPower(0);
            BACK_R.setPower(0);
            BACK_L.setPower(0);

        }

    }

    private void Telemetry () {

        telemetry.addData("Gyro Degrees", Gyro_Degrees);
        telemetry.addData("Gyro Radians", Gyro_Radians);
        telemetry.addData("Yaw", Orientation2.getYaw(AngleUnit.DEGREES));
        telemetry.addData("FR", FRONT_R.getPower());
        telemetry.addData("FL", FRONT_L.getPower());
        telemetry.addData("BR", BACK_R.getPower());
        telemetry.addData("BL", BACK_L.getPower());
        telemetry.addData("shoulder", shoulder.getCurrentPosition());
        telemetry.addData("shoulderStick", shoulderStick);
        telemetry.addData("shoulder_Position", shoulder_Position);
        telemetry.addData("Pixel Level: ", PixelLevel);
        telemetry.addData("Shoulder Level:", ShoulderLevel);
        telemetry.addData("Distance", DistanceInCM);
        //telemetry.addData("shoulder", shoulder.getTargetPosition());
        telemetry.update();

    }
    @Override
    public void runOpMode() {

        InitialSetup();

        // Set Directions
        BACK_L.setDirection(DcMotorSimple.Direction.REVERSE);
        BACK_R.setDirection(DcMotorSimple.Direction.FORWARD);
        FRONT_L.setDirection(DcMotorSimple.Direction.REVERSE);
        FRONT_R.setDirection(DcMotorSimple.Direction.FORWARD);
        shoulder.setDirection(DcMotorSimple.Direction.FORWARD);
        shoulder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Reset shoulder Encoder
        shoulder_Position = 0;

        IMU();

        waitForStart();

        while (opModeIsActive()) {

            //Distance Sensor
            DistanceSensor = distance.getDistance(DistanceUnit.CM);

            //shoulderEncoder
            shoulder_Position = shoulder.getCurrentPosition();

            //Imu Angle Variables
            Angular_Velocity = imu_IMU.getRobotAngularVelocity(AngleUnit.DEGREES);
            Orientation2 = imu_IMU.getRobotYawPitchRollAngles();
            Gyro_Degrees = Orientation2.getYaw(AngleUnit.DEGREES);

            // 1. Move Forward
            StepNum = 1;
            DistanceInCM = 31.5;
            WheelSpeed = 1;
            MoveForward();
            telemetry.addData("Step: ",StepNum);

            // 2. Rotate to Right
            StepNum = 2;
            WheelSpeed = .8;
            Angle = 90;
            TurnRight();

            telemetry.addData("Step: ",StepNum);

            // 3. Check for Team Prop Rotate While rotating to the right and Finish Autonomous
            StepNum = 3;
            WheelSpeed = .3;
            Angle = -90;
            TurnLeftandMove();
            telemetry.addData("Step: ",StepNum);

            // Telemetry
            Telemetry();

        }

    }


}
