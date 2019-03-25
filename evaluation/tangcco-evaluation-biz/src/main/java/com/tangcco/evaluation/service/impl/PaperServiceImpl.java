package com.tangcco.evaluation.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tangcco.evaluation.dao.PaperMapper;
import com.tangcco.evaluation.service.PaperService;
import com.tangcoo.evaluation.dto.PageResult;
import com.tangcoo.evaluation.pojo.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * CreateDate: 2019/3/21 18:08
 */
@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Override
    public PageResult<Paper> findAllByExample(String date1,String date2,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Paper.class);
        example.setOrderByClause("create_time desc");
        Example.Criteria criteria = example.createCriteria();
        if(date1 != null && date2 != null){
            if(!date1.equals("") && !date2.equals("")){
                criteria.andBetween("createTime",date1,date2);
            }
        }
        List<Paper> papers = paperMapper.selectByExample(example);
        PageInfo<Paper> pageInfo=new PageInfo<>(papers) ;
        return new PageResult<Paper>(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList());
    }

    @Override
    public int save(Paper paper) {
        return paperMapper.insert(paper);
    }
}
