package o2o.service;

import o2o.BaseTest;
import o2o.dao.AreaDao;
import o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;
    @Autowired
    private CacheService cacheService;
    @Test
    public void TestGetAreaList(){
        List<Area> areaList= areaService.getAreaList();
        assertEquals("东苑",areaList.get(0).getAreaName());
        System.out.println(areaList);
        cacheService.removeFromCache(areaService.AREALISTKEY);
        areaList= areaService.getAreaList();
    }
}
