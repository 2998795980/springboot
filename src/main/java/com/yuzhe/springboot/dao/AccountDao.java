package com.yuzhe.springboot.dao;

import com.yuzhe.springboot.entities.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountDao {
    @Insert("insert into account values(null,#{account},#{password})")
    public int insertAccount(Account account);

    @Update("update account set password=#{password} where account=#{account}")
    public int updateAccount(Account account);

    @Select("select * from account where account=#{account}")
    public Account selectAccount(Account account);

    @Delete("delete from account where account=#{account}")
    public int deleteAccount(Account account);

    @Select("select * from account")
    public List<Account> selectAllAccount();
}
