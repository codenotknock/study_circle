package com.xiaofu.oss.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author xiaofu
 * @date 2024/1/14 19:04
 * @des 文件信息
 */
@Data
@Accessors(chain = true)
public class FileInfo {

    private String fileName;

    private boolean directoryFlag;

    private String etag;

}
