package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.PmsSkuInfo;

import java.util.List;

public interface SkuService {
   public   void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

   public PmsSkuInfo getSkuById(String skuId);

   public List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(String productId);
}
