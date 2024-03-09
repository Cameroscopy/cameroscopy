package com.modakdev.cameroscopy.api;


import com.modakdev.cameroscopy.model.client.CameroscopyUser;
import com.modakdev.cameroscopy.model.server.CameroscopyLoginResponse;
import com.modakdev.cameroscopy.model.server.CameroscopyResponse;
import com.modakdev.cameroscopy.model.server.CameroscopySignupResponse;
import com.modakdev.cameroscopy.service.CameroscopyAuthService;
import com.modakdev.cameroscopy.service.CameroscopyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CameroscopyControllerImpl implements CameroscopyController{


    @Autowired
    CameroscopyServiceImpl service; //Autowire the service

    @Autowired
    private CameroscopyAuthService authService;

    @GetMapping("/healthcheck")
    public String healthCheck()
    {
        return "ok";
    }

    @PostMapping("/adduser")
    public CameroscopyUser addUser(@RequestBody CameroscopyUser user)
    {
        return service.addUser(user);
    }

    @DeleteMapping("/deleteuser")
    public CameroscopyUser deleteUser(@RequestBody CameroscopyUser user)
    {
        return service.deleteUser(user);
    }

    @DeleteMapping("/deleteuser/{id}")
    public CameroscopyUser deleteUserById(@RequestParam Long id)
    {
        return service.deleteUserById(id);
    }


    @PostMapping("/signup")
    public CameroscopyResponse signUp(@RequestBody CameroscopyUser user) {
        boolean result = authService.signUp(user);
        CameroscopySignupResponse response = new CameroscopySignupResponse();
        if(result) {
            response.setMessage("Signup successfull, User registered successfully.");
            response.setStatus(HttpStatus.OK);
            response.setUser(user);
            return response;
        } else {
            response.setMessage("Signup failed, User registration failed.");
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setUser(user);
            return response;
        }
    }

    @PostMapping("/login")
    public CameroscopyResponse login(@RequestBody CameroscopyUser user) {
        String token = authService.login(user.getUsername(), user.getPassword());
        CameroscopyLoginResponse response = new CameroscopyLoginResponse();
        if(token != null) {
            {
                response.setMessage("Login successfull");
                response.setStatus(HttpStatus.OK);
                response.setToken(token);
                return response;
            }
        } else {
            response.setMessage("Request failed, invalid username or password.");
            response.setStatus(HttpStatus.UNAUTHORIZED);
            return response;
        }
    }
}
