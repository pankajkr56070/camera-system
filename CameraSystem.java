import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CameraSystem {
    private CaptureManager captureManager;
    private ExecutorService executorService;
    private CameraCapture cameraCapture;
    

    public CameraSystem(CameraCapture cameraCapture) {
        this.captureManager = new CaptureManager();
        this.executorService = Executors.newCachedThreadPool();
        this.cameraCapture = cameraCapture;
    }

    public void submitCaptureRequest(CaptureRequest request) {
        if(request == null) {
            System.out.println("Capture request is null");
            return;
        }
        captureManager.addRequest(request);
        executorService.submit(this::processCaptureRequest);
    }

    private void processCaptureRequest() {
        CaptureRequest request = captureManager.getNextRequest();
        if (request != null) {
           
            boolean success = cameraCapture.captureImage();
            if (success) {
                request.getSuccessCallback().call(new Image("Captured Image Data"));
            } else {
                request.getFailureCallback().call("Failed to capture image");
            }
        }
    }
}
