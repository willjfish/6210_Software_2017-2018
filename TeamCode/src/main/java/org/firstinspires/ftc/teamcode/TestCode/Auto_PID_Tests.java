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

package org.firstinspires.ftc.teamcode.TestCode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.AutoLibrary_v2;

@Autonomous (name="PID Test", group="Auto")
public class Auto_PID_Tests extends AutoLibrary_v2 {

    @Override
    public void runOpMode() throws InterruptedException{
        frdrive = hardwareMap.get(DcMotor.class, "fr");
        fldrive = hardwareMap.get(DcMotor.class, "fl");
        brdrive = hardwareMap.get(DcMotor.class, "br");
        bldrive = hardwareMap.get(DcMotor.class, "bl");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        double k_prop = .01; //increases power based on distance remaining - increase if too slow esp at start - biggest
        double k_int = .05; //increases power (in effect*) based on time running - increase if too slow at end - medium
        double k_derv = .025; //increases power based on speed - increase to smooth movement - smallest
        // *in reality, k_int increases power based on the integral of distance with respect to time
        //  this means that k_int increases power based on the sum of distance for each unit (machinecycle) of time

        /** STARTING VALUES
         * k_prop = .01
         * k_int = .05
         * k_derv = .025
         */

        for (int i = 0; i < 3; i++) {
            move_PID(.5, 0, k_prop, k_int, k_derv, 2000, 2);
            sleep(1000);
            move_PID(-.5, 0, k_prop, k_int, k_derv, 2000, 2);
            sleep(1000);
        }
    }
}
