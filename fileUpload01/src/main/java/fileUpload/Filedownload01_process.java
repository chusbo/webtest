package fileUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Filedownload01_process
 */
@WebServlet("/download.do")	//download.do 경로로 매핑
public class Filedownload01_process extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}	//request,rsponse를 매개변수로 갖는 doHandle 호출

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}	//request,rsponse를 매개변수로 갖는 doHandle 호출
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");			//인코딩을 utf-8로 설정
		response.setContentType("text/html; charset=utf-8");	//contentType을 text나 html으로 설정하며 인코딩은 utf-8로 설정
		
		String file_repo = "C:\\file_repo";		// C:\\file_repo 해당 경로를 매개변수에 저장
		String fileName = (String) request.getParameter("fileName");	//request에서 fileName을 가져와 매개변수에 저장 
		
		System.out.println("fileName=" + fileName); //filename을 출력
		OutputStream out = response.getOutputStream();	//response 객체에서 출력 스트림으로 출력
		
		String downFile = file_repo + "\\" + fileName;	//다운로드할 전체 경로와 파일명을 가져와 매개변수로 저장
		File f = new File(downFile);		//다운로드할 파일을 가르키는 File 객체를 생성
		
		response.setHeader("Cache-Control", "no-cache");	//캐시를 저장하지 않고 항상 새로 가져옴
		response.addHeader("Content-disposition", "attachment; fileName=" + fileName); 	//해당 fileName으로 다운로드 진행
		
		FileInputStream in = new FileInputStream(f); //File객체를 가져오는 inputstream 생성
		
		byte[] buffer = new byte[1024 * 8];	//8키로바이트씩 나눠서 버퍼에 저장
		while (true) {
			int count = in.read(buffer);	//파일에 buffer만큼 읽어들임, 읽어드린 수를 count에 저장
			if(count == -1)					//count값이 -1(false)가 되면 while문 종료
				break;
			out.write(buffer, 0, count);	//out객체에 write를 이용해 buffer에 0인덱스부터 count 된 인덱스까지 출력
		}
		in.close();		//in 객체 닫음(나중에 실행)
		out.close();	//out 객체 닫음(먼저 실행)
	}

}
