/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedbacksurvey.service;

import com.feedbacksurvey.po.Admin;

/**
 *
 * @author tocai
 */
public interface AdminService {

    Admin getSingleAdmin(String adminname, String adminpassword);
}
