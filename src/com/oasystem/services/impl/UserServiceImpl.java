package com.oasystem.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oasystem.dao.TRoleMapper;
import com.oasystem.dao.TUserMapper;
import com.oasystem.pojo.TRole;
import com.oasystem.pojo.TUser;
import com.oasystem.services.UserService;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private TUserMapper userRepository;

	@Override
	public void saveUser(TUser tuser) {
		userRepository.insert(tuser);
	}

	@Override
	public List<TUser> findAll() {
		return userRepository.findAll();
	}
	/*
	@Override
	public List<TUser> selectByName(TUser user) {
		return userRepository.selectByExample(user);
	}*/

	@Override
	public TUser queryUser(TUser loginUser) {
		return userRepository.selectOne(loginUser);
	}

}
