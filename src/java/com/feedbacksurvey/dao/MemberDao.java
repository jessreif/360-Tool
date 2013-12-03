/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedbacksurvey.dao;

import com.feedbacksurvey.po.Member;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author tocai
 */
public class MemberDao extends HibernateDaoSupport {

    public void save(Member member) {
        this.getHibernateTemplate().save(member);
    }

    public void delete(Member member) {
        this.getHibernateTemplate().delete(member);
    }

    public Member getSingleMember(int memberid) {
        return (Member) this.getHibernateTemplate().get(Member.class, memberid);
    }

    public Member getSingleMemberByMemberName(String membername, String memberpassword) {
        return (Member) this.getHibernateTemplate().find("from Member where membername = ? ", membername).get(0);
    }

    public List<Member> getAllMember() {
        return (List<Member>) (this.getHibernateTemplate()).find("from Member");
    }
}
