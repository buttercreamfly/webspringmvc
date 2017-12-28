package kr.or.nextit.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


//@MultipartConfig(
//		location="/uploadTemp",                // 임시파일 저장 폴더
//		maxFileSize=1024*1024*10,       	   //파일의 최대 크기 
//		maxRequestSize=1024*1024*100, 		   //-1 제한 없음. 전체 요청 데이터의 최대 크기
//		fileSizeThreshold=1024*1024*10			//임시저장 파일로 저장할 것인지 결정하는 파일 크기. 용량보다 크면 location에 저장. 그 아래면 메모리에 저장
//)
//@WebServlet(urlPatterns="/upload", loadOnStartup=1)
public class Uploadservlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("파일업로드 서블릿 기동");
		
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		
		writer.println("<html>");
		writer.println("<head><title>파일업로드 예제</title></head>");
		
		
		writer.println("<body>");
		
		
		String contentType = request.getContentType();
		if(contentType !=null && contentType.startsWith("multipart/")) {
			
		Collection<Part> parts = request.getParts();
			
		
		for(Part part: parts) {
			
			String name = part.getName(); //파라미터 이름.
			String type= part.getContentType(); //컨텐트 타입.
			String disposition = part.getHeader("Content-Disposition");
			
			if(disposition.contains("filename=")) {
				//파일정보
				writer.println("<br>파일 사이즈:"+part.getSize());
				writer.println("<br>파일명 :"+part.getSubmittedFileName());
				
				//파일 저장
				if(part.getSize() >0) {
					part.write("/uploadFiles/"+part.getSubmittedFileName());  //파일저장
					part.delete(); //임시 저장파일 삭제
				}
				
			}else {
				//일반 파라미터
				
				writer.println("<br>"+name+ "="+request.getParameter(name));				
			}
			writer.println("<hr>");			
			
		}
	}
		
		
		writer.println("<body>");		
		writer.println("</html>");
		
		
	}
	
}










