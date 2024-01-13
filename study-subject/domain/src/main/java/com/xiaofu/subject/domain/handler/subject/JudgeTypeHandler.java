package com.xiaofu.subject.domain.handler.subject;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.xiaofu.subject.common.enums.SubjectInfoTypeEnum;
import com.xiaofu.subject.domain.covert.SubjectJudgeConverter;
import com.xiaofu.subject.domain.entity.SubjectAnswerBO;
import com.xiaofu.subject.domain.entity.SubjectInfoBO;
import com.xiaofu.subject.domain.entity.SubjectOptionBO;
import com.xiaofu.subject.domain.handler.SubjectTypeHandler;
import com.xiaofu.subject.infra.basic.entity.SubjectJudge;
import com.xiaofu.subject.infra.basic.service.SubjectJudgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author xiaofu
 * @date 2024/1/13 18:26
 * @des  判断题的策略类
 */
@Component
public class JudgeTypeHandler implements SubjectTypeHandler {

    @Autowired
    private SubjectJudgeService subjectJudgeService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // 判断题的插入： 对或错
        if (CollectionUtils.isEmpty(subjectInfoBO.getOptionList())) {
            return;
        }
        SubjectJudge subjectJudge = new SubjectJudge();
        SubjectAnswerBO subjectAnswerBO = subjectInfoBO.getOptionList().get(0);
        subjectJudge.setSubjectId(subjectInfoBO.getId());
        subjectJudge.setIsCorrect(subjectAnswerBO.getIsCorrect());
        subjectJudgeService.save(subjectJudge);

    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectJudge subjectJudge = subjectJudgeService.lambdaQuery().eq(SubjectJudge::getSubjectId, subjectId).one();
        SubjectAnswerBO subjectAnswerBO = SubjectJudgeConverter.INSTANCE.covertEntityToBo(subjectJudge);
        return new SubjectOptionBO().setOptionList(Collections.singletonList(subjectAnswerBO));
    }
}
