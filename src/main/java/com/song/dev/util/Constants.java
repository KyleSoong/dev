package com.song.dev.util;

public class Constants {
	/**性别 */
	public static class Gender{
		public static final int UNKNOW = 0;
		public static final int MALE = 1;
		public static final int FEMALE = 2;
		public static final int FEMALE_TO_MALE = 5;
		public static final int MALE_TO_FEMALE = 6;
		public static final int SECRECT = 9;
	}
	/**验证类型*/
	public static class IdentityType{
		/**用户名登陆*/
		public static final int USERNAME = 0;
		public static final int EMAIL = 1;
		public static final int MOBILE = 2;
		public static final int WECHAT = 3;
	}
}
