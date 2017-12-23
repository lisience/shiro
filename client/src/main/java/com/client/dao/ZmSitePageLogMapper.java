package com.client.dao;

import com.client.entity.ZmSitePageLogBean;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * Created by liuenxi on 2017/12/12.
 */
public interface ZmSitePageLogMapper {

    @Select({
            "select",
            "f_id, f_zm_site_page_id, f_zm_site_id, f_page_id, f_page_name, f_page_type, f_page_domain, ",
            "f_sec_domain, f_site_state, f_pc_data, f_phone_data, f_update_time, f_title, f_description, ",
            "f_keywords, f_type, f_login_limit, f_password_limit, f_url, f_save_type, f_sort, ",
            "f_is_in_navigation, f_is_home, f_is_show_go_head, f_is_show_go_foot, f_templet_id, ",
            "f_parent_id, f_state, f_create_id, f_create_type, f_create_time, f_update_id, f_update_type,",
            "f_html, case f_save_type when 1 then '自动保存' when 2 then '手动保存' end as f_comment, f_page_config, f_bg_html, f_site_version, f_site_page_version  ",
            "from zm_site_page_log ",
            "where f_zm_site_page_id = #{fZmSitePageId} and f_state = 1 order by f_id desc"
    })
    @ResultMap("BaseResultMap")
    List<ZmSitePageLogBean> findByFZmSitePageId(String fZmSitePageId);
}
