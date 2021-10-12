package sb.com.project.BL.Authentication;

import org.springframework.beans.factory.annotation.Autowired;

public class SignUpModel {
    private IAuthenticationServices authenticationServices;

    @Autowired
    public void setAuthenticationServices(IAuthenticationServices authenticationServices) {
        this.authenticationServices = authenticationServices;
    }
}
