/*
AutoMain_v1
9/18/2017
6210 Software
- William Fisher
- Rohit Chawla
- Nihal Kyasa

Controls robot with methods from AutoLibrary class in the
autonomous period of FTC's Relic Recovery competition.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous (name="MainAuto_v1.0", group="Auto")
public class AutoMain_v1 extends AutoLibrary_v1{

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        fldrive = hardwareMap.get(DcMotor.class, "a");
        frdrive = hardwareMap.get(DcMotor.class, "b");
        bldrive = hardwareMap.get(DcMotor.class, "c");
        brdrive = hardwareMap.get(DcMotor.class, "d");
        waitForStart();
        runtime.reset();
        //More later
    }
}