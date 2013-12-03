/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedbacksurvey.service;

import com.feedbacksurvey.dao.AdminDao;
import com.feedbacksurvey.po.Admin;

/**
 *
 * @author tocai
 */
public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao;

    public AdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public Admin getSingleAdmin(String adminname, String adminpassword) {
        return adminDao.getSingleAdminByAdminName(adminname, adminpassword);
    }

}
