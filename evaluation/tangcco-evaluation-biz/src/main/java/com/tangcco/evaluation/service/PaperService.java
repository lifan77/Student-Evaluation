package com.tangcco.evaluation.service;

import com.tangcoo.evaluation.dto.PageResult;
import com.tangcoo.evaluation.pojo.Paper;

/**
 * CreateDate: 2019/3/21 18:07
 */
public interface PaperService {
    /***
     * @author:liuxuan
     * @deprecated 查询历史评测
     * @return
     */
    PageResult<Paper> findAllByExample(Paper paper,Integer pageNum,Integer pageSize);

    /***
     * @author:liuxuan
     * @deprecated 发布评测
     * @return
     */
    void save(Paper paper);
}
