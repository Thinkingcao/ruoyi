package com.ruoyi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
                            
/**
 * 测试表 sys_test
 *
 * @author ruoyi
 * @date 2019-09-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_test")
public class SysTest  extends BaseEntity implements Serializable
        {
private static final long serialVersionUID = 1L;

/** null */
private Long id;
/** null */
private String name;
/** null */
private String createBy;
/** null */
private Date createTime;
/** null */
private String updateBy;
/** null */
private Date updateTime;
/** null */
private Integer deleted;
}