/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedbacksurvey.service;

import com.feedbacksurvey.dao.MembersurveyDao;

/**
 *
 * @author tocai
 */
public class MembersurveyServiceImpl implements MembersurveyService {

    private MembersurveyDao membersurveyDao;

    public MembersurveyDao getMembersurveyDao() {
        return membersurveyDao;
    }

    public void setMembersurveyDao(MembersurveyDao membersurveyDao) {
        this.membersurveyDao = membersurveyDao;
    }

}
