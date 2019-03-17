package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}

	@RequestMapping("/hello2")
	public String hello2(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello2";
	}

	@RequestMapping(value = { "/hello2", "/hello2/{name}" })
	public String helloPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "Phoenix");
		}
		return "hello2";
	}

	@RequestMapping("/numberCalculator")
	public String numberCalculate(@RequestParam(value = "num1") String num1, @RequestParam(value = "num2") String num2,
			Model model) {

		String[] angka0 = { "", "satu", "dua", "tiga", "empat", "lima", "enam", "tujuh", "delapan", "sembilan",
				"sepuluh" };
		String[] angka00 = { "", "belas", "dua puluh", "tiga puluh", "empat puluh", "lima puluh", "enam puluh",
				"tujuh puluh", "delapan puluh", "sembilan puluh" };
		String[] angka000 = { "", "seratus", "dua ratus", "tiga ratus", "empat ratus", "lima ratus", "enam ratus",
				"tujuh ratus", "delapan ratus", "sembilan ratus" };
		String[] angka0000 = { "", "seribu", "dua ribu", "tiga ribu", "empat ribu", "lima ribu", "enam ribu",
				"tujuh ribu", "delapan ribu", "sembilan ribu" };

		int no1 = Integer.parseInt(num1);
		int no2 = Integer.parseInt(num2);

		int jumlah = no1 + no2;
		if (jumlah < 9999 && jumlah > 0) {
			int a, b, c, d;
			a = jumlah / 1000;
			b = (jumlah % 1000) / 100;
			c = (jumlah % 100) / 10;
			d = jumlah % 10;
			if (c == 1) {
				if (d == 1) {
					model.addAttribute("kata", angka0000[a] + angka000[b] + "se" + angka00[c]);
				} else {
					model.addAttribute("kata", angka0000[a] + angka000[b] + angka0[d] + angka00[c]);
				}
			} else {
				model.addAttribute("kata", angka0000[a] + angka000[b] + angka00[c] + angka0[d]);
			}
		} else {
			model.addAttribute("kata", "salah karena diatas 9999");
		}

		String jumlah2 = Integer.toString(jumlah);
		String hasil = num1 + "+" + num2;
		model.addAttribute("hasil", hasil);
		model.addAttribute("jumlah2", jumlah2);
		return "numberCalculator";
	}
}
