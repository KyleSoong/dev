package com.song.dev.service.impl;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import com.song.dev.model.UserAuth;
import com.song.dev.service.IPasswordService;

@Service("passwordService")
public class PasswordServiceImpl implements IPasswordService {
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
        // 将用户的注册密码经过散列算法替换成一个不可逆的新密码保存进数据，散列过程使用了盐
        String newPassword = new SimpleHash(algorithmName, uAuth.getCredential(),
                ByteSource.Util.bytes(uAuth.getCredentialsSalt()), hashIterations).toHex();
        uAuth.setCredential(newPassword);
		return uAuth;
	}

}
