/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedbacksurvey.dao;

import com.feedbacksurvey.po.Surveytemplate;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author tocai
 */
public class SurveytemplateDao extends HibernateDaoSupport {

    public void save(Surveytemplate surveytemplate) {
        this.getHibernateTemplate().save(surveytemplate);
    }

    public void delete(Surveytemplate surveytemplate) {
        this.getHibernateTemplate().delete(surveytemplate);
    }

    public Surveytemplate getSingleSurveytemplate(int surveytemplateid) {
        return (Surveytemplate) this.getHibernateTemplate().get(Surveytemplate.class, surveytemplateid);
    }

    public List<Surveytemplate> getAllSurveytemplate() {
        return (List<Surveytemplate>) (this.getHibernateTemplate()).find("from Surveytemplate");
    }
}
