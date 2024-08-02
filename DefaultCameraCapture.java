public class DefaultCameraCapture implements CameraCapture {

    @Override
    public boolean captureImage() {
        return Math.random() > 0.2; // 80% success rate
    }
    
}
