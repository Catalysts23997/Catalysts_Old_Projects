package org.firstinspires.ftc.teamcode.Previous.Outdated_CenterStage.Our.Autonomous;
/*
import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.lang.Math;
import java.util.List;

@Autonomous(name="RC_6", group="Linear OpMode")

@Disabled
public class RC_6 extends LinearOpMode {


    private static final String TFOD_MODEL_FILE = "Red.tflite";
    int camera =0;
    private static final boolean USE_WEBCAM = true;
    private static final String[] LABELS = {
            "Pixel",
    };
    private TfodProcessor tfod;
    private VisionPortal visionPortal;

    public Action LeftClaw() {
        Servo claw;
        claw= hardwareMap.get(Servo.class, "claw");
        Servo claw2;
        claw2= hardwareMap.get(Servo.class, "claw2");
        return new Action() {
            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                claw2.setPosition(0);
                return false;
            }
        };

    }
    public Action Close() {
        Servo claw;
        claw= hardwareMap.get(Servo.class, "claw");
        Servo claw2;
        claw2= hardwareMap.get(Servo.class, "claw2");
        return new Action() {
            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                claw2.setPosition(0);
                claw.setPosition(1);
                return false;
            }
        };

    }
    public Action RightClaw() {
        Servo claw;
        claw= hardwareMap.get(Servo.class, "claw");
        Servo claw2;
        claw2= hardwareMap.get(Servo.class, "claw2");
        return new Action() {
            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                claw.setPosition(1);
                return false;
            }
        };

    }
    public Action Release() {
        Servo claw;
        claw= hardwareMap.get(Servo.class, "claw");
        Servo claw2;
        claw2= hardwareMap.get(Servo.class, "claw2");
        return new Action() {
            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                claw.setPosition(.4);
                claw2.setPosition(.4);
                return false;
            }
        };

    }

    public Action Raise1() {

        Servo wrist2;
        wrist2= hardwareMap.get(Servo.class, "wrist2");
        DcMotor shoulder;
        shoulder= hardwareMap.get(DcMotor.class, "shoulder");
        shoulder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shoulder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        return new Action() {
            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                shoulder.setTargetPosition(-285);
                shoulder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                shoulder.setPower(1);
                wrist2.setPosition(.216);
                return false;
            }
        };

    }
    public Action Raise2() {

        Servo wrist2;
        wrist2= hardwareMap.get(Servo.class, "wrist2");
        DcMotor shoulder;
        shoulder= hardwareMap.get(DcMotor.class, "shoulder");
        shoulder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shoulder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        return new Action() {
            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                shoulder.setTargetPosition(-340);
                shoulder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                shoulder.setPower(1);
                wrist2.setPosition(.218);
                return false;
            }
        };

    }
    public Action Raise3() {

        Servo wrist2;
        wrist2= hardwareMap.get(Servo.class, "wrist2");
        DcMotor shoulder;
        shoulder= hardwareMap.get(DcMotor.class, "shoulder");
        shoulder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shoulder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        return new Action() {
            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                wrist2.setPosition(.221);
                shoulder.setTargetPosition(-415);
                shoulder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                shoulder.setPower(1);
                return false;
            }
        };

    }

    public Action RaiseA() {

        Servo wrist2;
        wrist2= hardwareMap.get(Servo.class, "wrist2");
        DcMotor shoulder;
        shoulder= hardwareMap.get(DcMotor.class, "shoulder");
        shoulder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shoulder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        return new Action() {
            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                shoulder.setTargetPosition(-175);
                shoulder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                shoulder.setPower(1);
                wrist2.setPosition(.326);
                return false;
            }
        };

    }
    public Action RaiseB() {

        Servo wrist2;
        wrist2= hardwareMap.get(Servo.class, "wrist2");
        DcMotor shoulder;
        shoulder= hardwareMap.get(DcMotor.class, "shoulder");
        shoulder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        shoulder.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        return new Action() {
            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                shoulder.setTargetPosition(-140);
                shoulder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                shoulder.setPower(1);
                wrist2.setPosition(.406);
                return false;
            }
        };

    }

    public Action Lower() {

        Servo wrist2;
        wrist2= hardwareMap.get(Servo.class, "wrist2");
        DcMotor shoulder;
        shoulder= hardwareMap.get(DcMotor.class, "shoulder");
        shoulder.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        return new Action() {
            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                shoulder.setTargetPosition(0);
                shoulder.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                shoulder.setPower(.3);
                wrist2.setPosition(0);
                return false;
            }
        };

    }

    public Action Servo() {
        Servo servo;
        servo= hardwareMap.get(Servo.class, "servo");
        return new Action() {
            @Override
            public boolean run(@NonNull TelemetryPacket telemetryPacket) {
                servo.setPosition(0);
                return false;
            }
        };

    }

    private void Camera() {


        // Create the TensorFlow processor by using a builder.
        tfod = new TfodProcessor.Builder()

                .setModelFileName(TFOD_MODEL_FILE)

                .setModelLabels(LABELS)


                .build();

        VisionPortal.Builder builder = new VisionPortal.Builder();


        // Set the camera (webcam vs. built-in RC phone camera).
        if (USE_WEBCAM) {
            builder.setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"));
        } else {
            builder.setCamera(BuiltinCameraDirection.BACK);
        }

        builder.addProcessor(tfod);

        visionPortal = builder.build();


    }
    private void INit() {
        Camera();
        Servo servo;
        servo= hardwareMap.get(Servo.class, "servo");
        servo.scaleRange(0,1);
        servo.setPosition(1);

        Servo wrist2;
        wrist2= hardwareMap.get(Servo.class, "wrist2");
        wrist2.scaleRange(0,1);
        wrist2.setPosition(.216);

        Servo claw2;
        claw2 = hardwareMap.get(Servo.class,"claw2");
        claw2.scaleRange(0,1);
        claw2.setPosition(.4);

        Servo claw;
        claw = hardwareMap.get(Servo.class,"claw");
        claw.setPosition(.4);
        claw.scaleRange(0, 1);

    }

    @Override
    public void runOpMode() {

        MecanumDrive drive = new MecanumDrive(hardwareMap,new Pose2d(-37,-62,Math.PI/2));

        INit();

        waitForStart();

        while(opModeIsActive()) {

            List<Recognition> currentRecognitions = tfod.getRecognitions();

            for (Recognition recognition : currentRecognitions) {
                double x = (recognition.getLeft() + recognition.getRight()) / 2;
                double y = (recognition.getTop() + recognition.getBottom()) / 2;
                if(x>=0 && x<320) {
                    camera=2;
                    visionPortal.stopStreaming();
                }
                if(x>=320 && x<=640) {
                    camera=1;
                    visionPortal.stopStreaming();
                }


            }
            currentRecognitions.size();
            visionPortal.stopStreaming();

//left
            if (camera == 0) {
                Actions.runBlocking(drive.actionBuilder(new Pose2d(16, -62, Math.PI/2))

                        .splineToSplineHeading(new Pose2d(10.5,-25,0), Math.PI/2)
                        .stopAndAdd(Servo())
                        .waitSeconds(.4)
                        .stopAndAdd(Raise1())
                        .splineToSplineHeading(new Pose2d(47,-42.5,0),3*Math.PI/2)
                        .stopAndAdd(Release())
                        .waitSeconds(.6)
                        .lineToX(40)
                        .afterTime(.6,Lower())
                        .splineToSplineHeading(new Pose2d(0,-36,Math.PI),Math.PI)
                        .afterTime(1,RaiseA())
                        .lineToX(-56)
                        .stopAndAdd(Close())
                        .waitSeconds(.4)
                        .afterTime(1,Lower())
                        .lineToX(1.5)
                        .stopAndAdd(Raise2())
                        .splineToSplineHeading(new Pose2d(47,-35,0),3*Math.PI/2)
                        .stopAndAdd(Release())
                        .waitSeconds(.8)
                        .lineToX(40)
                        .afterTime(.5,Lower())
                        .splineToSplineHeading(new Pose2d(-5,-36,Math.PI),Math.PI)
                        .afterTime(1.2,RaiseB())
                        .lineToX(-56)
                        .stopAndAdd(Close())
                        .waitSeconds(.4)
                        .afterTime(1, Lower())
                        .lineToX(1.5)
                        .stopAndAdd(Raise2())
                        .splineToSplineHeading(new Pose2d(47,-35,0),3*Math.PI/2)
                        .stopAndAdd(Release())
                        .waitSeconds(.6)
                        .lineToX(40)
                        .afterTime(.6,Lower())
                        .splineToSplineHeading(new Pose2d(0,-36,Math.PI),Math.PI)
                        .waitSeconds(9)
                        .afterTime(1,RaiseA())
                        .lineToX(-56)
                        .stopAndAdd(Close())
                        .waitSeconds(.4)
                        .afterTime(1,Lower())
                        .lineToX(1.5)
                        .stopAndAdd(Raise3())
                        .splineToSplineHeading(new Pose2d(47,-35,0),3*Math.PI/2)
                        .stopAndAdd(Release())
                        .waitSeconds(.4)
                        //release
                        .setTangent(0)
                        .lineToX(40)
                        .turnTo(Math.PI/2)
                                .stopAndAdd(Lower())

                        .build());
                requestOpModeStop();
            }
//middle +5
            else if (camera == 2) {

                Actions.runBlocking(drive.actionBuilder(new Pose2d(16, 62, Math.PI/2))

                        .splineToSplineHeading(new Pose2d(20,-25,0), Math.PI)
                        .stopAndAdd(Servo())
                        .waitSeconds(.4)
                        .stopAndAdd(Raise1())
                        .splineToSplineHeading(new Pose2d(47,-34,0),3*Math.PI/2)
                        .stopAndAdd(Release())
                        .waitSeconds(.6)
                        .lineToX(40)
                        .afterTime(.6,Lower())
                        .splineToSplineHeading(new Pose2d(0,-36,Math.PI),Math.PI)
                        .waitSeconds(9)
                        .afterTime(1,RaiseA())
                        .lineToX(-56)
                        .stopAndAdd(Close())
                        .waitSeconds(.4)
                        .afterTime(1,Lower())
                        .lineToX(1.5)
                        .stopAndAdd(Raise2())
                        .splineToSplineHeading(new Pose2d(47,-42.5,0),3*Math.PI/2)
                        .stopAndAdd(Release())
                        .waitSeconds(.8)
                        .lineToX(40)
                        .afterTime(.5,Lower())
                        .splineToSplineHeading(new Pose2d(-5,-36,Math.PI),Math.PI)
                        .afterTime(1.2,RaiseB())
                        .lineToX(-56)
                        .stopAndAdd(Close())
                        .waitSeconds(.4)
                        .afterTime(1, Lower())
                        .lineToX(1.5)
                        .stopAndAdd(Raise2())
                        .splineToSplineHeading(new Pose2d(47,-42.5,0),3*Math.PI/2)
                        .stopAndAdd(Release())
                        .waitSeconds(.6)
                        .lineToX(40)
                        .afterTime(.6,Lower())
                        .splineToSplineHeading(new Pose2d(0,-36,Math.PI),Math.PI)
                        .waitSeconds(9)
                        .afterTime(1,RaiseA())
                        .lineToX(-56)
                        .stopAndAdd(Close())
                        .waitSeconds(.4)
                        .afterTime(1,Lower())
                        .lineToX(1.5)
                        .stopAndAdd(Raise3())
                        .splineToSplineHeading(new Pose2d(47,-42.5,0),3*Math.PI/2)
                        .waitSeconds(.4)
                        .setTangent(0)
                        .lineToX(40)
                        .turnTo(Math.PI/2)
                        .stopAndAdd(Lower())
                                .build());
                requestOpModeStop();
            }
            else if (camera == 1) {

                Actions.runBlocking(drive.actionBuilder(new Pose2d(16, 62, Math.PI/2))

                        .splineToSplineHeading(new Pose2d(32,-26,0), Math.PI/2)
                        .stopAndAdd(Servo())
                        .waitSeconds(.4)
                        .stopAndAdd(Raise1())
                        .splineToSplineHeading(new Pose2d(47,-42.5,0),3*Math.PI/2)
                        .stopAndAdd(Release())
                        .waitSeconds(.6)
                        .lineToX(40)
                        .afterTime(.6,Lower())
                        .splineToSplineHeading(new Pose2d(0,-36,Math.PI),Math.PI)
                        .waitSeconds(9)
                        .afterTime(1,RaiseA())
                        .lineToX(-56)
                        .stopAndAdd(Close())
                        .waitSeconds(.4)
                        .afterTime(1,Lower())
                        .lineToX(1.5)
                        .stopAndAdd(Raise2())
                        .splineToSplineHeading(new Pose2d(47,-35,0),3*Math.PI/2)
                        .stopAndAdd(Release())
                        .waitSeconds(.8)
                        .lineToX(40)
                        .afterTime(.5,Lower())
                        .splineToSplineHeading(new Pose2d(-5,-36,Math.PI),Math.PI)
                        .afterTime(1.2,RaiseB())
                        .lineToX(-56)
                        .stopAndAdd(Close())
                        .waitSeconds(.4)
                        .afterTime(1, Lower())
                        .lineToX(1.5)
                        .stopAndAdd(Raise3())
                        .splineToSplineHeading(new Pose2d(47,-35,0),3*Math.PI/2)
                        .stopAndAdd(Release())
                        .waitSeconds(.8)
                        .lineToX(40)
                        .afterTime(.5,Lower())
                        .splineToSplineHeading(new Pose2d(-5,-36,Math.PI),Math.PI)
                        .afterTime(1.2,RaiseB())
                        .lineToX(-56)
                        .stopAndAdd(Close())
                        .waitSeconds(.4)
                        .afterTime(1, Lower())
                        .lineToX(1.5)
                        .stopAndAdd(Raise3())
                        .splineToSplineHeading(new Pose2d(47,-35,0),3*Math.PI/2)
                        .stopAndAdd(Release())
                        .waitSeconds(.4)
                        .setTangent(0)
                        .lineToX(40)
                        .turnTo(Math.PI/2)
                        .stopAndAdd(Lower())
                        .build());

                requestOpModeStop();
            }

        }
    }


}



 */


