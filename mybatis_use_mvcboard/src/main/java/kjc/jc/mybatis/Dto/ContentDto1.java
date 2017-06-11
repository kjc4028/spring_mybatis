package kjc.jc.mybatis.Dto;

public class ContentDto1 {

	String bTitle;
	String bContent;
	String bName;
	
	public ContentDto1() {
		// TODO Auto-generated constructor stub
	}

	public ContentDto1(String bTitle, String bContent, String bName) {
		super();
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bName = bName;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}
	
	
}
