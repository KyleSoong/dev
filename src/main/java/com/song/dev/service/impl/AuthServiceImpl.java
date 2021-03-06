package com.song.dev.service.impl;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import com.song.dev.model.UserAuth;
import com.song.dev.service.IAuthService;

@Service("authService")
public class AuthServiceImpl implements IAuthService {
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private final int hashIterations = 2;
	@Override
	public String encryptPassword(String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAuth encryptPassword(UserAuth uAuth) {
		// User对象包含最基本的字段Username和Password
        uAuth.setSalt(randomNumberGenerator.nextBytes().toHex());
        uAuth.setCredential(encrypt(uAuth.getCredential(), uAuth.getSalt()));
		return uAuth;
	}
	
	private String encrypt(String str, String salt){
		if (StringUtils.isBlank(str) || StringUtils.isBlank(salt)){
			return null;
		}
		// 将用户的注册密码经过散列算法替换成一个不可逆的新密码保存进数据，散列过程使用了盐
		String encryptStr = new SimpleHash(algorithmName, str,
				ByteSource.Util.bytes(salt), hashIterations).toHex();
		return encryptStr;
	}

	@Override
	public boolean passwordCorrect(String password, UserAuth uAuth) {
		String encyptPassword = encrypt(password, uAuth.getSalt());
		return uAuth.getCredential().equals(encyptPassword);
	}
}
