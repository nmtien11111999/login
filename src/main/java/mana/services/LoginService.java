package mana.services;

import mana.models.LoginModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService implements ILoginService {
    private List<LoginModel> loginModels = new ArrayList<>();

    public LoginService(){
        loginModels.add(new LoginModel("admin", "admin", "admin"));
        loginModels.add(new LoginModel("user", "user", "user"));
        loginModels.add(new LoginModel("user", "guest", "guest"));
    }

    @Override
    public LoginModel loginList(String name, String password) {
        for (LoginModel loginModel : loginModels) {
            if (loginModel.getUsername().equals(name) && loginModel.getPassword().equals(password)) {
                return loginModel;
            }
        }
        return null;
    }

    public String checkLogin(String name, String password) {
        LoginModel login = loginList(name, password);
        if (login != null) {
            return login.getRole();
        }
        return null;
    }
}
