package org.ecommerce.order.web.dto;

public class GreetingDto {

	private long id;
	private String content;

	public GreetingDto() {

	}

	public GreetingDto(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

}
