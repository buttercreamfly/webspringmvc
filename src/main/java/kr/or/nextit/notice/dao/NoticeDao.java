package kr.or.nextit.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.or.nextit.notice.model.Contents;

public class NoticeDao {

	
	
	

	private static NoticeDao instance = new NoticeDao(); //null;    MemberDao 처음에는 null
	
	private NoticeDao() {}
		
	public static NoticeDao getInstance() {
		
		if(instance ==null) {
			instance = new NoticeDao();
		}
		
		return instance;
	}
	public List<Contents> selectContentsList(Connection conn) throws Exception {
		
		StringBuffer query = new StringBuffer();
		
		
	query.append(	 " SELECT             "   )   ;
	query.append(  " no,                   "  )   ;
	query.append(  " noti_title,           "  )   ;
	query.append(  " noti_auth,            "  )   ;
	query.append(  " noti_date             "  )   ;
	query.append(  " FROM                  "  )   ;
	query.append(  " tb_notice            "  )   ;
	query.append(  " order by 1  desc     "  )   ;
	                                
		PreparedStatement pstmt = conn.prepareStatement(query.toString());
		List<Contents> contentsList = new ArrayList<Contents>();
		ResultSet rs =pstmt.executeQuery();
		while(rs.next()) {
			Contents contents = new Contents();
			contents.setNo(rs.getInt("no"));
			contents.setNoti_title(rs.getString("noti_title"));
			contents.setNoti_auth(rs.getString("noti_auth"));
			contents.setNoti_date(rs.getString("noti_date"));
			contentsList.add(contents);
		}
		
		
		return contentsList;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
