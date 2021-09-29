package BL.Authentication;

import org.springframework.beans.factory.annotation.Autowired;

public class SignInModel {
    private IAuthenticationServices authenticationServices;

    @Autowired
    public void setAuthenticationServices(IAuthenticationServices authenticationServices) {
        this.authenticationServices = authenticationServices;
    }
}
