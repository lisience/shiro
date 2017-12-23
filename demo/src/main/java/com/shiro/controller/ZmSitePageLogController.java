package com.shiro.controller;

import com.shiro.entity.ZmSitePageLogBean;
import com.shiro.service.ZmSitePageLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by liuenxi on 2017/12/12.
 */
@RestController
@RequestMapping("/pageLog")
public class ZmSitePageLogController {

    @Autowired
    private ZmSitePageLogService pageLogService;

    @RequestMapping("/find")
    public List<ZmSitePageLogBean> findByFZmSitePageId(String pageId){
        return pageLogService.findByFZmSitePageId(pageId);
    }
}
