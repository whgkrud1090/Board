package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

public class UserServiceTest {
   private IUserService userService;
   
   @Before
   public void setup() {
      userService = new UserService();
      
   }

   /**
    * 
   * Method : getUserTest
   * 작성자 : PC-07
   * 변경이력 :
   * Method 설명 : 사용자 정보 조회 테스트
    */
   @Test
   public void getUser() {
      /***Given***/
      String userId = "cony";
      
      /***When***/
      User userVo = userService.getUser(userId);
      
      /***Then***/
      assertEquals("코니", userVo.getUserNm());
      assertEquals("cony1234", userVo.getPass());
   }
  
	@Test
	public void ceilingTest() {
		/***Given***/
		int totalCnt = 105;
		int pagesize = 10;

		/***When***/
		double paginationSize = Math.ceil((double)totalCnt / pagesize);
		
		/***Then***/
		assertEquals(11, (int)paginationSize);
	}
	

}