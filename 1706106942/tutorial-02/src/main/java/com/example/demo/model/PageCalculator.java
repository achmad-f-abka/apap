package com.example.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PageCalculator {
	private int bilangansatu;
	private int bilangandua;

	String[] angka = { "", "satu", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan", "sepuluh",
			"sebelas" };

	public PageCalculator() {
		super();
	}

	public int getBilanganSatu() {
		return bilangansatu;
	}

	public void setBilanganSatu(int bilangansatu) {
		this.bilangansatu = bilangansatu;
	}

	public int getBilanganDua() {
		return bilangandua;
	}

	public void setBilanganDua(int bilangandua) {
		this.bilangandua = bilangandua;
	}

	public int proses(int x, int y) {
		int hasil = x + y;
		return hasil;
	}

	public String terbilang(int hasil) {
		if (hasil < 12) {
			return angka[(int) hasil];
		}

		if (hasil >= 12 && hasil <= 19) {
			return angka[(int) hasil % 10] + " belas ";
		}

		if (hasil >= 20 && hasil <= 99) {
			return angka[(int) hasil / 10] + " puluh " + angka[(int) hasil % 10];
		}

		if (hasil >= 100 && hasil <= 199) {
			return "seratus " + terbilang(hasil % 100);
		}

		if (hasil >= 200 && hasil <= 999) {
			return angka[(int) hasil / 100] + " ratus " + terbilang(hasil % 100);
		}

		if (hasil >= 1000 && hasil <= 1999) {
			return "seribu " + terbilang(hasil % 1000);
		}

		if (hasil >= 2000 && hasil <= 999999) {
			return terbilang((int) hasil / 1000) + " ribu " + terbilang(hasil % 1000);
		}

		if (hasil >= 1000000 && hasil <= 999999999) {
			return terbilang((int) hasil / 1000000) + " juta " + terbilang(hasil % 1000000);
		}

		return "";
	}
}
