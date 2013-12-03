/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedbacksurvey.dao;

import com.feedbacksurvey.po.Survey;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author tocai
 */
public class SurveyDao extends HibernateDaoSupport {

    public void save(Survey survey) {
        this.getHibernateTemplate().save(survey);
    }

    public void delete(Survey survey) {
        this.getHibernateTemplate().delete(survey);
    }

    public Survey getSingleSurvey(int surveyid) {
        return (Survey) this.getHibernateTemplate().get(Survey.class, surveyid);
    }

    public List<Survey> getAllSurvey() {
        return (List<Survey>) (this.getHibernateTemplate()).find("from Survey");
    }
}
