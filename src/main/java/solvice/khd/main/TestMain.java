package solvice.khd.main;

import solvice.khd.dbhelp.MSDBHelper;

// TODO: 2022-08-29 테스트용 메인?? 
public class TestMain {
    public static void main(String[] args) {
        MSDBHelper msdbHelper=MSDBHelper.getInstance();
        msdbHelper.getConnection();
        System.out.println(msdbHelper.selectAllInfo());
    }
}
