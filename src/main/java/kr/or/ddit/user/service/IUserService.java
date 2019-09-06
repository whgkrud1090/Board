package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

public interface IUserService {
	
	/**
	* Method : getUserList
	* 작성자 : SEM-PC
	* 변경이력 :
	* @return
	* Method 설명 :전체 사용자 리스트 조회
	*/
	List<User> getUserList();

	/**
	* Method : getUser
	* 작성자 : SEM-PC
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 상세조회
	*/
	User getUser(String userId);


}

	
	
	
	
	