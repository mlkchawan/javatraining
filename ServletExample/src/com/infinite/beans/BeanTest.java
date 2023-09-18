package com.infinite.beans;
import com.infinite.beans.*;

import java.util.Date;
public class BeanTest {
	public static void main(String...wrg){
		User chawan=new User();
		chawan.setUsernmae("chawann");
		chawan.setPassword("chawan758487");
		chawan.setLogindate(new Date());
		chawan.display();
		System.out.println(chawan.getUsernmae());
	}

}
