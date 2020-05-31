package com.java.egitim.Ders_Odev;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	
	private static Scanner read; 

	public static void main(String[] args) {
						
		read = new Scanner (System.in );
				   
		
		    Integer sonlandir =0;
	        Integer oda =0; 
			/* OdaBilgisi oda = new OdaBilgisi();
			 * do {
			 * 
			 * System.out.println (
			 * " Oda No ve bilgilerini giriniz. ( Yukseklik - Geniþik - Uzunluk ) : ");
			 * System.out.println("odalar.size() "+odalar.size()); for (int i=0;
			 * i<odalar.size(); i++){ System.out.println("odalar "+odalar.get(i) ); }
			 * 
			 * 
			 * 
			 * System.out.println("Oda ekleyin. Bitirmek için 0 yazabilirsiniz. ");
			 * 
			 * oda = read.nextInt();
			 * 
			 * if (sonlandir.equals(oda) == false) odalar.add(oda); }
			 * while(sonlandir.equals(oda) == false);
			 * 
			 */

		    List<OdaBilgisi> odalarList = new LinkedList<OdaBilgisi>();
            OdaBilgisi odaBilgisi = new OdaBilgisi();
		         int j=0;
			 do {
				   		
		            //System.out.println("odalarList.size() "+odalarList.size());			           
		            for (int i=0; i<odalarList.size(); i++){
		            	OdaBilgisi  row = (OdaBilgisi ) odalarList.get(i);
		            	System.out.println("Oda NO        [ "+i+"] : "+row.getOdaNo());
		            	System.out.println("Oda Geniþlik  [ "+i+"] : "+row.getOdaGenislik());
		            	System.out.println("Oda Yukseklik [ "+i+"] : "+row.getOdaYukseklik());
		            	System.out.println("Oda Uzunluk   [ "+i+"] : "+row.getOdaUzunluk());
		            	}

					System.out.println ( " Oda No ve bilgilerini giriniz. ( Yukseklik - Geniþik - Uzunluk ) : "); 	
		            System.out.println("Oda ekleyin. Bitirmek için 0 yazabilirsiniz. ");
		            
		            oda =read.nextInt();
		            j++; 
		            if( j==1)  
		               odaBilgisi.setOdaNo(oda);
		            if( j==2)  
			           odaBilgisi.setOdaGenislik(oda);
		            if( j==3)  
		               odaBilgisi.setOdaYukseklik(oda);
		            if( j==4)  {
			           odaBilgisi.setOdaUzunluk(oda);
			           odalarList.add(odaBilgisi);
			           odaBilgisi = new OdaBilgisi();
			           j=0;
		            } 		            	
		        } while(sonlandir.equals(oda) == false);
			 
			 
			  List<OdaBilgisi> odalarList1 = new LinkedList<OdaBilgisi>();
			  odalarList1 = odalarList;
			  System.out.println("odalarList.size() "+odalarList.size());	
			  System.out.println("odalarList1.size() "+odalarList1.size());			           
	          
			  for (int k=0; k<odalarList.size(); k++){
		            	OdaBilgisi  row = (OdaBilgisi ) odalarList.get(k);
		            	System.out.println("Oda NO       "+row.getOdaNo());		            	
		            	 for (int m=0; m<odalarList1.size(); m++){
		            		 OdaBilgisi  row1 = (OdaBilgisi ) odalarList.get(m);	 
				            	if ( row1.getOdaNo() != row.getOdaNo() && row.compareTo(row1)==0) {
		            	        	System.out.println("Oda NO   "+row.getOdaNo()+" ile Oda No "+ row1.getOdaNo()+ " EÞIT Bouytlarda");
		            	        	System.out.println("Oda NO       "+row.getOdaNo());
		    		            	System.out.println("Oda Geniþlik "+row.getOdaGenislik());
		    		            	System.out.println("Oda Yukseklik "+row.getOdaYukseklik());
		    		            	System.out.println("Oda Uzunluk   "+row.getOdaUzunluk());
		    		            }
		            	 }
		      } 
			 
	}


}
