package com.client.service;

import com.client.entity.ZmSitePageLogBean;

import java.util.List;

/**
 * Created by liuenxi on 2017/12/12.
 */
public interface ZmSitePageLogService {

    public List<ZmSitePageLogBean> getLogList();

    public String addZmSitePageLog(ZmSitePageLogBean pageLogBean);

    public String modifyZmSitePageLog(ZmSitePageLogBean pageLogBean);

    public String delZmSitePageLog(ZmSitePageLogBean pageLogBean);

    List<ZmSitePageLogBean> findByFZmSitePageId(String pageId);
}
