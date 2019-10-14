package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import java.util.List;

public interface AttrService {
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);
}
