/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.feedbacksurvey.dao;

import com.feedbacksurvey.po.Admin;
import java.util.List;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author tocai
 */
public class AdminDao extends HibernateDaoSupport {

    public void save(Admin admin) {
        this.getHibernateTemplate().save(admin);
    }

    public void delete(Admin admin) {
        this.getHibernateTemplate().delete(admin);
    }

    public Admin getSingleAdmin(int adminid) {
        return (Admin) this.getHibernateTemplate().get(Admin.class, adminid);
    }

    public Admin getSingleAdminByAdminName(String adminname, String adminpassword) {
        return (Admin) this.getHibernateTemplate().find("from Admin where adminname = ? ", adminname).get(0);
    }

    public List<Admin> getAllAdmin() {
        return (List<Admin>) (this.getHibernateTemplate()).find("from Admin");
    }
}
