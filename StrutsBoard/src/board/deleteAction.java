package board;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.opensymphony.xwork2.ActionSupport;

public class deleteAction extends ActionSupport{
	public static Reader reader;
	public static SqlMapClient sqlMapper;
	
	private boardVO paramClass; //파라미터를 저장할 객체
	private boardVO resultClass; //쿼리 결과 값을 저장할 객체
	
	private int currentPage; //현재 페이지
	
	private String fileUploadPath = "C:/java/upload";
	
	private int no;
	
	//생성자
	public deleteAction()throws IOException{
		reader = Resources.getResourceAsReader("sqlMapConfig.xml");
		//sqlMapConfig.xml파일의 설정내용을 가져온다.
		sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
		//sqlMapConfig.xml의 내용을 적용한 sqlMapper 객체 생성.
		reader.close();
	}
	
	//게시글 글 삭제
	public String execute()throws Exception{
		//파라미터와 리절트 객체 생성.
		paramClass = new boardVO();
		resultClass = new boardVO();
		
		//해당 번호의 글을 가져온다.
		resultClass = (boardVO)sqlMapper.queryForObject("selectOne",getNo());
		
		//서버 파일 삭제
		File deleteFile = new File(fileUploadPath + resultClass.getFile_savname());
		deleteFile.delete();
		
		//삭제할 항목 설정.
		paramClass.setNo(getNo());
		
		//삭제 쿼리 수행.
		sqlMapper.update("deleteBoard",paramClass);
		
		return SUCCESS;
	}

	public boardVO getParamClass() {
		return paramClass;
	}

	public void setParamClass(boardVO paramClass) {
		this.paramClass = paramClass;
	}

	public boardVO getResultClass() {
		return resultClass;
	}

	public void setResultClass(boardVO resultClass) {
		this.resultClass = resultClass;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	

}
