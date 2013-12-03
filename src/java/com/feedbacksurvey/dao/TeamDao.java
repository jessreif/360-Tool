/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedbacksurvey.dao;

import com.feedbacksurvey.po.Team;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author tocai
 */
public class TeamDao extends HibernateDaoSupport {

    public void save(Team team) {
        this.getHibernateTemplate().save(team);
    }

    public void delete(Team team) {
        this.getHibernateTemplate().delete(team);
    }

    public Team getSingleTeam(int teamid) {
        return (Team) this.getHibernateTemplate().get(Team.class, teamid);
    }

    public List<Team> getAllTeam() {
        return (List<Team>) (this.getHibernateTemplate()).find("from Team");
    }
}
