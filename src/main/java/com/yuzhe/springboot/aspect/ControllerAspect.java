package com.yuzhe.springboot.aspect;

import com.yuzhe.springboot.entities.Account;
import com.yuzhe.springboot.entities.CommonResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Aspect
@Component
@Lazy(value = false)
public class ControllerAspect {

    public static final String REGEX_ACCOUNT = "^[a-zA-Z0-9]\\w{5,12}";
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,12}";

    @Pointcut("execution(* com.yuzhe.springboot.controller.AccountController.*Account(..))")
    private void accountMethod(){

    }

    @Pointcut("execution(* com.yuzhe.springboot.controller.AccountController.*To(..))")
    public void toMethod(){

    }
    @Around("accountMethod()")
    public CommonResult aroundAccount(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if(args.length>0){
            Account o = (Account)args[0];
            String account = o.getAccount();
            String password = o.getPassword();
            System.out.printf("用户名:%s\t密码:%s\n",account,password);
            System.out.printf("用户名格式:%s\t密码格式:%s\n",checkAccount(account)?"正确":"错误",checkPassword(password)?"正确":"错误");
            if(!(checkAccount(account)&&checkPassword(password)))
                return new CommonResult("faild","用户名或密码格式错误");
            return (CommonResult)joinPoint.proceed();
        }else{
            return (CommonResult) joinPoint.proceed();
        }
    }

    @Around("toMethod()")
    public CommonResult aroundTo(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if(args.length>0){
            Account o = (Account)args[0];
            String account = o.getAccount();
            String password = o.getPassword();
            System.out.printf("用户名:%s\n",account);
            System.out.printf("用户名格式:%s\t\n",checkAccount(account)?"正确":"错误");
            if(!checkAccount(account))
                return new CommonResult("faild","用户名或密码格式错误");
            return (CommonResult)joinPoint.proceed();
        }else{
            return (CommonResult) joinPoint.proceed();
        }
    }

    public boolean checkAccount(String account){
        return Pattern.matches(REGEX_ACCOUNT,account);
    }

    public boolean checkPassword(String password){
        return Pattern.matches(REGEX_PASSWORD,password);
    }
}
