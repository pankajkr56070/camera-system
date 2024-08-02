

class CaptureRequest implements Comparable<CaptureRequest> {
    private String clientId;
    private int urgency;
    private Callback<Image> successCallback;
    private Callback<String> failureCallback;

    public CaptureRequest(String clientId, int urgency, Callback<Image> successCallback, Callback<String> failureCallback) {
        this.clientId = clientId;
        this.urgency = urgency;
        this.successCallback = successCallback;
        this.failureCallback = failureCallback;
    }

    public int getUrgency() {
        return urgency;
    }

    public Callback<Image> getSuccessCallback() {
        return successCallback;
    }

    public Callback<String> getFailureCallback() {
        return failureCallback;
    }

    @Override
    public int compareTo(CaptureRequest other) {
        return Integer.compare(other.getUrgency(), this.getUrgency());
    }
}
