package com.modakdev.cameroscopy.service;

import com.modakdev.cameroscopy.model.client.CameroscopyUser;

public interface CameroscopyService {
    public CameroscopyUser addUser(CameroscopyUser user);
    public CameroscopyUser deleteUser(CameroscopyUser user);

    public CameroscopyUser deleteUserById(Long id);
}
