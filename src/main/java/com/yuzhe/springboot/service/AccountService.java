package com.yuzhe.springboot.service;

import com.yuzhe.springboot.entities.Account;
import com.yuzhe.springboot.entities.CommonResult;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountService {
    @Resource
    SqlSessionTemplate sqlSessionTemplate;

    public CommonResult createAccount(Account account) {
        CommonResult commonResult = new CommonResult();
        Account o = sqlSessionTemplate.selectOne("com.yuzhe.springboot.dao.AccountDao.selectAccount", account);
        if (o == null) {
            int insert = sqlSessionTemplate.insert("com.yuzhe.springboot.dao.AccountDao.insertAccount", account);
            commonResult.setStatus(insert > 0 ? "success" : "faild");
            commonResult.setData(insert > 0 ? "用户注册成功" : "用户注册失败");
        } else {
            commonResult.setStatus("faild");
            commonResult.setData("用户名已存在");
        }
        return commonResult;
    }

    public CommonResult updateAccount(Account account) {
        CommonResult commonResult = new CommonResult();
        Account o = sqlSessionTemplate.selectOne("com.yuzhe.springboot.dao.AccountDao.selectAccount", account);
        if (o != null) {
            int update = sqlSessionTemplate.update("com.yuzhe.springboot.dao.AccountDao.updateAccount", account);
            commonResult.setStatus(update > 0 ? "success" : "faild");
            commonResult.setData(update > 0 ? "更新用户成功" : "更新用户失败");
        } else {
            commonResult.setStatus("faild");
            commonResult.setData("用户不存在");
        }

        return commonResult;
    }

    public CommonResult deleteAccount(Account account) {
        CommonResult commonResult = new CommonResult();
        Account o = sqlSessionTemplate.selectOne("com.yuzhe.springboot.dao.AccountDao.selectAccount", account);
        if (o != null) {
            int delete = sqlSessionTemplate.delete("com.yuzhe.springboot.dao.AccountDao.deleteAccount", account);
            commonResult.setStatus(delete > 0 ? "success" : "faild");
            commonResult.setStatus(delete > 0 ? "success" : "faild");
            commonResult.setData(delete > 0 ? "删除用户成功" : "删除用户失败");
        } else {
            commonResult.setStatus("faild");
            commonResult.setData("用户不存在");
        }
        return commonResult;
    }

    public CommonResult getAccount(Account account) {
        CommonResult commonResult = new CommonResult();
        Account o = sqlSessionTemplate.selectOne("com.yuzhe.springboot.dao.AccountDao.selectAccount", account);
        commonResult.setStatus(o != null ? "success" : "faild");
        commonResult.setData(o != null ? o : "没有该用户");
        return commonResult;
    }

    public CommonResult getAllAccount() {
        CommonResult commonResult = new CommonResult();
        List<Account> list = sqlSessionTemplate.selectList("com.yuzhe.springboot.dao.AccountDao.selectAllAccount");
        commonResult.setStatus("success");
        commonResult.setData(list.size() != 0 ? list : "没有数据");
        return commonResult;
    }


}
