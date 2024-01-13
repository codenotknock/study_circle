package com.xiaofu.subject.domain.handler.subject;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.xiaofu.subject.common.enums.SubjectInfoTypeEnum;
import com.xiaofu.subject.domain.covert.SubjectRadioConverter;
import com.xiaofu.subject.domain.entity.SubjectInfoBO;
import com.xiaofu.subject.domain.handler.SubjectTypeHandler;
import com.xiaofu.subject.infra.basic.entity.SubjectRadio;
import com.xiaofu.subject.infra.basic.service.SubjectRadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xiaofu
 * @date 2024/1/13 18:26
 * @des  单选题的策略类
 */
@Component
public class RadioTypeHandler implements SubjectTypeHandler {

    @Autowired
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 单选题目的插入
        if (CollectionUtils.isEmpty(subjectInfoBO.getOptionList())) {
            return ;
        }
        List<SubjectRadio> subjectRadioList = new LinkedList<>();
        subjectInfoBO.getOptionList().forEach(option -> {
            SubjectRadio subjectRadio = SubjectRadioConverter.INSTANCE.covertBoToEntity(option);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.saveBatch(subjectRadioList);

    }
}
