package com.yuzhe.springboot.controller;

import com.yuzhe.springboot.entities.Account;
import com.yuzhe.springboot.entities.CommonResult;
import com.yuzhe.springboot.service.AccountService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class AccountController {
    @Resource
    AccountService accountService;

    @GetMapping("/account")
    public CommonResult getTo(Account account) {
        return accountService.getAccount(account);
    }

    @PostMapping("/account")
    public CommonResult createAccount(Account account) {
        return accountService.createAccount(account);
    }

    @PutMapping("/account")
    public CommonResult updateAccount(Account account) {
        return accountService.updateAccount(account);
    }

    @DeleteMapping("/account")
    public CommonResult deleteTo(Account account) {
        return accountService.deleteAccount(account);
    }

    @GetMapping("/account/getAll")
    public CommonResult getAll(){
        return accountService.getAllAccount();
    }
}
