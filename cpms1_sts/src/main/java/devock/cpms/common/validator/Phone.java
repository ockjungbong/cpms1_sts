package devock.cpms.common.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;




@Documented
@Constraint(validatedBy = PhoneValidator.class) //벨리데이션을 PhoneValidator.class 에서 기술하겠다.
@Target({ ElementType.METHOD, ElementType.FIELD }) //어노테이션의 대상을 메서드나 필드(변수)로 하겠다.
@Retention(RetentionPolicy.RUNTIME) //메모리에 등재되는 scope?를 class파일화 해줄때까지 하겠다란 의미.
public @interface Phone {
	String message() default "전화번호 형식이 맞지 않습니다.";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
