import java.util.PriorityQueue;

public class CaptureManager {
    private PriorityQueue<CaptureRequest> requestQueue;

    public CaptureManager() {
        this.requestQueue = new PriorityQueue<>();
    }

    public synchronized void addRequest(CaptureRequest request) {
        requestQueue.add(request);
    }

    public synchronized CaptureRequest getNextRequest() {
        return requestQueue.poll();
    }
}
