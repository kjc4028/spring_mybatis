package kjc.jc.mybatis.dao;

import java.util.ArrayList;


import kjc.jc.mybatis.Dto.BoardDto;
import kjc.jc.mybatis.Dto.ContentDto;
import kjc.jc.mybatis.Dto.ContentDto1;


public interface IDao  {
	
	
	

	public ArrayList<ContentDto> listDao();
	public void writeDao(String mWriter, String mContent);
	public ContentDto viewDao(String strID);
	public void deleteDao(String bId);
	
	
	public ArrayList<BoardDto> listDao1();
	public void writeDao1(
	String bName,
	String bTitle,
	String bContent
);
	
	
	public ContentDto1 contentView(int in);
	public void readcnt(String bId);
	
	
	
	

}
