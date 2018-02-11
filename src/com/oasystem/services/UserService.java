package com.oasystem.services;

import java.util.List;

import com.oasystem.pojo.TUser;

public interface UserService {

	void saveUser(TUser tuser);

	List<TUser> findAll();

	TUser queryUser(TUser loginUser);

	/*List<TUser> selectByName(TUser user);*/

}
