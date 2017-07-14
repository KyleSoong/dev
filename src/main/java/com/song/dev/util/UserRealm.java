package com.song.dev.util;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.song.dev.model.UserAuth;
import com.song.dev.service.IAuthService;
import com.song.dev.service.IUserService;

public class UserRealm extends AuthorizingRealm {
	@Resource
	private IUserService userService;
	@Resource
	private IAuthService authService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		System.out.println("doGetAuthorizationInfo");
		String identifier = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//		authorizationInfo.setRoles(roles);
//		authorizationInfo.setStringPermissions();
        return authorizationInfo;  
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken)token;
		UserAuth uAuth = userService.getUserAuthByIdentifier(upToken.getUsername());
		if(uAuth == null){
			throw new UnknownAccountException();
		}else if(!authService.passwordCorrect(String.valueOf(upToken.getPassword()), uAuth)){
			throw new IncorrectCredentialsException();
		}else if(uAuth.getLocked()){
			throw new DisabledAccountException();
		}else{
		}
		SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(uAuth.getUserId(),
				uAuth.getCredential(), getName());
		return saInfo;
	}

}
