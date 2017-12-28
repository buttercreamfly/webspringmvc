package kr.or.nextit.notice.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import kr.or.nextit.common.jdbc.ConnectionProvider;
import kr.or.nextit.notice.dao.NoticeDao;
import kr.or.nextit.notice.model.Contents;

public class NoticeServiceImpl implements NoticeService {
	
	private static NoticeServiceImpl instance = new NoticeServiceImpl();
	
	NoticeDao noticedao=NoticeDao.getInstance();
	
	public static NoticeServiceImpl getInstance() {
		if(instance==null) {
			instance = new NoticeServiceImpl();
		}
		return instance;
	}
	
	
	
	
	private NoticeServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public List<Contents> getContentsList() throws Exception {
		// TODO Auto-generated method stub
		List<Contents> contentsList = new ArrayList<>();
		Connection conn = null;
		
		try {
			conn=ConnectionProvider.getConnection();
		
		contentsList =noticedao.selectContentsList(conn);
		return contentsList;
		}catch(Exception e) {
			throw e;
		}finally {
			conn.close();
		}
		
		
		
		
		
		
	}
	
}
