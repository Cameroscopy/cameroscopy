package com.modakdev.cameroscopy.api;

import com.modakdev.cameroscopy.model.client.CameroscopyUser;
import com.modakdev.cameroscopy.model.server.CameroscopyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.http.HttpHeaders;
import java.util.Map;

public interface CameroscopyController {

    public String healthCheck();

    public CameroscopyUser addUser(@RequestBody CameroscopyUser user);

    public CameroscopyUser deleteUser(@RequestBody CameroscopyUser user);

    public CameroscopyUser deleteUserById(@RequestParam Long id);

    public CameroscopyResponse signUp(@RequestHeader Map<String, String> headers, @RequestBody CameroscopyUser user);

    public CameroscopyResponse login(@RequestBody CameroscopyUser user);

    }
