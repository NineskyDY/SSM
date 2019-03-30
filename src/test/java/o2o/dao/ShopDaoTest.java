package o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import o2o.BaseTest;
import o2o.entity.Area;
import o2o.entity.PersonInfo;
import o2o.entity.Shop;
import o2o.entity.ShopCategory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;



//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShopDaoTest extends BaseTest {
	@Autowired
	private ShopDao shopDao;


	@Test
	public void testQueryShopListAndCount(){
		Shop shopCondition = new Shop();
		PersonInfo owner = new PersonInfo();
		owner.setUserId(8L);
		shopCondition.setOwner(owner);
		List<Shop> shopList = shopDao.queryShopList(shopCondition,0,20);
		System.out.println("店铺列表大小为： " +shopList.size());
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("店铺总数为："+count);
	}
	@Ignore
	@Test
	public void testQueryByShopId(){
		long shopId = 26;
		Shop shop = shopDao.queryByShopId(shopId);
		System.out.println(shop.getCreateTime());
		System.out.println(shop.getArea().getAreaName());
		System.out.println(shop.getArea().getAreaId());
		System.out.println(shop.getShopCategory().getShopCategoryName());
		System.out.println("**************************"+shop);
	}

	@Test
	@Ignore
	public void testInsertShop() throws Exception {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory sc = new ShopCategory();
		owner.setUserId(11L);
		area.setAreaId(3L);
		sc.setShopCategoryId(10L);
		shop.setOwner(owner);
		shop.setOwner_Id(owner.getUserId());
		shop.setArea(area);
		shop.setShopName("mytest3");
		shop.setShopDesc("mytest3");
		shop.setShopAddr("testaddr3");
		shop.setPhone("13810524526");
		shop.setShopImg("test3");
		shop.setCreateTime(new Date());
		shop.setLastEditTime(new Date());
		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		shop.setArea(area);
		shop.setShopCategory(sc);
		int effectedNum = shopDao.insertShop(shop);
		assertEquals(1, effectedNum);
	}

	@Ignore
	@Test
	public void testUpdateShop() throws Exception {
		Shop shop = new Shop();
		shop.setShopId(30L);
		shop.setShopName("测试店铺");
		shop.setShopDesc("测试描述");
		shop.setShopAddr("测试地址");
		shop.setLastEditTime(new Date());
		int effectedNum = shopDao.updateShop(shop);
		assertEquals(1, effectedNum);
	}

//	@Test
//	@Ignore
//	public void testBQueryByEmployeeId() throws Exception {
//		long employeeId = 1;
//		List<Shop> shopList = shopDao.queryByEmployeeId(employeeId);
//		for (Shop shop : shopList) {
//			System.out.println(shop);
//		}
//	}
//
//	@Test
//	@Ignore
//	public void testBQueryShopList() throws Exception {
//		Shop shop = new Shop();
//		List<Shop> shopList = shopDao.queryShopList(shop, 0, 2);
//		assertEquals(2, shopList.size());
//		int count = shopDao.queryShopCount(shop);
//		assertEquals(3, count);
//		shop.setShopName("花");
//		shopList = shopDao.queryShopList(shop, 0, 3);
//		assertEquals(2, shopList.size());
//		count = shopDao.queryShopCount(shop);
//		assertEquals(2, count);
//		shop.setShopId(1L);
//		shopList = shopDao.queryShopList(shop, 0, 3);
//		assertEquals(1, shopList.size());
//		count = shopDao.queryShopCount(shop);
//		assertEquals(1, count);
//
//	}
//
//	@Test
//	@Ignore
//	public void testCQueryByShopId() throws Exception {
//		long shopId = 1;
//		Shop shop = shopDao.queryByShopId(shopId);
//		System.out.println(shop);
//	}
//
//	@Test
//	@Ignore
//	public void testDUpdateShop() {
//		long shopId = 1;
//		Shop shop = shopDao.queryByShopId(shopId);
//		Area area = new Area();
//		area.setAreaId(1L);
//		shop.setArea(area);
//		ShopCategory shopCategory = new ShopCategory();
//		shopCategory.setShopCategoryId(1L);
//		shop.setShopCategory(shopCategory);
//		shop.setShopName("四季花");
//		int effectedNum = shopDao.updateShop(shop);
//		assertEquals(1, effectedNum);
//	}
//
//	@Test
//	@Ignore
//	public void testEDeleteShopByName() throws Exception {
//		String shopName = "mytest1";
//		int effectedNum = shopDao.deleteShopByName(shopName);
//		assertEquals(1, effectedNum);
//
//	}

}
