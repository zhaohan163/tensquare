package com.tensquare.search.controller;

import com.tensquare.search.pojo.Article;
import com.tensquare.search.service.ArticleSearchService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ArticleSearchController
 * @Author 123456
 * @Description TODO
 * @Version 1.0
 * @Date 2019/1/20 15:21
 **/
@RestController
@RequestMapping("/article")
@CrossOrigin  //开启跨域访问
public class ArticleSearchController {


    @Autowired
    private ArticleSearchService articleSearchService;

    /**
     * 添加文章  测试用的
     * @param article 文章的实体类
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article){
        articleSearchService.add(article);
        return new Result(true, StatusCode.OK,"添加成功");
    }

    /**
     * 文章的检索
     * @param keywords  关键字
     * @param page      页数
     * @param size      每页显示多少条数据
     * @return
     */
    @RequestMapping(value="/search/{keywords}/{page}/{size}",method= RequestMethod.GET)
    public Result findByTitleLike(@PathVariable String keywords,
                                  @PathVariable int page, @PathVariable int size){
        Page<Article> articlePage =
                articleSearchService.findByTitleLike(keywords,page,size);
        return new Result(true, StatusCode.OK, "查询成功",
                new PageResult<Article>(articlePage.getTotalElements(),
                        articlePage.getContent()));
    }
}
