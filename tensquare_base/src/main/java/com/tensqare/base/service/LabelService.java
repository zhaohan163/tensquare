package com.tensqare.base.service;

import com.tensqare.base.dao.LabelDao;
import com.tensqare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    public Specification<Label> createSpecification(Map searchMap){
        return new Specification<Label>() {
            /**
             *
             * @param root
             * @param criteriaQuery
             * @param criteriaBuilder
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //
                List<Predicate> predicateList=new ArrayList<>();

                //拼接条件  标签名
                if (!StringUtils.isEmpty(searchMap)){
                    Predicate p1 = criteriaBuilder.like(root.get("labelname"), "%" + (String) searchMap.get("labelname") + "%");
                    predicateList.add(p1);
                }
                //
                if (!StringUtils.isEmpty(searchMap)){
                    Predicate p2 = criteriaBuilder.equal(root.get("state"), (String) searchMap.get("state"));
                    predicateList.add(p2);
                }
                //
                if (!StringUtils.isEmpty(searchMap)){
                    Predicate p3 = criteriaBuilder.equal(root.get("recommend"), searchMap.get("recommend"));
                    predicateList.add(p3);
                }
                //
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }

    /**
     * 条件查询  this指当前service类
     * @param searchMap 查询对象
     * @return
     */
    public List<Label> findSearch(Map searchMap){
        Specification<Label> specification = this.createSpecification(searchMap);
        return labelDao.findAll(specification);
    }

    /**
     * 分页查询
      * @param searchMap  查询对象
     * @param pageNum     页数
     * @param pageSize    每页显示多少条数据
     * @return
     */
    public Page<Label> findSearch(Map searchMap,int pageNum,int pageSize){
        Specification<Label> specification = this.createSpecification(searchMap);
        PageRequest pageRequest = PageRequest.of(pageNum-1, pageSize);
        return labelDao.findAll(specification,pageRequest);
    }





}
