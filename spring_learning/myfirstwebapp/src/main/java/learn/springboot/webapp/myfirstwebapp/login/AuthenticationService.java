package learn.springboot.webapp.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String userName, String password) {
		// hard-coded authentication
		// return true only when name: Ranga & password: dummy
		boolean isValidUserName = userName.equalsIgnoreCase("Ranga");
		boolean isValidPassword = password.equalsIgnoreCase("dummy");
		return isValidUserName && isValidPassword;
	}

}
