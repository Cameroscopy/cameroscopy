package com.modakdev.cameroscopy.repo;

import com.modakdev.cameroscopy.model.client.CameroscopyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameroscopyRepository extends JpaRepository<CameroscopyUser, Long> {

    public CameroscopyUser deleteUserById(Long id);
}
