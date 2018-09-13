package org.kidding.domain;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class MemberVO  {
    private int mno;
    private String mid, mpw, mname;
    private Date regdate;


    }

