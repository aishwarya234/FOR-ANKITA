package org.deloitte.sms.studentstaffdetailsmanagement.controller;

import java.util.List;

import org.deloitte.sms.studentstaffdetailsmanagement.beans.StaffInfo;

//import java.util.List;

//import org.deloitte.sms.studentstaffdetailsmanagement.beans.StaffInfo;
import org.deloitte.sms.studentstaffdetailsmanagement.beans.StudentInfo;
import org.deloitte.sms.studentstaffdetailsmanagement.dao.StaffDao;
//import org.deloitte.sms.studentstaffdetailsmanagement.dao.StaffDao;
import org.deloitte.sms.studentstaffdetailsmanagement.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentStaffController {
	@Autowired
	StudentDao dao;
	@Autowired
	StaffDao dao1;
	
	
	
	@RequestMapping(value="/viewscreen",method=RequestMethod.GET)
	public String  showViewScreen(){
		return "ViewScreen";
		}
	
	
	//for displaying studentinfo table
	@RequestMapping(value="/viewstudent")
	public ModelAndView getStudent(){
		
		ModelAndView mav=new ModelAndView();
		List<StudentInfo> list=dao.getStudents();
		mav.addObject("student",list);
		mav.setViewName("ViewStudent");
		return mav;	
		
	}
	
	@RequestMapping(value="/studentupdate",method=RequestMethod.GET)
	public ModelAndView showUpdateStudentForm(@RequestParam("code")String code){
		StudentInfo std=dao.getStudents(code); 
		ModelAndView mav=new ModelAndView();
		mav.addObject("std",std);
		mav.setViewName("UpdateStudent");
		return mav;
	}
	
	/*@RequestMapping(value="/updatestudent",method=RequestMethod.POST)
	public ModelAndView updateStudent(@ModelAttribute("student")StudentInfo std){
		
		ModelAndView mav=new ModelAndView();
		dao.studentUpdate(std);
	
		mav.setViewName("red");
		return mav;
	}*/
	@RequestMapping(value="/finalupdatestudent",method=RequestMethod.GET)
	public String  showFinalUpdateStudentForm(){
		
		return "FinalUpdateStudent";
		}
	//--------------------staff-------------------------------------------------------------
	
	
	

	
	//for displaying studentinfo table
	@RequestMapping(value="/viewstaff")
	public ModelAndView getStaff(){
		
		ModelAndView mav=new ModelAndView();
		List<StaffInfo> list1=dao1.getStaffs();
		mav.addObject("staff",list1);
		mav.setViewName("ViewStaff");
		return mav;	
		
	}
	
	
	
	/*@RequestMapping(value="/updatestudent",method=RequestMethod.GET)
	public ModelAndView showUpdateEmployeeForm(int code){
		
		StudentInfo std=dao.getStudents(code);
		ModelAndView mav=new ModelAndView();
		mav.addObject("std",std);
		mav.setViewName("StudentUpdate");
		return mav;
	}*/
	
	/*@RequestMapping(value="/updateemployee",method=RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("staff")StaffInfo stf){
		
		ModelAndView mav=new ModelAndView();
		dao1.studentUpdate(stf);
	
		mav.setViewName("redirect:viewstaff");
		return mav;
	}*/
	
	
	
}
