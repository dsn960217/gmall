package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;
import com.atguigu.gmall.bean.PmsBaseSaleAttr;
import com.atguigu.gmall.bean.PmsProductSaleAttr;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import java.util.List;

public interface AttrService {
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    public List<PmsBaseAttrValue> getAttrValueList(String attrId);

    public List<PmsBaseSaleAttr> baseSaleAttrList();
}
