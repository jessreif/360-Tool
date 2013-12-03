/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedbacksurvey.service;

import com.feedbacksurvey.dao.SurveytemplateDao;

/**
 *
 * @author tocai
 */
public class SurveytemplateServiceImpl implements SurveytemplateService {

    private SurveytemplateDao surveytemplateDao;

    public SurveytemplateDao getSurveytemplateDao() {
        return surveytemplateDao;
    }

    public void setSurveytemplateDao(SurveytemplateDao surveytemplateDao) {
        this.surveytemplateDao = surveytemplateDao;
    }

}
