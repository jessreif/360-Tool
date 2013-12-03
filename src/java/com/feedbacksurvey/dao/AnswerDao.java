/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedbacksurvey.dao;

import com.feedbacksurvey.po.Answer;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author tocai
 */
public class AnswerDao extends HibernateDaoSupport {

    public void save(Answer answer) {
        this.getHibernateTemplate().save(answer);
    }

    public void delete(Answer answer) {
        this.getHibernateTemplate().delete(answer);
    }

    public Answer getSingleAnswer(int answerid) {
        return (Answer) this.getHibernateTemplate().get(Answer.class, answerid);
    }

    public List<Answer> getAllAnswer() {
        return (List<Answer>) (this.getHibernateTemplate()).find("from Answer");
    }
}
