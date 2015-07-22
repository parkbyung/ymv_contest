package org.log5j.ymv.aop.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.log5j.ymv.controller.NoLoginCheck;
import org.log5j.ymv.model.statistics.StatisticsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommonController {
	@Resource(name="statisticsServiceImpl")
	private StatisticsService statisticsService;

	/**
	 * 작성자 : 백지영
	 * 내용 : 통계DB에서 신청자 수가 많은 봉사 분야별로 순위를 매긴 정보를 가져와 List에 담아서 
	 * 				voluntary_statistics.jsp로 보내준다.
	 * @param model : List에 통계DB에서 신청자 수가 많은 봉사 분야별로 순위를 매긴 정보를 담아 view에서 보여주기 위해 사용
	 * @return String : "voluntary_statistics"
	 * @throws SQLException
	 */
	@RequestMapping("voluntary_statistics.ymv")
	@NoLoginCheck
	public String voluntaryFindStatistics(Model model) throws SQLException{
		List<Map<String, Object>> list = statisticsService.findStatisticsList();
		model.addAttribute("list", list);
		System.out.println("list   " + list);
		/*for (int i = 0; i < list.size(); i++) {
			model.addAttribute("map" + i, list.get(i));
			System.out.println(list.get(i));
			if((list.get(i)).get("FIELD").equals("환경")){
				model.addAttribute("environmentValue",(list.get(i)).get("COUNT"));
				System.out.println((list.get(i)).get("COUNT"));
			}
			if((list.get(i)).get("FIELD").equals("노인")){
				model.addAttribute("oldValue",(list.get(i)).get("COUNT"));
				System.out.println((list.get(i)).get("COUNT"));
			}
			if((list.get(i)).get("FIELD").equals("아동")){
				model.addAttribute("newValue",(list.get(i)).get("COUNT"));
				System.out.println((list.get(i)).get("COUNT"));
			}
			if((list.get(i)).get("FIELD").equals("동물")){
				model.addAttribute("animalValue",(list.get(i)).get("COUNT"));
				System.out.println((list.get(i)).get("COUNT"));
			}
			if((list.get(i)).get("FIELD").equals("장애")){
				model.addAttribute("disabilityValue",(list.get(i)).get("COUNT"));
				System.out.println((list.get(i)).get("COUNT"));
			}
		}*/
		return "voluntary_statistics";
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : header에서 나이별 선호봉사를 클릭하면 voluntary_statisticsByAge로 보내준다.
	 * 				직접적인 메서드 사용은 없지만 타일즈 적용을 위해서 필요하다.
	 * @return String : "voluntary_statisticsByAge"
	 */
	@RequestMapping("voluntary_statisticsByAge.ymv")
	@NoLoginCheck
	public String voluntaryFindStatisticsByAge(Model model) throws SQLException{
		
		return "voluntary_statisticsByAge";
	}
	
	/**
	 * 작성자 : 백지영
	 * 내용 : ajax를 사용해 각 나이 버튼을 누를 때마다 각 나이대 별 신청자 수가 많은 봉사를 분야별로 정보를 3위까지
	 * 				가져와서 List에 담아 보내준다.
	 * @param request : age를 받아오기 위해서 사용
	 * @param model : list에 통계DB에서 신청자 수가 많은 봉사를 분야별, 나이대별로 순위를 매긴 정보를 담기 위해 사용  
	 * @return list
	 */
	@RequestMapping("voluntary_selectStatisticsByAge.ymv")
	@NoLoginCheck
	@ResponseBody
	public List selectStatisticsByAge(HttpServletRequest request, Model model){
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("1234age      "+age);
		List<Map<String, Object>> list = statisticsService.findStatisticsListByAge(age);
		model.addAttribute("list", list);
		System.out.println("list   " + list);
		/*for (int i = 0; i < list.size(); i++) {
			model.addAttribute("map" + i, list.get(i));
			System.out.println(list.get(i));
			if((list.get(i)).get("FIELD").equals("환경")){
				model.addAttribute("environmentValue",(list.get(i)).get("APPLICATE_COUNT"));
				System.out.println((list.get(i)).get("APPLICATE_COUNT"));
			}
			if((list.get(i)).get("FIELD").equals("노인")){
				model.addAttribute("oldValue",(list.get(i)).get("APPLICATE_COUNT"));
				System.out.println((list.get(i)).get("APPLICATE_COUNT"));
			}
			if((list.get(i)).get("FIELD").equals("아동")){
				model.addAttribute("newValue",(list.get(i)).get("APPLICATE_COUNT"));
				System.out.println((list.get(i)).get("APPLICATE_COUNT"));
			}
			if((list.get(i)).get("FIELD").equals("동물")){
				model.addAttribute("animalValue",(list.get(i)).get("APPLICATE_COUNT"));
				System.out.println((list.get(i)).get("APPLICATE_COUNT"));
			}
			if((list.get(i)).get("FIELD").equals("장애")){
				model.addAttribute("disabilityValue",(list.get(i)).get("APPLICATE_COUNT"));
				System.out.println((list.get(i)).get("APPLICATE_COUNT"));
			}
		}*/
		return list;
	}
	
}
