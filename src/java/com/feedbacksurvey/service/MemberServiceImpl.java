/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedbacksurvey.service;

import com.feedbacksurvey.dao.MemberDao;

/**
 *
 * @author tocai
 */
public class MemberServiceImpl implements MemberService {

    private MemberDao memberDao;

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

}
