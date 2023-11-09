package kr.ncspartner.model;

public class Crudtable {
	private int crud_id = 0;
	private String crud_name = "";
	private String mobile = "";

	public int getCrud_id() {
		return crud_id;
	}

	public void setCrud_id(int crud_id) {
		this.crud_id = crud_id;
	}

	public String getCrud_name() {
		return crud_name;
	}

	public void setCrud_name(String crud_name) {
		this.crud_name = crud_name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
