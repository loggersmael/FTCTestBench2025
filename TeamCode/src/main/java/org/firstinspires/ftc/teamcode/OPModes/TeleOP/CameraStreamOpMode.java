package org.firstinspires.ftc.teamcode.OPModes.TeleOP;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import android.util.Size;

@TeleOp(name="Camera Stream OpMode", group="Vision")
public class CameraStreamOpMode extends LinearOpMode {

    private VisionPortal visionPortal;
    private Size res= new Size(1280,800);

    @Override
    public void runOpMode() {
        WebcamName webcam = hardwareMap.get(WebcamName.class, "Webcam 1");

        VisionPortal.Builder visionPortalBuilder = new VisionPortal.Builder();
        visionPortalBuilder.setCamera(webcam);
        visionPortalBuilder.enableLiveView(true);
        visionPortalBuilder.setStreamFormat(VisionPortal.StreamFormat.MJPEG);
        visionPortalBuilder.setCameraResolution(res);
        visionPortal = visionPortalBuilder.build();

        visionPortal.resumeStreaming();

        telemetry.addData("Status: ", "Initialized");
        telemetry.update();
        waitForStart();

        // Keep the OpMode alive after start
        while (opModeIsActive()) {
            telemetry.addData("Status", "Running");
            telemetry.update();
//            sleep(100);
        }

        visionPortal.stopStreaming();
        visionPortal.close();
    }
}