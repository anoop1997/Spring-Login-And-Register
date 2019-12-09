package com.anoop.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.anoop.model.Login;
import com.anoop.model.User;

public class UserDaoImpl implements UserDao {


	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void register(User user) {
		// TODO Auto-generated method stub

		String sql = "insert into users values(?,?,?,?,?,?,?)";
		System.out.println(user.getUname());
		jdbcTemplate.update(sql, new Object[] { user.getUname(), user.getPass(), user.getFname(), user.getLname(),
				user.getEmail(), user.getAddr(), user.getMob() });
	}

	public User validateUser(Login login) {

		// TODO Auto-generated method stub
		String sql = "select * from users where username='" + login.getUname() + "' and password='" + login.getPass()
				+ "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}

}

class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setUname(rs.getString("username"));
		user.setPass(rs.getString("password"));
		user.setFname(rs.getString("firstname"));
		user.setFname(rs.getString("lastname"));
		user.setEmail(rs.getString("email"));
		user.setAddr(rs.getString("address"));
		user.setMob(rs.getString("phone"));
		return user;

	}
}