package com.example.test1;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class course{
	String name;
	String lecturer;
	double credit;
	int weekFrom,weekTo;
	
	public course(String name, String lecturer, double credit, int weekFrom,
			int weekTo) {
		this.name = name;
		this.lecturer = lecturer;
		this.credit = credit;
		this.weekFrom = weekFrom;
		this.weekTo = weekTo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLecturer() {
		return lecturer;
	}
	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public int getWeekFrom() {
		return weekFrom;
	}
	public void setWeekFrom(int weekFrom) {
		this.weekFrom = weekFrom;
	}
	public int getWeekTo() {
		return weekTo;
	}
	public void setWeekTo(int weekTo) {
		this.weekTo = weekTo;
	}
}
class Attendance{
	String courseName;
	String place;
	int periodFrom,periodTo;
	
	public Attendance(String courseName, String place, int periodFrom,
			int periodTo) {
		super();
		this.courseName = courseName;
		this.place = place;
		this.periodFrom = periodFrom;
		this.periodTo = periodTo;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getPeriodFrom() {
		return periodFrom;
	}
	public void setPeriodFrom(int periodFrom) {
		this.periodFrom = periodFrom;
	}
	public int getPeriodTo() {
		return periodTo;
	}
	public void setPeriodTo(int periodTo) {
		this.periodTo = periodTo;
	}
	
}
class schedule{
	String day;
    ArrayList<Attendance> attendance;
	public schedule(String day, ArrayList<Attendance> attendance) {
		super();
		this.day = day;
		this.attendance = attendance;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public ArrayList<Attendance> getAttendance() {
		return attendance;
	}
	public void setAttendance(ArrayList<Attendance> attendance) {
		this.attendance = attendance;
	}
    
}
public class CurriculumXMLHandler extends DefaultHandler {
	public ArrayList<course> courses;
	public ArrayList<schedule> timeTable;
	course tempCourse =null;
	schedule tempSchedule = null;
	Attendance tempAttendance = null;
	boolean isCourse=false,isTimeTable = false;
	static final String[] days= new String[]{"MON","TUE","WED","THE","FRI","SAT","SUM"};
	CurriculumXMLHandler(){
		for(int i=0;i<7;i++){
			timeTable.add(new schedule(days[i],null));
		}
	}
	/**
     * This will be called when the tags of the XML starts.
     **/
	@Override
	public void startElement(String uri,String localName,String qName,Attributes attributes ) throws SAXException{
		if(localName.equals("")){
			
		}
	}
	/**
     * This will be called when the tags of the XML end.
     **/
	@Override
	public void endElement(String uri,String localName,String qName) throws SAXException{
		
	}
	 /**
     * This is called to get the tags value
     **/
	@Override
	public void characters(char[] ch,int start,int length)throws SAXException{
		
	}
}
