package dao;

import java.util.List;
import java.util.Map;

import mybatis.model.User;

public interface UserDao {
	
	void add(User user);
	
	List<User> get();
	
	List<User> select(Map<String,Object> map);
}
