package com.shop.dto;

import org.springframework.stereotype.Component;

@Component
public class CompanyDTO {
	
	private int comp_id;
	private String comp_title;
	private String comp_description ;
	
	public CompanyDTO() {
		// TODO Auto-generated constructor stub
	}
	public CompanyDTO(int comp_id, String comp_title, String comp_description) {
		super();
		this.comp_id = comp_id;
		this.comp_title = comp_title;
		this.comp_description = comp_description;
	}
	
	
	public int getComp_id() {
		return comp_id;
	}
	public void setComp_id(int comp_id) {
		this.comp_id = comp_id;
	}
	public String getComp_title() {
		return comp_title;
	}
	public void setComp_title(String comp_title) {
		this.comp_title = comp_title;
	}
	public String getComp_description() {
		return comp_description;
	}
	public void setComp_description(String comp_description) {
		this.comp_description = comp_description;
	}
	@Override
	public String toString() {
		return "CompanyDTO [comp_id=" + comp_id + ", comp_title=" + comp_title + ", comp_description="
				+ comp_description + "]";
	}
	
	
	
	
	
	

}
