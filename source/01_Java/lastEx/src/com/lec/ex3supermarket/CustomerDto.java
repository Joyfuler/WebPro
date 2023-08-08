package com.lec.ex3supermarket;
// CID,CNAME,CPOINT,CAMOUNT,LEVELNAME,FORLEVELUP
public class CustomerDto {	
	private int cid;
	private String ctel;
	private String cname;
	private int cpoint;
	private int camount;
	private String levelName;
	private int forLevelUp;
			
	public CustomerDto() {}

	
	public CustomerDto(int cid, String ctel, String cname, int cpoint, int camount, String levelName, int forLevelUp) {
		this.cid = cid;
		this.ctel = ctel;
		this.cname = cname;
		this.cpoint = cpoint;
		this.camount = camount;
		this.levelName = levelName;
		this.forLevelUp = forLevelUp;
	}


	@Override
	public String toString() {
		return cid + "\t" + ctel + "\t" + cname + "\t" + cpoint + "\t"
				+ camount + "\t" + levelName + "\t" + forLevelUp;
	}

	
	
}
