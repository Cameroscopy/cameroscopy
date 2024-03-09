package com.modakdev.cameroscopy.model.server;

import com.modakdev.cameroscopy.model.client.CameroscopyUser;

public class CameroscopySignupResponse extends CameroscopyResponse{
    CameroscopyUser user;

    public CameroscopySignupResponse() {
    }

    public CameroscopyUser getUser() {
        return user;
    }

    public void setUser(CameroscopyUser user) {
        this.user = user;
    }
}
