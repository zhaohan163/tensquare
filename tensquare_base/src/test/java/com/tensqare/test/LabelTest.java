package com.tensqare.test;

import com.tensqare.base.BaseApplication;
import com.tensqare.base.pojo.Label;
import com.tensqare.base.service.LabelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName LabelTest
 * @Author 123456
 * @Description TODO
 * @Version 1.0
 * @Date 2019/1/15 16:46
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BaseApplication.class)
public class LabelTest {

    @Autowired
    private LabelService labelService;

    /**
     * 测试查询操作
     */
    @Test
    public void findAll(){
        List<Label> labelList = labelService.findAll();
        for (Label label : labelList) {
            System.out.println(label);
        }
    }


    @Test
    public void save(){
        Label label = new Label();
        label.setLabelname("前端");
        label.setRecommend("无");
        label.setCount(1);
        label.setFans(1);
        label.setState("1");
        labelService.save(label);
    }

    @Test
    public void findSearch(){
        Map searchMap = new HashMap();
        searchMap.put("labelname","h");
        List<Label> labels = labelService.findSearch(searchMap);
        for (Label label : labels) {
            System.out.println(label);
        }
    }
}
