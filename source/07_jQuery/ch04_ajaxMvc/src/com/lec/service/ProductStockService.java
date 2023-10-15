package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.daodto.ProductDao;

public class ProductStockService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String pname = request.getParameter("pname");
		ProductDao pDao = ProductDao.getInstance();
		int pStock = pDao.getProductStock(pname);
		if (pStock == -1) {
			request.setAttribute("pStock", "���� ��ǰ");
		} else {	
			request.setAttribute("pStock", "���" + pStock + " ��");
		}
	}
}
