package com.xiaofu.subject.infra.basic.entity;

import com.xiaofu.common.entitiy.page.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;

/**
 * @author xiaofu
 * @date 2024/1/25 0:11
 * @des
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "subject_index")
public class SubjectInfoEs  extends PageInfo {
    @Field(type = FieldType.Long)
    @Id
    private Long id;

    private Long subjectId;

    private Long docId;

    @Field(type = FieldType.Text, analyzer = "ik_smart")
    private String subjectName;

    @Field(type = FieldType.Text, analyzer = "ik_smart")
    private String subjectAnswer;

    private Integer subjectType;

    private String keyWord;

    private BigDecimal score;

    @Field(type = FieldType.Keyword)
    private String createUser;

    @Field(type = FieldType.Date, index = false)
    private Long createTime;





}
