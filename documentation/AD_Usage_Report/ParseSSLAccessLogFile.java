package com.hp.it.cas.ad.metrics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ParseSSLAccessLogFile {
	private static ArrayList<String> logFileNames = new ArrayList<String>();
	
	public void parse() {
		
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "admetrics";
			String password = "admetrics";
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		for(String logFileName : logFileNames) {
			parseLogFile(stmt, logFileName);
		}
		
		close(conn, stmt, null);
	}
	
	private void parseLogFile(Statement stmt, String logFile) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(logFile)));
			
			String line = null;
			int sum = 0;
			
			String str_remote = null;
			String str_date = null;
			String str_iso = null;
			String str_service = null;
			
			try {
				while ((line = br.readLine()) != null) {
					
					if (line.contains("/match/") || line.contains("/legacy-match/")) {
						
						String[] data = line.split(" ");
						str_remote = data[0];
						str_date = data[3].substring(1, data[3].indexOf(":"));
						
						if (line.contains("/match/")) {
							str_service = "ReST";
							if (line.contains("country1=")) {
								String address = line.substring(line.indexOf("country1="));
								str_iso = address.substring(9, address.indexOf("&"));
								str_iso = str_iso != null ? str_iso.toUpperCase().trim() : "NULL";
							} else {
								str_iso = "NULL";
							}
						} else {
							str_service = "SOAP";
							str_iso = "NULL";
						}
						
//						Table_Field: env, server, service, remote, date, iso
//						String sql = "insert into TB_ADUSAGE values('itg', 'c4t16794','" + str_service + "','" + str_remote + "','" + str_date + "','" + str_iso + "')";
//						String sql = "insert into TB_ADUSAGE values('itg', 'c9t16795','" + str_service + "','" + str_remote + "','" + str_date + "','" + str_iso + "')";						
//						String sql = "insert into TB_ADUSAGE values('pro', 'g4t8318','" + str_service + "','" + str_remote + "','" + str_date + "','" + str_iso + "')";
						String sql = "insert into TB_ADUSAGE values('pro', 'g9t6454','" + str_service + "','" + str_remote + "','" + str_date + "','" + str_iso + "')";
						System.out.println(sql);
						stmt.execute(sql);
							
						sum ++;
						
						clearVariables(str_date, str_remote, str_service, str_iso);
					}
				}
				
				System.out.println(logFile + " AD Request Number: " + sum);
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} finally {
			close(null, null, br);
		}
	}
	
	private void clearVariables(String str_date, String str_remote, String str_service, String str_iso) {
		str_date = null;
		str_remote = null;
		str_service = null;
		str_iso = null;
	}
	
	private void close(Connection conn, Statement stmt, BufferedReader br) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
			if (br != null) {
				br.close();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void setAccessLogFileNames(){
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/itg/c4t16794/ssl_access_log-20160208");
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/itg/c4t16794/ssl_access_log-20160209");
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/itg/c4t16794/ssl_access_log-20160210");
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/itg/c4t16794/ssl_access_log-20160211");
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/itg/c4t16794/ssl_access_log-20160212");
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/itg/c4t16794/ssl_access_log-20160213");
		
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/itg/c9t16795/ssl_access_log-20160208");
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/itg/c9t16795/ssl_access_log-20160209");
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/itg/c9t16795/ssl_access_log-20160210");
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/itg/c9t16795/ssl_access_log-20160211");
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/itg/c9t16795/ssl_access_log-20160212");
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/itg/c9t16795/ssl_access_log-20160213");
		
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/pro/g4t8318/ssl_access_log-20160208");
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/pro/g4t8318/ssl_access_log-20160209");
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/pro/g4t8318/ssl_access_log-20160210");
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/pro/g4t8318/ssl_access_log-20160211");
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/pro/g4t8318/ssl_access_log-20160212");
//		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/pro/g4t8318/ssl_access_log-20160213");
		
		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/pro/g9t6454/ssl_access_log-20160208");
		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/pro/g9t6454/ssl_access_log-20160209");
		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/pro/g9t6454/ssl_access_log-20160210");
		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/pro/g9t6454/ssl_access_log-20160211");
		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/pro/g9t6454/ssl_access_log-20160212");
		logFileNames.add("C:/AddressDoctor/document/20160216-usageReport/FullLog/pro/g9t6454/ssl_access_log-20160213");
		
	}
	
	public static void main(String[] args) throws Exception {
		setAccessLogFileNames();
		new ParseSSLAccessLogFile().parse();
	}
}
