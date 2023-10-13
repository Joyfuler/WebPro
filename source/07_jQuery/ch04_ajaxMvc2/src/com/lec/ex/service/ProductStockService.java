package com.lec.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.ex.dao.ProductDao;

public class ProductStockService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {		
		String pname = request.getParameter("pname");
		ProductDao pDao = ProductDao.getInstance();
		int pStock = pDao.getProductStock(pname);
		if (pStock == -1){
			request.setAttribute("pStock", "존재하지 않는 물건입니다.");		
		} else {
			request.setAttribute("pStock", pStock + "개 재고 남음");
		}

	}

}
