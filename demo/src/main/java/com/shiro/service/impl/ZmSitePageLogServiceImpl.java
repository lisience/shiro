package com.shiro.service.impl;

import com.shiro.dao.ZmSitePageLogMapper;
import com.shiro.entity.ZmSitePageLogBean;
import com.shiro.service.ZmSitePageLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuenxi on 2017/12/12.
 */
@Service
public class ZmSitePageLogServiceImpl implements ZmSitePageLogService {

    @Autowired
    private ZmSitePageLogMapper pageLogMapper;

    @Override
    public List<ZmSitePageLogBean> getLogList() {
        return null;
    }

    @Override
    public String addZmSitePageLog(ZmSitePageLogBean pageLogBean) {
        return null;
    }

    @Override
    public String modifyZmSitePageLog(ZmSitePageLogBean pageLogBean) {
        return null;
    }

    @Override
    public String delZmSitePageLog(ZmSitePageLogBean pageLogBean) {
        return null;
    }

    @Override
    public List<ZmSitePageLogBean> findByFZmSitePageId(String pageId) {
        return pageLogMapper.findByFZmSitePageId(pageId);
    }
}
