package io.albu.txdemo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountDelegator {
  private final AccountService accountService;

  @Transactional
  public void X() {
    log.info("entering method X");
    this.accountService.A();
  }
}
