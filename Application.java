public class Application {

    public static void main(String[] args) {
        CameraCapture defaultCapture = new DefaultCameraCapture();
        CameraSystem cameraSystem = new CameraSystem(defaultCapture);


        Client client1 = new Client();
        Client client2 = new Client();


        Callback<Image> client1SuccessCallback = image -> System.out.println("Client 1 Success: " + image.getData());
        Callback<String> client1FailureCallback = error -> System.out.println("Client 1 Failure: " + error);

        Callback<Image> client2SuccessCallback = image -> System.out.println("Client 2 Success: " + image.getData());
        Callback<String> client2FailureCallback = error -> System.out.println("Client 2 Failure: " + error);

        CaptureRequest request1 = new CaptureRequest("client1", 2, client1SuccessCallback, client1FailureCallback);
        CaptureRequest request2 = new CaptureRequest("client2", 5, client2SuccessCallback, client2FailureCallback);


        client1.submitRequest(cameraSystem, request1);
        client2.submitRequest(cameraSystem, request2);
        
    }


}