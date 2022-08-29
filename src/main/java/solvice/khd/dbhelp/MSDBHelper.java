package solvice.khd.dbhelp;

import solvice.khd.vo.ProductVo;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// TODO: 2022-08-29 이 클래스는 커넥션 풀없이 연결한 db 
public class MSDBHelper {
    private static MSDBHelper msdbHelper=null;
    private MSDBHelper(){
    }

    public static MSDBHelper getInstance() {
        if(msdbHelper ==null){
            return msdbHelper=new MSDBHelper();
        }
        return msdbHelper;
    }

    public Connection getConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:1433;database=user_test;encrypt=true;trustServerCertificate=true";
            String id="user";
            String pwd="1234";
            Connection conn= DriverManager.getConnection(connectionUrl,id,pwd);
            System.out.println(conn);
            return conn;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void closeConn(Connection conn,
    PreparedStatement pstmt,
    ResultSet rs){
        try {if (rs !=null) rs.close();}catch(SQLException se){}
        try{if(pstmt !=null) pstmt.close();}catch (SQLException se){}
        try{if(conn!=null) conn.close();}catch (SQLException se){}
    }
    public List<ProductVo> selectAllInfo(){
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        List<ProductVo> list=null;
        try {
            conn=getConnection();
            String sql="select * from product";
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            list=new ArrayList<>();
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int cost=rs.getInt("cost");
                int year=rs.getInt("year");
                String city=rs.getString("city");
                list.add(new ProductVo(id,name,cost,year,city));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            closeConn(conn,pstmt,rs);
        }
        return list;
    }
}
