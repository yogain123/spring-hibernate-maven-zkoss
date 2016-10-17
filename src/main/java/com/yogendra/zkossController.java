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
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

public class zkossController extends GenericForwardComposer{
	
	@Wire
	Intbox id;
	
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
	
	@Wire
	Textbox del;
	
	 @Override
		public void doAfterCompose(Component comp) throws Exception{
			super.doAfterCompose(comp);
	    }
	
	
	//public static void main(String[] args) { 
	
	//@Listen("onClick = save")
	 
	 Resource r=new ClassPathResource("applicationContext.xml");
		//ApplicationContext context = new XmlClassPathApplicationContext("applicationContext.xml");
	    BeanFactory factory=new XmlBeanFactory(r);  
	      
	    EmployeeDao dao=(EmployeeDao)factory.getBean("d"); 
	 
	public void onClick$save(){
		//System.out.println("inside");
	      
	   
	    
	    Employee e=new Employee();
	    
	    e.setName(name.getValue());
		e.setAge(age.getValue());
		e.setPhone(phone.getValue());
		e.setId(id.getValue());
		
		dao.saveEmployee(e);
	}
	
	public void onClick$del(){
	
		Employee eDel = new Employee();
	
		
		eDel.setId(id.getValue());
		dao.deleteEmployee(eDel);
		
		
		
	
	}
	
	public void onClick$update(){
		
		Employee eUpdate = new Employee();
		eUpdate.setId(id.getValue());
		eUpdate.setName(name.getValue());
		eUpdate.setAge(age.getValue());
		eUpdate.setPhone(phone.getValue());
		dao.updateEmployee(eUpdate);
	}
	     
	   
			//refreshProfileView();
		
		//name.setValue(e.getName());
		//age.setValue(e.getAge());
		//phone.setValue(e.getPhone());
		}
	
	
	//services
		//AuthenticationService authService = new AuthenticationServiceChapter5Impl();
		//UserInfoService userInfoService = new UserInfoServiceChapter5Impl();

