package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;

public class User {
	private static final Logger logger = LoggerFactory.getLogger(User.class);
	
	private String userId;		//사용자 아이디
	private String pass;		//사용자 비밀번호
	private String userNm;		//사용자 이름
	private String alias;		//별명
	private Date reg_dt;		//등록일
	private String addr1;		//주소1
	private String addr2;		//주소2
	private String zipcode;		//우편번호
	private String filename;
	private String realfilename;
	private String realfilename2;


	public String getRealfilename2() {
		return realfilename2;
	}


	public void setRealfilename2(String realfilename2) {
		this.realfilename2 = realfilename2;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public String getRealFilename() {
		return realfilename;
	}


	public void setRealFilename(String realfilename) {
		this.realfilename = realfilename;
	}


	
	
	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public User(String userName) {
		this.userNm = userName;
	}
	
	public User() {
	}


	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Date getReg_dt() {
		return reg_dt;
	}
	
	public String getReg_dt_fmt() {
		logger.debug("getReg_dt_fmt method call");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(reg_dt);
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	
	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", pass=" + pass + ", userNm=" + userNm + ", alias=" + alias + ", reg_dt="
				+ reg_dt + ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcode=" + zipcode + ", filename=" + filename
				+ ", realfilename=" + realfilename + ", realfilename2=" + realfilename2 + "]";
	}


	//로그인을 확인하는 메서드 -> 비밀번호
	public boolean checkLoginValidate(String userId, String pass) {
		
		//암호화 문장끼리 비교
		if(userId.equals(this.userId) && KISA_SHA256.encrypt(pass).equals(this.pass))
			return true;
		
		return false;
	}
	
}








