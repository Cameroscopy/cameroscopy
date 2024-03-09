package com.modakdev.cameroscopy.model.server;

public class CameroscopyLoginResponse extends CameroscopyResponse{
    String token;

    public CameroscopyLoginResponse() {
    }

    public String getToken() {
        return token;
    }


    public void setToken(String token) {
        this.token = token;
    }
}
