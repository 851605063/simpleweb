package com.qfggk.simpleweb.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qfggk.simpleweb.bean.User;
import com.qfggk.simpleweb.mapper.UserMapper;
import com.qfggk.simpleweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp extends ServiceImpl<UserMapper,User> implements UserService {



}
