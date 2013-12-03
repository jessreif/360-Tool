/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedbacksurvey.dao;

import com.feedbacksurvey.po.Membersurvey;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author tocai
 */
public class MembersurveyDao extends HibernateDaoSupport {

    public void save(Membersurvey membersurvey) {
        this.getHibernateTemplate().save(membersurvey);
    }

    public void delete(Membersurvey membersurvey) {
        this.getHibernateTemplate().delete(membersurvey);
    }

    public Membersurvey getSingleMembersurvey(int membersurveyid) {
        return (Membersurvey) this.getHibernateTemplate().get(Membersurvey.class, membersurveyid);
    }

    public List<Membersurvey> getAllMembersurvey() {
        return (List<Membersurvey>) (this.getHibernateTemplate()).find("from Membersurvey");
    }
}
