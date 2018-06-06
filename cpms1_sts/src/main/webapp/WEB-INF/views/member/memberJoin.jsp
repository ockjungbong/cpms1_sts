<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
	var commonCl = {
		$memberVO : null,

		validInit : function() {
			this.$memberVO = $("#userVO");
			
		},

		validFn : function() {
			
			this.$memberVO.attr("action", "memberJoinValidChk.do");
			
			this.$memberVO.submit();

			
		}
	}

	$(function() {
		commonCl.validInit();

		$("#withBtn").click(function() {			
			commonCl.validFn();
		});

	})
</script>
<body>
	<div id="wrapper">
		<div id="page-wrapper" style="min-height: 683px;">

			<div class="content">
				<div class="container">
					<div class="row">
						<div class="col-md-8 col-md-offset-2">
							<div class="header-text">
								<h2>회원가입</h2>
						
								<hr />
							</div>
						</div>
						<div class="col-md-4 col-md-offset-2">
							<div class="media">
								<div class="media-left">
									<div class="icon">
										<i class="pe-7s-user"></i>
									</div>
								</div>
								<div class="media-body">
									<h4>회원가입 하는곳</h4>
									이름과 아이디를 적으시고 이름과 아이디를 적으시되 이름과 아이디는 적으세요.
								</div>
							</div>
							<div class="media">
								<div class="media-left">
									<div class="icon">
										<i class="pe-7s-graph1"></i>
									</div>
								</div>
								<div class="media-body">
									<h4>비밀번호 규칙</h4>
									비밀번호는 자유롭게 4자리 이상으로 적어주시고 특수문자는 빼주세요. 같은번호를 반복해서 쓰거나 자신의 생년월일을
									비번으로 하지마세요~
								</div>
							</div>
						</div>

						<form:form commandName="userVO">
							<div class="col-md-4 col-md-offset-s1">
								<div class="card card-plain">
									<div class="content">
										<div class="form-group">
											<form:input path="userid" type="text" title="이메일"
												placeholder="이메일" class="form-control" maxlength="30" />
											<form:errors path="userid" />
										</div>
										<div class="form-group">
											<form:input path="userpw" type="password" title="비밀번호"
												placeholder="비밀번호" class="form-control" maxlength="20" />
											<form:errors path="userpw" />
										</div>
										<div class="form-group">
											<form:input path="userpwCfm" type="password" title="비밀번호 확인"
												placeholder="비밀번호 확인" class="form-control" maxlength="20" />
											<form:errors path="userpwCfm" />
										</div>
										<div class="form-group">
											<form:input path="usernm" type="text" title="이름"
												placeholder="이름" class="form-control" maxlength="20" />
											<form:errors path="usernm" />
										</div>
										<div class="form-group">
											<form:input path="phoneNumber" type="text" title="전화번호"
												placeholder="전화번호" class="form-control" maxlength="11" />
											<form:errors path="phoneNumber" />
										</div>
									</div>
									<div class="g-recaptcha"
										data-sitekey="6Le8rVQUAAAAAK7FlRuLVU-7En1te3iwir7EHGrc"></div>
									<div class="footer text-center">
										<input type="button" class="btn btn-fill btn-neutral btn-wd"
											id="withBtn" value="저와 함께하는 버튼" />
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
