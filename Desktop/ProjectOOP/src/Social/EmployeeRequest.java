package Social;
import java.io.IOException;
import Users.*;
import java.util.Date;
import java.util.List;

public class EmployeeRequest {
    private String requestId;
    private Employee requester;
    private String requestType;
    private String description;
    private Date requestDate;
    private boolean isSignedOff;
    private List<EmployeeRequest> requests;


    public EmployeeRequest(String requestId, Employee requester, String requestType, String description) {
        this.requestId = requestId;
        this.requester = requester;
        this.requestType = requestType;
        this.description = description;
        this.requestDate = new Date();
        this.isSignedOff = false;
    }

    // Method to sign off the request
    public void signOff() {
        isSignedOff = true;
    }

    // Getters and setters for requestId, requester, requestType, description, requestDate, and isSignedOff
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Employee getRequester() {
        return requester;
    }

    public void setRequester(Employee requester) {
        this.requester = requester;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public boolean isSignedOff() {
        return isSignedOff;
    }

    public void setSignedOff(boolean isSignedOff) {
        this.isSignedOff = isSignedOff;
    }
    public boolean isSignedByDeanOrRector() {
        return requests.stream()
                .anyMatch(request -> request.isSignedOff() && request.getRequester() instanceof Manager); // Example check
    }
}
