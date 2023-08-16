package com.saas.camunda.example;

import org.springframework.data.repository.CrudRepository;

public interface customerRepository extends CrudRepository<customerDataEntity, Integer> {

}
