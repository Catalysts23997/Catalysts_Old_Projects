package org.firstinspires.ftc.teamcode.Kotlin_Bromine_Arya.Opmodes.`Testing$Tuning`.`Subsystems$Tele`.Attachment.PID

import com.acmerobotics.dashboard.FtcDashboard
import com.acmerobotics.dashboard.config.Config
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry
import com.qualcomm.robotcore.eventloop.opmode.Disabled
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorEx
import com.qualcomm.robotcore.hardware.DcMotorSimple
import org.firstinspires.ftc.teamcode.Kotlin_Bromine_Arya.PIDFcontroller
import org.firstinspires.ftc.teamcode.Kotlin_Bromine_Arya.PIDParams

@Disabled
@TeleOp(name = "PIDSHOULDER", group = "Linear OpMode")
class PIDSHOULDER : LinearOpMode() {
    @Config
    object bruh{
        @JvmField var target= 0.0
    }
    val shoulder= PIDFcontroller(PIDParams(.0235, .00008, .00115, .12))
    override fun runOpMode() {
        telemetry = MultipleTelemetry(telemetry, FtcDashboard.getInstance().telemetry)

        val Shoulder = hardwareMap.get(DcMotorEx::class.java, "shoulder")

        Shoulder.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
        Shoulder.mode = DcMotor.RunMode.RUN_WITHOUT_ENCODER
        Shoulder.direction = DcMotorSimple.Direction.REVERSE

        val powerDrop: Double = -0.004

        waitForStart()

        while (opModeIsActive()) {
            val PidfPower =
                shoulder.calculate(bruh.target -Shoulder.currentPosition.toDouble())

            Shoulder.power = if (bruh.target.toInt() == 0) {
                powerDrop
            } else {
                PidfPower
            }

            telemetry.addData("powerD", Shoulder.power)
            telemetry.update()
        }
    }

}
