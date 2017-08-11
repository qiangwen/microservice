package com.wind.web.fallback;

import org.springframework.stereotype.Component;

import com.wind.web.api.UserClientApi;

@Component
public class UserClientFallback implements UserClientApi {

	@Override
	public String getUserName(int userId) {
		// TODO Auto-generated method stub
		return "no get username,userid is :" + userId;
	}

	@Override
	public String getUserSimplename(int id) {
		// TODO Auto-generated method stub
		return "no get usersimplename,userid is :" + id;
	}

}
