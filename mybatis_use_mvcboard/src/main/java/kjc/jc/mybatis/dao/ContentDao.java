package kjc.jc.mybatis.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import kjc.jc.mybatis.Dto.ContentDto1;
import kjc.jc.mybatis.Util.Constant;


public class ContentDao {
DataSource dataSource;

JdbcTemplate template;

public ContentDao() {
	// TODO Auto-generated constructor stub
	try {
		Context context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql2");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	this.template = Constant.template;
}

public ContentDto1 contentView(String bId){
	
	String sql = "	select bTitle, bContent, bName from board1 where bId = "+ bId;
	
	return template.queryForObject(sql, new BeanPropertyRowMapper<ContentDto1>(ContentDto1.class));
	
	
}
}
