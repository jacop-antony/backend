package com.tap.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.UserDAO;
import com.tap.model.User;
import com.tap.util.DBConnection;

public class UserDAOimp implements UserDAO {



	private static String UPDATE="UPDATE user set name=?,username=?,password=?,email=?,phonenumber=?,address=?,role=? WHERE userid=?";
	private static String INSERT="INSERT into user(userid,name,username,password,email,phonenumber,address,role,createddate,lastlogindate) values(?,?,?,?,?,?,?,?,?,?)";
	private static String GETUSER="SELECT * FROM user where userid=?";
	private static String GETALLUSERS="SELECT * FROM user";
	private static String DELETE="delete from user where userid=?";
	private static final String SELECT = "SELECT * FROM `user` WHERE `email` = ?";


	@Override
	public List<User> getAllUsers() {

		List<User> list =new ArrayList<>();
		User u=null;
		try(Connection connection=DBConnection.getConnection();
				PreparedStatement psmt=connection.prepareStatement(GETALLUSERS);)
		{
			ResultSet resultset=psmt.executeQuery();
			while(resultset.next()) {
				int userid=resultset.getInt(1);
				String name=resultset.getString(2);
				String username=resultset.getString(3);
				String password=resultset.getString(4);
				String email=resultset.getString(5);
				String phonenumber=resultset.getString(6);
				String address=resultset.getString(7);
				String role=resultset.getString(8);
				Timestamp createdDate=resultset.getTimestamp(9);
				Timestamp lastLoginDate=resultset.getTimestamp(10);


				u = new User(userid, name, username, password, email, phonenumber, address, role,createdDate,lastLoginDate);

				list.add(u);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}	


		return list;
	}

	@Override
	public User getUser(int id) {

		User u = null; 

		try(Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT);)

		{
			preparedStatement.setInt(1, id);

			ResultSet res = preparedStatement.executeQuery();

			while(res.next())
			{
				int id1 = res.getInt("userid");
				String name = res.getString("name");
				String username = res.getString("username");
				String pass = res.getString("password");
				String email = res.getString("email");
				String ph = res.getString("phonenumber");
				String add = res.getString("address");
				String role = res.getString("role");
				Timestamp dat = res.getTimestamp("createddate");
				Timestamp date = res.getTimestamp("lastlogindate");


				u = new User(id1,name,username,pass,email,ph,add,role,null,null);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return u;

	}


	@Override
	public void addUser(User user) {

		try(Connection connection = DBConnection.getConnection();
				PreparedStatement pstmt = connection.prepareStatement(INSERT);
				)
		{

			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getPhoneNumber());
			pstmt.setString(7, user.getAddress());
			pstmt.setString(8, user.getRole());
			pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(10, new Timestamp(System.currentTimeMillis()));


			int res = pstmt.executeUpdate();

			System.out.println(res);
		}


		catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateUser(User user) {

		try(Connection connection = DBConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE );
				)
		{

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPhoneNumber());
			preparedStatement.setString(6, user.getAddress());
			preparedStatement.setInt(7, user.getUserId());

			int res = preparedStatement.executeUpdate();

			System.out.println(res);
		}


		catch (SQLException e) {
			e.printStackTrace();
		} 	

	}


	@Override
	public void deleteUser(int id) {

		try(Connection connection=DBConnection.getConnection();
				PreparedStatement psmt = connection.prepareStatement(DELETE);) {
			psmt.setInt(1, id);
			int i=psmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
