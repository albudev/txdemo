package io.albu.txdemo.controller;

import io.albu.txdemo.service.AccountDelegator;
import io.albu.txdemo.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
  private final AccountService accountService;
  private final AccountDelegator accountDelegator;

  @GetMapping
  public ResponseEntity<Void> doSomething() {
    this.accountService.A();
    throw new RuntimeException("hello");
  }

  @GetMapping("/v2")
  public ResponseEntity<Void> doSomethingV2() {
    this.accountDelegator.X();
    return ResponseEntity.ok().build();
    //throw new RuntimeException("hello v2");
  }

}