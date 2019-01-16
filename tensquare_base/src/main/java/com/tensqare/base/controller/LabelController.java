package com.tensqare.base.controller;

import com.tensqare.base.pojo.Label;
import com.tensqare.base.service.LabelService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName LabelController
 * @Author 123456
 * @Description TODO
 * @Version 1.0
 * @Date 2019/1/15 16:27
 **/

@RestController
@RequestMapping("/label")
@CrossOrigin//跨域访问
public class LabelController {

    @Autowired
    private LabelService labelService;

    /**
     * 查看列表  GET  根据请求方式Result风格
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        List<Label> labelList = labelService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",labelList);
    }

    /**
     * 按照Id查询 GET请求加参数
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Result findById(@PathVariable("id") String id){
        Label label = labelService.findById(id);
        return new Result(true,StatusCode.OK,"查询成功",label);
    }

    /**
     * 保存操作 POST请求
     * @param label
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true,StatusCode.OK,"保存成功");
    }

    /**
     * 根据Id进行更新操作  PUT请求
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT,value = "/{id}")
    public Result update(@RequestBody Label label,@PathVariable("id")  String id){
        label.setId(id);
        labelService.update(label);
        return new Result(true,StatusCode.OK,"更新成功");
    }

    /**
     * 根据Id删除操作    DELETE请求
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
    public Result delete(@PathVariable("id") String id){
        labelService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

}
