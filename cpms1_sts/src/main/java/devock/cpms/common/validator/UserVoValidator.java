package devock.cpms.common.validator;

import java.util.Locale;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import devock.cpms.common.Constants;
import devock.cpms.common.logger.LoggerInterceptor;
import devock.cpms.member.service.UserVO;

@Component
public class UserVoValidator implements Validator{
	
	protected Log log = LogFactory.getLog(LoggerInterceptor.class);
	
	@Resource(name = "messageSource")
	private MessageSource message;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		UserVO userVO = (UserVO) target;
		
		log.debug(userVO);
		
		userIdValidChk("userVO.userid", userVO.getUserid(), userVO, errors);
		userNmValidChk("userVO.usernm", userVO.getUsernm(), userVO, errors);
		userpwValidChk("userVO.userpw", userVO.getUserpw(), userVO, errors);
		userpwCfmValidChk("userVO.userpwCfm", userVO.getUserpwCfm(), userVO, errors);
		phoneNumberValidChk("userVO.phoneNumber", userVO.getPhoneNumber(), userVO, errors);
		
	}
	
	private boolean nullOrEmptyChk(String fieldValue) {

		if("".equals(fieldValue) || fieldValue == null) {
			return false;
		}
		
		return true;
	}
	

	
	private String getPropMessage(String string) {
		
		return message.getMessage(string, null, Locale.KOREA);
	}
	
	private boolean emailChk(String userid) {
		String regex = Constants.emailRegex;
		
		if (!userid.matches(regex)) {
			return false;
		}
		
		return true;
	}
	
	private void userIdValidChk(String string, String userid, UserVO userVO, Errors errors) {
		boolean chk = false;
		
		String fieldName = "userid",
			   errorCode = Constants.errorRequired,
			   propFieldName = getPropMessage(string);
			   //propFieldName = message.getMessage(string, null, Locale.KOREA);
		
		chk = nullOrEmptyChk(userid);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName}, null);
		}
		
		// 이메일 유효성 체크 시작
		errorCode = Constants.errorEmail;
		
		chk = emailChk(userid);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName}, null);
		}
		// 이메일 유효성 체크 끝
	}
	
	private void userpwValidChk(String string, String userpw, UserVO userVO, Errors errors) {
		boolean chk = false;
		
		String fieldName = "userpw",
			   errorCode = Constants.errorRequired,
			   propFieldName = getPropMessage(string);
			   //propFieldName = message.getMessage(string, null, Locale.KOREA);
		
		chk = nullOrEmptyChk(userpw);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName}, null);
		}		
	}

	private void userpwCfmValidChk(String string, String userpwCfm, UserVO userVO, Errors errors) {
		boolean chk = false;
		
		String fieldName = "userpwCfm",
			   errorCode = Constants.errorRequired,
			   propFieldName = getPropMessage(string);
			   //propFieldName = message.getMessage(string, null, Locale.KOREA);
		
		chk = nullOrEmptyChk(userpwCfm);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName}, null);
		}		
		
	}
	
	private void userNmValidChk(String string, String usernm, UserVO userVO, Errors errors) {
		boolean chk = false;
		
		String fieldName = "usernm",
			   errorCode = Constants.errorRequired,
			   propFieldName = getPropMessage(string);
			   //propFieldName = message.getMessage(string, null, Locale.KOREA);
		
		chk = nullOrEmptyChk(usernm);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName}, null);
		}		
		
	}
	
	private void phoneNumberValidChk(String string, String phoneNumber, UserVO userVO, Errors errors) {
		boolean chk = false;
		
		String fieldName = "phoneNumber",
			   errorCode = Constants.errorRequired,
			   propFieldName = getPropMessage(string);
			   //propFieldName = message.getMessage(string, null, Locale.KOREA);
		
		chk = nullOrEmptyChk(phoneNumber);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName}, null);
		}	
		
		// 전화번호 형식 유효성 체크 시작
		errorCode = Constants.errorPhoneNumber;
		
		chk = phonenumberChk(phoneNumber);
		
		if (!chk) {
			errors.rejectValue(fieldName, errorCode, new Object[] {propFieldName}, null);
		}	
		// 전화번호 형식 유효성 체크 끝
		
	}

	private boolean phonenumberChk(String phoneNumber) {
		String regex = Constants.phoneNumberRegex;
		
		/* 임시 처리
		if (!phoneNumber.matches(regex)) {
			return false;
		}
		*/
		
		return true;
	}
	
}
