/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedbacksurvey.service;

import com.feedbacksurvey.dao.SurveyDao;

/**
 *
 * @author tocai
 */
public class SurveyServiceImpl implements SurveyService {

    private SurveyDao surveyDao;

    public SurveyDao getSurveyDao() {
        return surveyDao;
    }

    public void setSurveyDao(SurveyDao surveyDao) {
        this.surveyDao = surveyDao;
    }

}
