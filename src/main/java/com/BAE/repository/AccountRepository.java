package com.BAE.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BAE.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long>  {


}