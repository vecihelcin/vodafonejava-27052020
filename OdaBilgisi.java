package com.java.egitim.Ders_Odev;

public class OdaBilgisi {
	
	private Integer odaNo;
	private Integer odaUzunluk;
	private Integer odaGenislik;
	private Integer odaYukseklik;
	
	public OdaBilgisi 	() {
		this.odaNo=0;
		this.odaGenislik=0;
		this.odaUzunluk=0;
		this.odaYukseklik=0;		
	}
		
	public OdaBilgisi ( OdaBilgisi oteki ) {
		this.odaNo=oteki.odaNo;
		this.odaGenislik=oteki.odaGenislik;
		this.odaUzunluk=oteki.odaUzunluk;
		this.odaYukseklik=oteki.odaYukseklik;		
	}

	public OdaBilgisi(Integer no, Integer g, Integer u, Integer y) {
		// TODO Auto-generated constructor stub
		if (no != null ) {
			this.odaNo = no;
		}
		if (g != null ) {
			this.odaGenislik = g;
		}
		if (u != null ) {
			this.odaUzunluk = u;
		}

		if (y != null ) {
			this.odaYukseklik = y;
		}
	}
	
	public Integer  compareTo( Object to) {
		OdaBilgisi oteki = null ;
		 
		if (to instanceof OdaBilgisi) {
			oteki= (OdaBilgisi) to;
			
			Integer genislikCompare = this.getOdaGenislik().compareTo(oteki.getOdaGenislik());
			
			if (genislikCompare  !=0) {
				return genislikCompare;
			}else {
				
				Integer uzunlukCompare = this.getOdaUzunluk().compareTo(oteki.getOdaUzunluk());
				
				if (uzunlukCompare  !=0) {
					return uzunlukCompare;
				}else {
					Integer yukseklikCompare = this.getOdaYukseklik().compareTo(oteki.getOdaYukseklik());
						 
				    return yukseklikCompare;
				}					
			} 				
		} else		{
			return -1;
		}
	}

	public Integer getOdaUzunluk() {
		return odaUzunluk;
	}

	public void setOdaUzunluk(Integer odaUzunluk) {
		if (odaUzunluk >0) 
		this.odaUzunluk = odaUzunluk;
	}

	public Integer getOdaGenislik() {
		return odaGenislik;
	}

	public void setOdaGenislik(Integer odaGenislik) {
		if (odaGenislik >0)   
		this.odaGenislik = odaGenislik;
	}

	public Integer getOdaYukseklik() {
		return odaYukseklik;
	}

	public void setOdaYukseklik(Integer d) {
		if (d >0)  
		this.odaYukseklik = d;
	}

	public Integer getOdaNo() {
		return odaNo;
	}

	public void setOdaNo(Integer odaNo) {
		this.odaNo = odaNo;
	}

}
