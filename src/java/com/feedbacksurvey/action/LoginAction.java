/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedbacksurvey.action;

import com.feedbacksurvey.service.AdminService;
import com.feedbacksurvey.service.MemberService;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author tocai
 */
public class LoginAction extends ActionSupport {

    private AdminService adminService;
    private MemberService memberService;
    private String username;
    private String password;
    private String type;

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public MemberService getMemberService() {
        return memberService;
    }

    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String execute() {
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        System.out.println("type:" + type);
        if (type.equals("Member")) {
            return "member_success";
        } else if (type.equals("Admin")) {
            return "admin_success";
        }
        return "fail";
    }
}
