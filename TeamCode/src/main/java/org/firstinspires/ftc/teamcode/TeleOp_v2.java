/*
TeleOP_v1
9/11/2017
6210 Software
- William Fisher
- Rohit Chawla
- Nihal Kyasa

Allows driver to control the robot using a gamepad during
the driver controlled period of FTC's Relic Recovery competition.
 */

package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TeleOp v2.0", group="TeleOp")
public class TeleOp_v2 extends TeleOpLibrary_v1
{
    private double drivePowerMod;
    private boolean tank;
/**  GYRO-NEEDED  private boolean resetAngle; **/

    @Override
    public void init() {
        initialize();
        drivePowerMod = .8;
        tank = false;
        /** GRYO NEEDED resetAngle = false;*/
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY

    @Override
    public void init_loop() {
    }
    */

    /*
     * Code to run ONCE when the driver hits PLAY

    @Override
    public void start() {
        runtime.reset();
    }
    */

    @Override
    public void loop() {

        // Mecanum Drive
        if (!tank /** GYRO NEEDED && !resetAngle*/)
        {
           drive_mecanum(drivePowerMod/** GRYO NEEDED , getAngle()*/);
        }
        //tank drive
        else if (tank)
        {
            drive_tank(drivePowerMod);
        }
/** GRYO NEEDED       else
        {
            resetAngle = false;
        }*/
/** GRYO NEEDED        toggle(resetAngle, gamepad1.y);*/
        tank = toggle(tank, gamepad1.b);
        drivePowerMod = toggleDouble(drivePowerMod, gamepad1.x, .8, .2);

    }
    @Override
    public void stop() {
    }

}
