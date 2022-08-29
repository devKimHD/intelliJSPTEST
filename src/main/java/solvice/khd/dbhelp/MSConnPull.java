package solvice.khd.dbhelp;

import solvice.khd.vo.ProductVo;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// TODO: 2022-08-29 이 클래스는 커넥션 풀을 통해 연결한 db
public class MSConnPull {
    private static MSConnPull msConnPull=null;
    private MSConnPull(){
    }

    public static MSConnPull getInstance() {
        if(msConnPull ==null){
            return msConnPull=new MSConnPull();
        }
        return msConnPull;
    }

    public Connection getConn(){
        try{
            Context context=new InitialContext();
            DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/user_test");
            return ds.getConnection();
        }catch (Exception e)
        {e.printStackTrace();}

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
            conn=getConn();
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
