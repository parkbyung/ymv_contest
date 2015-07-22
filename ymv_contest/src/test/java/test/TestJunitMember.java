package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.log5j.ymv.model.voluntary.VoluntaryServiceApplicateService;
import org.log5j.ymv.model.voluntary.VoluntaryServiceApplicateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestJunitMember {
   @Autowired
   private VoluntaryServiceApplicateService s;
   
   @Test
   public void memberTest(){
       /*s.registerVolunteerApplicant(new VoluntaryServiceApplicateVO(44, 1, "dfsdf대라좀"));*/
       
       s.registerVolunteerApplicant(new VoluntaryServiceApplicateVO(102,1,"aaaaa"));
      System.out.println(1);
      //null이 아니면 정상실행, null이면 failures, AssertionError발생
      //아래와 같은 다수의 테스트용 메서드가 있다.
      //Assert.assertNotNull(vo);
   }
}