package com.yogendra;
import java.util.*;
//import com.yogendra.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
//import org.zkoss.essentials.chapter5.AuthenticationServiceChapter5Impl;
//import org.zkoss.essentials.chapter5.UserInfoServiceChapter5Impl;
//import org.zkoss.essentials.entity.User;
//import org.zkoss.essentials.services.AuthenticationService;
//import org.zkoss.essentials.services.CommonInfoService;
//import org.zkoss.essentials.services.UserCredential;
//import org.zkoss.essentials.services.UserInfoService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

public class zkossController extends GenericForwardComposer{
	
	//Wiring Components
	@Wire
	//static
	Textbox name;
	@Wire
	//static
	Textbox age;
	@Wire
	//static
	Textbox phone;
	
	 @Override
		public void doAfterCompose(Component comp) throws Exception{
			super.doAfterCompose(comp);
	    }
	
	
	//public static void main(String[] args) { 
	
	//@Listen("onClick = save")
	public void onClick$save(){
		System.out.println("inside");
	      
	    Resource r=new ClassPathResource("applicationContext.xml");
		//ApplicationContext context = new XmlClassPathApplicationContext("applicationContext.xml");
	    BeanFactory factory=new XmlBeanFactory(r);  
	      
	    EmployeeDao dao=(EmployeeDao)factory.getBean("d"); 
	    
	    Employee e=new Employee();
	    e.setName(name.getValue());
		e.setAge(age.getValue());
		e.setPhone(phone.getValue());
		e.setId(111);
		
		dao.saveEmployee(e);
	
	}
	     
	   
			//refreshProfileView();
		
		//name.setValue(e.getName());
		//age.setValue(e.getAge());
		//phone.setValue(e.getPhone());
		}
	
	
	//services
		//AuthenticationService authService = new AuthenticationServiceChapter5Impl();
		//UserInfoService userInfoService = new UserInfoServiceChapter5Impl();

