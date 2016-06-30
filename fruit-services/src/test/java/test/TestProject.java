package test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;
import com.farmer.fruit.business.impl.user.UserServiceImpl;
import com.farmer.fruit.models.user.User;


public class TestProject {
	static DruidDataSource dataSource ;
	static UserServiceImpl userServiceImpl;
	 @BeforeClass
	    public static void  init() {
	        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-service.xml");
	        dataSource = (DruidDataSource)context.getBean("dataSource");
	        userServiceImpl = (UserServiceImpl)context.getBean("userServiceImpl");
	 }
	 @Test
	 public void testProject(){
		 System.out.println(userServiceImpl);
		 User  user = userServiceImpl.getById(1L);
		 System.out.println(user.getId());
	 }
	        
}
