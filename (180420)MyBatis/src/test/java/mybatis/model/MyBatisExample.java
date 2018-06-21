package mybatis.model;

import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;


public class MyBatisExample {
	public static void main(String[] args) {
		
		/*InputStream in = MybatisExample.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		
		SqlSession session = factory.openSession();
		
		List<User> users = session.selectList("UserMapper.get");
		
		System.out.println(users);
		
		session.insert("UserMapper.add",new User("张三","男",10));
		
		session.commit();
		session.close();*/
		
		Properties properties = new Properties();
		properties.setProperty("driver", "com.mysql.jdbc.Driver");
		properties.setProperty("url", "jdbc:mysql://127.0.0.1:3306/user");
		properties.setProperty("username", "root");
		properties.setProperty("password", "sa");
		PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
		pooledDataSourceFactory.setProperties(properties);
		DataSource dataSource = pooledDataSourceFactory.getDataSource();
		
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("developent",transactionFactory,dataSource);
		Configuration configuration = new Configuration(environment);
		configuration.addMapper(MyBatisExample.class);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		
		SqlSession session = sqlSessionFactory.openSession();
		
		
		
		
	}
}










