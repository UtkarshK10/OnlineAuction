package com.upsidedown.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.upsidedown.dao.UserDao;
import com.upsidedown.model.User;
import com.upsidedown.model.exception.UserAlreadyExistsException;
import com.upsidedown.model.exception.UserNotFoundException;

public class UserDaoImpl implements UserDao {
	
	Connection con;
	
	private String insertSQL="INSERT INTO user VALUES (?,?,?,?,?,?,?,?,?)";
	private String findUserByUsernameSQL="SELECT * FROM user WHERE username=?";
	private String findUserSQL="SELECT * FROM user WHERE username=? AND password=?";
	
	private String driver;
	private String jdbcUrl;
	
	UserDaoImpl() throws ClassNotFoundException, SQLException{
		driver = "org.apache.derby.jdbc.EmbeddedDriver";
		jdbcUrl="jdbc:derby:C:\\auctiondb";
		
		Class.forName(driver);
		con = DriverManager.getConnection(jdbcUrl);
	}

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException {
		boolean flag=userExists(user.getUsername());
		if(!flag) {
			try(PreparedStatement ps = con.prepareStatement(insertSQL)){
				ps.setString(1, user.getName());
				ps.setDate(2,  java.sql.Date.valueOf(user.getDateOfBirth()));
				ps.setString(3, user.getEmail());
				ps.setString(4, user.getPhoneNumber());
				ps.setString(5, user.getUsername());
				ps.setString(6, user.getPassword());
				ps.setString(7, user.getAddress());
				ps.setInt(8, user.getUser());
				ps.setDouble(9, user.getWalletAmt());
				int numOfRowsUpdated=ps.executeUpdate();
				if(numOfRowsUpdated==1) return true;
				else return false;
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		}else {
			throw new UserAlreadyExistsException();
		}
		
	}

	@Override
	public User getUser(String username, String password) throws UserNotFoundException {
		ResultSet rs=null;
		User u=new User();
		try(PreparedStatement ps = con.prepareStatement(findUserSQL)){
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			while(rs.next()) {
				u.setUserId(rs.getInt("userId"));
				u.setName(rs.getString("name"));
				u.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
				u.setEmail(rs.getString("email"));
				u.setPhoneNumber(rs.getString("phoneNumber"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setAddress(rs.getString("address"));
				u.setUser(rs.getInt("user"));
				u.setWalletAmt(rs.getDouble("walletAmt"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new UserNotFoundException();
		}
		return u;
	}

	@Override
	public boolean userExists(String username) {
		ResultSet rs = null;
		User u = new User();
		try(PreparedStatement ps = con.prepareStatement(findUserByUsernameSQL)){
			ps.setString(1, username);
			rs=ps.executeQuery();
			while(rs.next()) {
				u.setUserId(rs.getInt("userId"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(u.getUserId()!=0) {
			return true;
		}
		return false;
	}

}
