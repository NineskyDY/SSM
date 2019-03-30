package o2o.service;

import o2o.BaseTest;
import o2o.dto.ShopExecution;
import o2o.entity.Area;
import o2o.entity.PersonInfo;
import o2o.entity.Shop;
import o2o.entity.ShopCategory;
import o2o.enums.ShopStateEnum;
import o2o.exceptions.ShopOperationException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
	public void testGetShopList(){
    	Shop shopCondition = new Shop();
		PersonInfo owner = new PersonInfo();
		owner.setUserId(8L);
		shopCondition.setOwner(owner);
//		ShopCategory shopCategory = new ShopCategory();
//		shopCategory.setShopCategoryId(14L);
//		shopCondition.setShopCategory(shopCategory);
		ShopExecution shopExecution = shopService.getShopList(shopCondition,0,20);
		System.out.println("!!!!!"+shopExecution.getShopList().size());
		System.out.println("&&&&"+shopExecution.getCount());
		int i=0;
		for (Shop shop:shopExecution.getShopList()) {
			System.out.println(++i+"***"+shop.getShopId() +"@@@@@@@"+shop.getShopName());
		}
		System.out.println("----------------------------------------");
		shopExecution = shopService.getShopList(shopCondition,1,20);
		System.out.println("!!!!!"+shopExecution.getShopList().size());
		System.out.println("&&&&"+shopExecution.getCount());
		i=0;
		for (Shop shop:shopExecution.getShopList()) {
			System.out.println(++i+"***"+shop.getShopId() +"@@@@@@@"+shop.getShopName());
		}
	}

    //有问题的test
	@Ignore
    @Test
    public void  testmodifyShop() throws ShopOperationException, IOException {
    	Shop shop = new Shop();
    	shop.setShopId(33L);
    	shop.setShopName("修改1");
    	FileInputStream inputStream =new FileInputStream(new File("C:/Users/pc/Pictures/知乎/图片/2018-11-22 09_47_46.jpg")) ;
		MultipartFile multipartFile = new MockMultipartFile("temp.jpg","temp.jpg","", inputStream);
		ShopExecution shopExecution = shopService.modifyShop(shop, (CommonsMultipartFile) multipartFile,"wangye");
		System.out.println("新图片地址为："+shopExecution.getShop().getShopImg());
	}
    @Ignore
	@Test
	public void testAddShop() throws Exception {
		Shop shop = new Shop();
		Area area = new Area();
		area.setAreaId(6L);
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(24L);
		shop.setShopName("mytest1");
		shop.setShopDesc("mytest1");
		shop.setShopAddr("testaddr1");
		shop.setPhone("13810524526");
//		shop.setCreateTime(new Date());
//		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		shop.setArea(area);
		shop.setShopCategory(sc);
		File file = new File("C:/Users/pc/Pictures/img-1b0c0db768328227b46c2a3024eee000.jpg");
        FileInputStream shopImg = new FileInputStream(file);
//        ShopExecution se = shopService.addShop(shop, shopImg);
//		assertEquals("mytest1", se.getShop().getShopName());
	}
}
