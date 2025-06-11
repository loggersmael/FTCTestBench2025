package org.firstinspires.ftc.teamcode.subsystems;



import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import org.firstinspires.ftc.robotcore.external.hardware.camera.Camera;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;
import org.openftc.easyopencv.OpenCvWebcam;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.stream.CameraStreamServer;

public class OpenCVVision extends SubsystemBase
{
    private OpenCvCamera camera;

    private Camera cameraa;
    private Telemetry telemetry;
    private boolean streaming;
    public OpenCVVision(HardwareMap aHardwareMap, Telemetry telemetry)
    {
        int cameraMonitorViewId = aHardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", aHardwareMap.appContext.getPackageName());
        camera = OpenCvCameraFactory.getInstance().createWebcam(aHardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);

    }

    public void setPipeline(OpenCvPipeline pipe)
    {
        camera.setPipeline(pipe);
    }

    public void streamToHub()
    {
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                camera.startStreaming(1280, 800);
                streaming = true;
            }
            @Override
            public void onError(int errorCode) {stop();}
        });

    }

    public void stop() {
        camera.stopStreaming();
        camera.closeCameraDevice();
        streaming = false;
    }

    @Override
    public void periodic()
    {
        CameraStreamServer.getInstance().setSource(camera);
    }
}
