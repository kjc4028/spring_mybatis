package kjc.jc.mybatis;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import kjc.jc.mybatis.Dto.ContentDto1;
import kjc.jc.mybatis.Util.Constant;
import kjc.jc.mybatis.dao.ContentDao;
import kjc.jc.mybatis.dao.IDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private JdbcTemplate template;


	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	public void setTemplate(JdbcTemplate template){
		this.template = template;
		Constant.template = this.template;

	}
	
	@Autowired
	private SqlSession sqlSession;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );

		return "home";
	}

	@RequestMapping("/list")
	public String list(Model model){
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.listDao());

		return "/list";
	}

	@RequestMapping("/list1")
	public String list1(Model model){
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list1", dao.listDao1());
		return "/list1";
	}

	@RequestMapping("/writeView" )
	public String writrForm(Model model){

		return "/writeView";
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="/write1")
	public String write1(HttpServletRequest request, Model model){
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.writeDao1(request.getParameter("bName"), request.getParameter("bTitle"),request.getParameter("bContent") );
		return "redirect:/list1";
	}
	
	@RequestMapping("/contentView")
	public String contentView(@RequestParam(value = "bId") String bId, Model model){
		IDao dao = sqlSession.getMapper(IDao.class);
dao.readcnt(bId);
		ContentDao dao2 = new ContentDao();
		ContentDto1 bbs = dao2.contentView(bId);
		model.addAttribute("content", bbs);
		
		
		
		return "contentViewForm";
	}
	
/*	@RequestMapping("/contentViewForm" )
	public String contentViewForm(Model model){

		return "/contentViewForm";
	}

*/
}
