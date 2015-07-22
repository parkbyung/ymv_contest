package org.log5j.ymv.aop.common;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.log5j.ymv.aop.model.CommonService;
import org.log5j.ymv.model.voluntary.VoluntaryServiceApplicateVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//contrxt-component scan 대상이 되도록 하여 컨테이너가 bean을 생성하도록 한다.
@Component
//Aspect 어노테이션을 명시하여 공통기능 정의 빈임을 컨테이너에게 알린다.
@Aspect
public class AroundAspect {
	@Resource(name="commonServiceImpl")
	private CommonService commonService;
	
	private Logger log=LoggerFactory.getLogger(getClass());
	
	/**
	 * 작성자 : 백지영
	 * 내용 : execution는 접근제어자는 public이며 return type은 상관없고 org.log5j 아래의 
	 * 				VoluntaryServiceApplicateService클래스의 reg로 시작하는 메서드 실행시 수행된다.
	 * 				param[0]은 받아온 매개변수를 저장하는데 VoluntaryServiceApplicateVO에 그 정보를 담아준다.
	 * 				받아온 정보 중 findIdentityNoByMemberNo를 사용해 회원번호로 해당 회원의 생년월일을 가져오고
	 * 				findFieldByRecruitNo를 사용해 글 번호로 해당 글의 분야를 받아온다.
	 *				saveStatistics를 이용해 조건에 따라 update, insert를 해준다.
	 * @param point : JoinPoint는 호출되는 대상 객체, 메서드, 전달되는 파라미터 목록에 접근할 수 있는 메서드를 제공
	 * @throws SQLException
	 */
	@After("execution(public * org.log5j..VoluntaryServiceApplicateService.reg*(..))")
	public void afterLog(JoinPoint point) throws SQLException{
		Object param[]=point.getArgs();// 메서드 인자값 - 매개변수
		VoluntaryServiceApplicateVO vvo = (VoluntaryServiceApplicateVO) param[0];
		String ageString = commonService.findIdentityNoByMemberNo(vvo.getMemberNo());
		int age = Integer.parseInt(ageString);
		String field = commonService.findFieldByRecruitNo(vvo.getRecruitNo());
		commonService.saveStatistics(age, field);
	}
	
	
}

