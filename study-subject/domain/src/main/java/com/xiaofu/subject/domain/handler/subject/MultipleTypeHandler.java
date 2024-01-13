package com.xiaofu.subject.domain.handler.subject;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.xiaofu.subject.common.enums.SubjectInfoTypeEnum;
import com.xiaofu.subject.domain.covert.SubjectMultipleConverter;
import com.xiaofu.subject.domain.entity.SubjectInfoBO;
import com.xiaofu.subject.domain.handler.SubjectTypeHandler;
import com.xiaofu.subject.infra.basic.entity.SubjectMultiple;
import com.xiaofu.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/13 18:26
 * @des  多选题的策略类
 */
@Component
public class MultipleTypeHandler implements SubjectTypeHandler {
    @Autowired
    private SubjectMultipleService subjectMultipleService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 多选选题目的插入
        if (CollectionUtils.isEmpty(subjectInfoBO.getOptionList())) {
            return ;
        }
        List<SubjectMultiple> subjectMultipleList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectMultiple subjectMultiple = SubjectMultipleConverter.INSTANCE.covertBoToEntity(option);
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultipleList.add(subjectMultiple);
        });
        subjectMultipleService.saveBatch(subjectMultipleList);

    }
}
