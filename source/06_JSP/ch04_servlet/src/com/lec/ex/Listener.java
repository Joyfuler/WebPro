package com.lec.ex;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener

public class Listener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) { 
		ServletContextListener.super.contextInitialized(sce);
		// 웹 프로젝트가 메모리에 load되는 시점에 실행됨.
		System.out.println("★★★★★★★★★ch04가 시작될 때(웹 프로젝트가 메모리에 구동 시작)★★★★★★");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	// 웹 프로젝트가 메모리에서 사라질 때 실행됨
		System.out.println("♥♥♥♥♥♥♥♥ ch04가 종료될 때 (웹프로젝트가 메모리에서 해제) ♥♥♥♥♥♥♥♥");
	}

}
