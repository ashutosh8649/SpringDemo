package com.as.springJava;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;


@Component
public class Circle implements Shape, ApplicationEventPublisherAware{

	private Point center;
	private ApplicationEventPublisher publisher;

	public Point getCenter() {
		return center;
	}

	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}
	@Override
	public void draw() {
		
		System.out.println("cicle drawn with centre"+center.getX()+","+center.getY());
		DrawEvent drawEvent=new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	}
	
	@PostConstruct
	public void initializeCircle() {
		System.out.println("init of circle");
	}
	
	@PreDestroy
	public void destroyCircle() {
		System.out.println("destroy of circle");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
				this.publisher=publisher;
	}

}
