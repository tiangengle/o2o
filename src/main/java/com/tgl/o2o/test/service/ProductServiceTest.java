package com.tgl.o2o.test.service;

import com.tgl.o2o.dto.ImageHolder;
import com.tgl.o2o.dto.ProductExecution;
import com.tgl.o2o.entity.Product;
import com.tgl.o2o.entity.ProductCategory;
import com.tgl.o2o.entity.Shop;
import com.tgl.o2o.enums.ProductStateEnum;
import com.tgl.o2o.exceptions.ShopOperationException;
import com.tgl.o2o.service.ProductService;
import com.tgl.o2o.test.BaseTest;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class ProductServiceTest extends BaseTest {
    @Autowired
    private ProductService productService;

    @Test
    @Ignore
    public void testAddProduct()throws ShopOperationException,FileNotFoundException{
        //创建shopId为 3 且productCategoryId为 1 的商品实例并给其成员变量赋值
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(3L);
        ProductCategory pc = new ProductCategory();
        pc.setProductCategoryId(1L);
        product.setProductCategory(pc);
        product.setShop(shop);
        product.setProductName("测试商品1");
        product.setProductDesc("测试商品1");
        product.setPriority(20);
        product.setCreateTime(new Date());
        product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
        //创建缩略图文件流
        File thumbnailFile = new File("C:/Users/小乐/Desktop/image/xiaohuangren.jpg");
        InputStream is = new FileInputStream(thumbnailFile);
        ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(),is);
        //创建两个商品详情文件流并将他们添加到详情图列表中
        File productImg1 = new File("C:/Users/小乐/Desktop/image/xiaohuangren.jpg");
        InputStream is1 = new FileInputStream(productImg1);
        File productImg2 = new File("C:/Users/小乐/Desktop/image/dabai.jpg");
        InputStream is2 = new FileInputStream(productImg2);
        List<ImageHolder> producImgList = new ArrayList<ImageHolder>();
        producImgList.add(new ImageHolder(productImg1.getName(), is1));
        producImgList.add(new ImageHolder(productImg2.getName(), is2));
        //添加商品并验证
        ProductExecution pe = productService.addProduct(product, thumbnail, producImgList);
        assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
    }

    @Test
    public void testModifyProduct()throws ShopOperationException,FileNotFoundException{
        //创建shopId为 3 且productCategoryId为 1 的商品实例并给其成员变量赋值
        Product product = new Product();
        Shop shop = new Shop();
        shop.setShopId(3L);
        ProductCategory pc = new ProductCategory();
        pc.setProductCategoryId(1L);
        product.setProductCategory(pc);
        product.setShop(shop);
        product.setProductId(1L);
        product.setProductName("正式的商品");
        product.setProductDesc("正式的店铺描述");
        //创建缩略图文件流
        File thumbnailFile = new File("C:/Users/小乐/Desktop/image/lufei.jpg");
        InputStream is = new FileInputStream(thumbnailFile);
        ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(),is);
        //创建两个商品详情文件流并将他们添加到详情图列表中
        File productImg1 = new File("C:/Users/小乐/Desktop/image/xiaohuangren.jpg");
        InputStream is1 = new FileInputStream(productImg1);
        File productImg2 = new File("C:/Users/小乐/Desktop/image/milaoshu.jpg");
        InputStream is2 = new FileInputStream(productImg2);
        List<ImageHolder> producImgList = new ArrayList<ImageHolder>();
        producImgList.add(new ImageHolder(productImg1.getName(), is1));
        producImgList.add(new ImageHolder(productImg2.getName(), is2));
        //修改商品并验证
        ProductExecution pe = productService.modifyProduct(product, thumbnail, producImgList);
        assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
    }
}
