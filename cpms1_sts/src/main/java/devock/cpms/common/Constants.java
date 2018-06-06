package devock.cpms.common;


/**
 * @ClassName : Constants.java
 * @Description : 프로젝트에서 사용하는 상수들을 관리하는 Interface
 * @Author
 */
public interface Constants {
	static final String errorRequired		 = "errors.required";
	static final String errorEmail 			 = "errors.email";
	static final String errorMinLength		 = "errors.minLength";
	static final String errorMaxLength		 = "errors.maxLength";
	static final String errorPwConfirm		 = "errors.passwordConfirm";
	static final String errorPwCharValid 	 = "errors.pwCharValid";
	static final String errorPhoneNumber	 = "errors.phoneNumber";
	static final String errorNumber			 = "errors.number";
	static final String errorContinuousChar	 = "errors.continuousChar";
	static final String errorOverlapChar	 = "errors.overlapChar";
	static final String errorQwerty 		 = "errors.qwerty";


	
	
	static final String emailRegex			 = "^[_0-9a-zA-Z-\\.]+@[_0-9a-zA-Z-]+\\.([\\._0-9a-zA-Z-]+)*$";
	static final String phoneNumberRegex     = "(01[016789])(\\\\d{3,4})(\\\\d{4})";
	static final String numberRegex			 = "^[0-9]*$";
	static final String numberChrRegex		 = "^[0-9a-zA-Z]$";
	static final String equalsFourChrRegex	 = "^(.)\\1\\1\\1";
	static final String qwertyString		 = "1234567890-=!@#$%^&*()_+qwertyuiop[]"
			+ "QWERTYUIOP{}asdfghjkl;'ASDFGHJKL:zxcvbnm,./ZXCVBNM<>?";
	static final String FAIL				 = "fail";
	static final String SUCCESS				 = "success";
	
	static final String HTTP_BASE_URL		 = "http.base_url";
	

}
