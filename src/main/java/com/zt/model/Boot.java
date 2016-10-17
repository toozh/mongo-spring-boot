package com.zt.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by fenxio on 2016/10/17.
 */
@Document(collection = "Boot")
@ApiModel(value = "boot", description = "boot 实体")
public class Boot {

    @Id
    @ApiModelProperty(value = "编号", name = "编号", notes = "编号")
    private Integer id;
    @ApiModelProperty(value = "名称", name = "名称", notes = "名称")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boot() {
    }

    public Boot(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Boot(String name) {
        this.name = name;
    }
}
