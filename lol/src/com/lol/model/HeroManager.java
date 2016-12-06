package com.lol.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.lol.model.Hero;
public class HeroManager {
	private Hero hero;//��������ݿ��ڻ�ȡ��һ��Ӣ������
	private List<Hero> heroes;//��������ݿ��ڻ�ȡ�Ķ��Ӣ������
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement ps;
	
	//���ݴ��ݹ�����id����һ��Ӣ��
	public Hero findOne(int id){
		conn=getConnection();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from hero where id="+id);
			
			hero =new Hero();
			
			while(rs.next()){
				hero.setName(rs.getString("name"));
				hero.setNickname(rs.getString("nick_name"));
				hero.setImage(rs.getString("image"));
				hero.setAvatar(rs.getString("avatar"));
				hero.setDesc(rs.getString("description"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hero;
	}
	
	//��������Ӣ��
	public List<Hero> findAll(){
		conn=getConnection();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery("aelect * from hero");
			heroes=new ArrayList<Hero>();
			
			while(rs.next()){
				hero=new Hero();//ÿ��һ�����ݾ�������һ��hero
				hero.setId(rs.getInt("id"));
				hero.setName(rs.getString("name"));
				hero.setNickname(rs.getString("nick_name"));
				hero.setImage(rs.getString("image"));
				hero.setAvatar(rs.getString("avatar"));
				hero.setDesc(rs.getString("description"));
				heroes.add(hero);
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return heroes;
	}
	
	//����һ��Ӣ��
	public void add(Hero hero){
		String sql="insert into hero(name,nick_name,avatar,image,description) values(?,?,?,?,?)";
		conn=getConnection();
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, hero.getName());
			ps.setString(2, hero.getNickname());
			ps.setString(3, hero.getAvatar());
			ps.setString(4, hero.getImage());
			ps.setString(5, hero.getDesc());
			
			ps.executeQuery();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//�޸�һ��Ӣ��
	public void modify(Hero hero){
		String sql="update hero set name=?,nick_name=?,avatar=?,"+"image=?,description=? where id=?";
		
		conn=getConnection();
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, hero.getName());
			ps.setString(2, hero.getNickname());
			ps.setString(3, hero.getAvatar());
			ps.setString(4, hero.getImage());
			ps.setString(5, hero.getDesc());
			ps.setInt(6, hero.getId());
			ps.executeQuery();
			
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection(){
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433;databasename=student";
		String user="sa";
		String password="133113";
		
		try {
			Class.forName(driverName);
			return DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	public HeroManager(){
		
	}

}
