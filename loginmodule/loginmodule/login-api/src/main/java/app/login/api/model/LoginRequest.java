package app.login.api.model;

public class LoginRequest {

    String phoneNumber;

    public LoginRequest() {
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
