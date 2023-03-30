package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class Controller {
	//get rate from database
	public static double getRate(String country) {
		double rate=0;
		String sql="select rate from ratemoney where country ='"+country+"'";
		try (Connection con=ConnectionUtils.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql)){
			while (rs.next()) {
				return rs.getDouble("rate");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return rate;
	
	}
	
	//update rate by country
	public static void Updatedata(String country, double rate) {
		String sql="UPDATE ratemoney "
                + "SET rate = ? "
                + "WHERE country = ?";
		try (Connection con=ConnectionUtils.getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql);
				){
	        pstmt.setDouble(1, rate);
	        pstmt.setString(2, country);	 
	        pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//insert new rate
	public static void insertRate(String country,double rate) {
		String sql="INSERT INTO ratemoney(country,rate)"
                + "VALUES(?,?)";
		try (Connection con=ConnectionUtils.getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql);
				){
			pstmt.setString(1, country);
	        pstmt.setDouble(2, rate);
	        pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//delete rate
	public static void deleteRate(String country) {
		String sql="DELETE "
                + "FROM ratemoney "
                + "WHERE country = ?";
		try (Connection con=ConnectionUtils.getConnection();
				PreparedStatement pstmt=con.prepareStatement(sql);
				){
			pstmt.setString(1, country);
	        pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//get country
	public static String getCountry() {
		String s="";
		String sql="SELECT country "
                + "FROM ratemoney ";
		try (Connection con=ConnectionUtils.getConnection();
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql)){
			while (rs.next()) {
				s +=rs.getString("country")+" ";
//				String [] Con = s.split("\\s");
//				for (String w : Con) {
//					System.out.println(w);
//				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return s;
	}
	
	public static String[] getArrCon() {
		String[]s=null;
		String con=getCountry();
		s=con.split(" ");
		return s;
	}
	
	
	
	public static void main(String[] args) {
//		Updatedata("EUR", 25423.7);
//		insertRate("USD", 23310);
//		insertRate("THB", 609.01);
//		insertRate("SGD", 17217.58);
//		insertRate("KRW", 15.7);
//		insertRate("HKD", 2918.91);
//		insertRate("JPY", 175.85);
//		insertRate("GBP", 28041.86);
//		insertRate("AUD", 15269.32);
//		System.out.println(getRate("VN"));
		System.out.print(getCountry());
//		deleteRate("KN");
		
		
	}
}
