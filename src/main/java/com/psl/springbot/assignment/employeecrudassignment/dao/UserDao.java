package com.psl.springbot.assignment.employeecrudassignment.dao;

import com.psl.springbot.assignment.employeecrudassignment.model.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
    DAOUser findByUsername(String username);
}
