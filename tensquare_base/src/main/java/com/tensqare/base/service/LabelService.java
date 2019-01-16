package com.tensqare.base.service;

import com.tensqare.base.dao.LabelDao;
import com.tensqare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * @ClassName LabelService
 * @Author 123456
 * @Description TODO
 * @Version 1.0
 * @Date 2019/1/15 16:20
 **/
@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询所有
     * @return
     */
    public List<Label> findAll(){
        return labelDao.findAll();
    }

    /**
     * 按照id查询
     * @param id
     * @return
     */
    public Label findById(String id){
        return labelDao.findById(id).get();
    }

    /**
     * 保存
     * @param label
     */
    public void save(Label label){
        label.setId(String.valueOf(idWorker.nextId()));
        labelDao.save(label);
    }

    /**
     * 更新操作
     * @param label
     */
    public void update(Label label){
        labelDao.save(label);
    }

    /**
     * 删除操作
     * @param id
     */
    public void delete(String id){
        labelDao.deleteById(id);
    }

}
