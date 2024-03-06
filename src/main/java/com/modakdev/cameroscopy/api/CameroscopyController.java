package com.modakdev.cameroscopy.api;

import com.modakdev.cameroscopy.model.client.CameroscopyUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface CameroscopyController {

    public String healthCheck();

    public CameroscopyUser addUser(@RequestBody CameroscopyUser user);

    public CameroscopyUser deleteUser(@RequestBody CameroscopyUser user);

    public CameroscopyUser deleteUserById(@RequestParam Long id);
}
