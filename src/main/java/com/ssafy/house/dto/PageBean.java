package com.ssafy.house.dto;

/** UI 화면 페이지에 대한 정보를 표시하는 클래스 */
public class PageBean {
	/** 검색 조건 */
	private String key;
	/** 검색 단어 */
	private String word;
	/** 현재 페이지 번호 */
	private int pageNo;
	/** 한 페이지에 보여주 content 개수 */
	private int interval = 10;

	private int startNo = 1;
	private String pageLink;

	public PageBean() {
	}

	public PageBean(String key, String word, int pageNo) {
		setKey(key);
		setWord(word);
		setPageNo(pageNo);
	}

	public PageBean(String key, String word, String pageNo) {
		setKey(key);
		setWord(word);
		setPageNo(pageNo);
	}

	public int getStartNo() {
		return (pageNo - 1) * interval + 1;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	private void setPageNo(String pageNo) {
		try {
			this.pageNo = Integer.parseInt(pageNo);
		} catch (Exception e) {
			this.pageNo = 1;
		}
	}

	public String getKey() {
		return key;
	}

	public String getKey(String k) {
		if (key != null && key.equals(k)) {
			return "selected='selected'";
		} else {
			return "";
		}
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	@Override
	public String toString() {
		return "PageBean [key=" + key + ", word=" + word + ", pageNo=" + pageNo + ", interval=" + interval + "]";
	}

	public void setPageLink(String pageLink) {
		this.pageLink = pageLink;
	}

	public String getPageLink() {
		return pageLink;
	}
}
