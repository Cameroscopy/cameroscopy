package com.modakdev.cameroscopy.api;


import com.modakdev.cameroscopy.model.client.CameroscopyUser;
import com.modakdev.cameroscopy.service.CameroscopyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CameroscopyController {


    @Autowired
    CameroscopyServiceImpl service; //Autowire the service

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
}
