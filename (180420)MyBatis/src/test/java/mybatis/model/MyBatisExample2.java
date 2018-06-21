package mybatis.model;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;


import dao.UserDao;

public class MyBatisExample2 {
	
	
	public static void main(String[] args) {
		
		InputStream in = MyBatisExample2.class.getClassLoader().getResourceAsStream("mybatis-config2.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		
		SqlSession session = factory.openSession();
		
		UserDao userDao = session.getMapper(UserDao.class);
		
		
		Map<String,Object> map = new HashMap();
		map.put("name", "张三");
		map.put("sex", "男");
		
		List<User> users = userDao.select(map);
		session.close();
		
		session = factory.openSession();
		userDao = session.getMapper(UserDao.class);
		users = userDao.select(map);
		session.close();
		
		System.out.println(users);
		
		
		/*User user = new User("李四","男",18);
		userDao.add(user);
		System.out.println("---------------插入自动返回主键列的值:"+user);
		session.commit();*/
	}
}
