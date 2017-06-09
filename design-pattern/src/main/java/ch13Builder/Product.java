package ch13Builder;

import java.util.ArrayList;
import java.util.List;

public class Product {
	List<String> list = new ArrayList<String>(); //产品部件集合
	
	public void add(String s) {
		list.add(s);
	}
	
	public void show() {
		for (String s : list) {
			System.out.println(s);
		}
	}
}
