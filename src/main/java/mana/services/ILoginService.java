package mana.services;

import mana.models.LoginModel;

public interface ILoginService {
    LoginModel loginList(String name , String password);
    String checkLogin(String name , String password);
}
