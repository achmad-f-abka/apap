package com.example.demo.controller;

public class Helper {
		
				private final static String[] stringAngka = new String[]{"nol","satu","dua","tiga","empat","lima","enam","tujuh","delapan","sembilan"};
				
				public static String eja(int angka){
					return ribuan(angka);
				}
				
				private static String ribuan(int angka){
					int bagi = angka/1000;
					int sisa = angka%1000;
					return bagi > 0 ? (bagi == 1 ? "seribu " : stringAngka[bagi] + " ribu ") + (sisa != 0 ? ratusan(sisa) : "") : ratusan(sisa);
				}
				private static String ratusan(int angka){
					int bagi = angka/100;
					int sisa = angka%100;
					return bagi > 0 ? (bagi == 1 ? "seratus " : stringAngka[bagi] + " ratus ") + (sisa != 0 ? puluhan(sisa) : "") : puluhan(sisa);
				}
				private static String puluhan(int angka){
					String ejaan = "";
					int bagi = angka/10;
					int sisa = angka%10;
					if(bagi > 0){
						if(bagi == 1){
							if(sisa == 0){
								ejaan = "sepuluh";
							} else if (sisa == 1){
								ejaan = "sebelas";
							} else if (sisa >= 2){
								ejaan = stringAngka[sisa]+" belas";
							}
						} else {
							ejaan = stringAngka[bagi]+" puluh "+ (sisa != 0 ? stringAngka[sisa] : "");
						}
					} else {
						ejaan = stringAngka[sisa]+" ";
					}
					return ejaan;
				}
}
