/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedbacksurvey.dao;

import com.feedbacksurvey.po.Question;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author tocai
 */
public class QuestionDao extends HibernateDaoSupport {

    public void save(Question question) {
        this.getHibernateTemplate().save(question);
    }

    public void delete(Question question) {
        this.getHibernateTemplate().delete(question);
    }

    public Question getSingleQuestion(int questionid) {
        return (Question) this.getHibernateTemplate().get(Question.class, questionid);
    }

    public List<Question> getAllQuestion() {
        return (List<Question>) (this.getHibernateTemplate()).find("from Question");
    }
}
