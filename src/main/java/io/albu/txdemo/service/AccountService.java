package io.albu.txdemo.service;

import io.albu.txdemo.model.AccountEntity;
import io.albu.txdemo.model.CrewEntity;
import io.albu.txdemo.model.RoleEntity;
import io.albu.txdemo.repository.AccountRepository;
import io.albu.txdemo.repository.CrewRepository;
import io.albu.txdemo.repository.RoleRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {
  private final AccountRepository accountRepository;
  private final CrewRepository crewRepository;
  private final RoleRepository roleRepository;

  @Transactional(propagation = Propagation.SUPPORTS)
  //@Transactional
  public void A() {
    log.info("entering method A");
    AccountEntity account = AccountEntity.builder()
        .id(UUID.randomUUID())
        .email("andrei.albu.aax@gmail.com")
        .build();
    this.accountRepository.saveAndFlush(account);
    this.B();
    throw new RuntimeException("error in A");
  }

  //@Transactional(propagation = Propagation.SUPPORTS)
  //@Transactional
  public void B() {
    log.info("entering method B");
    RoleEntity role = RoleEntity.builder()
        .id(UUID.randomUUID())
        .name("ADMIN")
        .build();
    this.roleRepository.saveAndFlush(role);
    //throw new RuntimeException("error in B");
  }
}
