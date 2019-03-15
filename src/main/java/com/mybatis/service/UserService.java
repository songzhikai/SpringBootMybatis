package com.mybatis.service;

import com.mybatis.mapper.UserMapper;
import com.mybatis.model.User;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean addUser(User user){
        try{
            userMapper.insert(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertByBatch(List<User> list){
        try{
            userMapper.insertByBatch(list);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteByUserIdAndUserNames( int userId, String[] userNames){
        try{
            userMapper.deleteByUserIdAndUserNames(2000, userNames);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
