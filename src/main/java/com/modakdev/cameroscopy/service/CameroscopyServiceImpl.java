package com.modakdev.cameroscopy.service;


import com.modakdev.cameroscopy.model.client.CameroscopyUser;
import com.modakdev.cameroscopy.repo.CameroscopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CameroscopyServiceImpl implements CameroscopyService{

    @Autowired
    public CameroscopyRepository repo; // autowire the repo

    @Override
    public CameroscopyUser addUser(CameroscopyUser user) {
        repo.save(user);
        return user;
    }

    @Override
    public CameroscopyUser deleteUser(CameroscopyUser user) {
        repo.delete(user);
        return user;
    }

    @Override
    public CameroscopyUser deleteUserById(Long id) {
        CameroscopyUser user = repo.deleteUserById(id);
        return user;
    }
}
