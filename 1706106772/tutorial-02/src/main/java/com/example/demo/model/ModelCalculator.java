package com.example.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ModelCalculator {
	private int num1;
	private int num2;

	String[] angka = { "", "satu", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan", "sepuluh",
			"sebelas" };

	public ModelCalculator() {
		super();
	}

	public int getBilanganSatu() {
		return num1;
	}

	public void setBilanganSatu(int num1) {
		this.num1 = num1;
	}

	public int getBilanganDua() {
		return num2;
	}

	public void setBilanganDua(int num2) {
		this.num2 = num2;
	}

	public int proses(int x, int y) {
		int result = x + y;
		return result;
	}

	public String terbilang(int result) {
		if (result < 12) {
			return angka[(int) result];
		}

		if (result >= 12 && result <= 19) {
			return angka[(int) result % 10] + " belas ";
		}

		if (result >= 20 && result <= 99) {
			return angka[(int) result / 10] + " puluh " + angka[(int) result % 10];
		}

		if (result >= 100 && result <= 199) {
			return "seratus " + terbilang(result % 100);
		}

		if (result >= 200 && result <= 999) {
			return angka[(int) result / 100] + " ratus " + terbilang(result % 100);
		}

		if (result >= 1000 && result <= 1999) {
			return "seribu " + terbilang(result % 1000);
		}

		if (result >= 2000 && result <= 999999) {
			return terbilang((int) result / 1000) + " ribu " + terbilang(result % 1000);
		}

		if (result >= 1000000 && result <= 999999999) {
			return terbilang((int) result / 1000000) + " juta " + terbilang(result % 1000000);
		}

		return "";
	}
}
