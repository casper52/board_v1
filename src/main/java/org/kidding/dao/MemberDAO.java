package org.kidding.dao;

import org.kidding.domain.BoardVO;
import org.kidding.domain.MemberVO;

import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

    //회원가입
    public void signUp(final MemberVO vo) {
        final String sql = "insert into tbl_member(mno, mid, mpw, mname) values (seq_member.nextval, ?, ?, ?)";

        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                stmt.setString(1, vo.getMid());
                stmt.setString(2, vo.getMpw());
                stmt.setString(3, vo.getMname());
                stmt.executeUpdate();
            }
        }.executeAll();
    }

    //로그인
    //read
    public MemberVO singIn(final int mno) {
        final String sql = "select * from tbl_member where mno=?";
        final MemberVO vo = new MemberVO();

        new QueryExecutor() {
            @Override
            public void doJob() throws Exception {
                stmt = con.prepareStatement(sql);
                stmt.setInt(1, mno);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    vo.setMno(rs.getInt("mno"));
                    vo.setMid(rs.getString("mid"));
                    vo.setMpw(rs.getString("mpw"));
                    vo.setMname(rs.getString("mname"));
                }
            }
        }.executeAll();
        return vo;
    }
}



