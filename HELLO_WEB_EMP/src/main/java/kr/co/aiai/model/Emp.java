package kr.co.aiai.model;

public class Emp {
	private String e_id = "";
	private String e_name = "";
	private String gen = "";
	private String addr = "";
	
	public Emp() {
		
	}
	
	public Emp(String e_id, String e_name, String gen, String addr) {
		super();
		this.e_id = e_id;
		this.e_name = e_name;
		this.gen = gen;
		this.addr = addr;
	}

	public String getE_id() {
		return e_id;
	}

	public void setE_id(String e_id) {
		this.e_id = e_id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
}
