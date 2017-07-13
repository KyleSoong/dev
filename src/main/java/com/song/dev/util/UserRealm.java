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
import com.song.dev.service.IPasswordService;
import com.song.dev.service.IUserService;

public class UserRealm extends AuthorizingRealm {
	@Resource
	private IUserService userService;
	@Resource
	private IPasswordService passwordService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		System.out.println("doGetAuthorizationInfo");
		SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
//		Long userId = TokenManager.getUserId();
//		//根据用户ID查询角色（role），放入到Authorization里。
//		Set<String> roles = roleService.findRoleByUserId(userId);
//		info.setRoles(roles);
//		//根据用户ID查询权限（permission），放入到Authorization里。
//		Set<String> permissions = permissionService.findPermissionByUserId(userId);
//		info.setStringPermissions(permissions);
        return info;  
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken)token;
		UserAuth uAuth = userService.getUserAuthByIdentifier(upToken.getUsername());
		if(uAuth == null){
			throw new UnknownAccountException();
		}else if(!passwordService.passwordCorrect(String.valueOf(upToken.getPassword()), uAuth)){
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
