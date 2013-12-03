/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedbacksurvey.service;

import com.feedbacksurvey.dao.TeamDao;

/**
 *
 * @author tocai
 */
public class TeamServiceImpl implements TeamService {

    private TeamDao teamDao;

    public TeamDao getTeamDao() {
        return teamDao;
    }

    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

}
