/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedbacksurvey.service;

import com.feedbacksurvey.dao.QuestionDao;

/**
 *
 * @author tocai
 */
public class QuestionServiceImpl implements QuestionService {

    private QuestionDao questionDao;

    public QuestionDao getQuestionDao() {
        return questionDao;
    }

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

}
