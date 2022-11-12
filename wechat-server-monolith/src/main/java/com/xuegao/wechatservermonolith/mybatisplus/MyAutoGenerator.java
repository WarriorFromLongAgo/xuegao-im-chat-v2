package com.xuegao.wechatservermonolith.mybatisplus;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

public class MyAutoGenerator {
    private static final Logger log = LoggerFactory.getLogger(MyAutoGenerator.class);

    public static void main(String[] args) {
        //1、全局配置
        String projectPath = System.getProperty("user.dir");
        log.info("[xuegao-im-chat-v2][MyAutoGenerator][main][projectPath={}]", projectPath);
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .outputDir(projectPath + "/src/main/java")
                .author("xuegao")
                .dateType(DateType.TIME_PACK)
                .commentDate("yyyy-MM-dd")
                .build();

        //2、数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig.Builder("jdbc:mysql://127.0.0.1:3306/xue_gao_write_and_use?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai&allowMultiQueries=true", "root", "123456")
                .typeConvert(new MySqlTypeConvert())
                .dbQuery(new MySqlQuery())
                .typeConvert(new MySqlTypeConvert())
                .keyWordsHandler(new MySqlKeyWordsHandler())
                .build();

        // 3、包配置
        // 包配置(PackageConfig)
        PackageConfig packageConfig = new PackageConfig.Builder()
                .parent("com.xuegao.wechatservermonolith")
                .moduleName("sysuser")
                .entity("model")
                .service("service")
                .serviceImpl("service.impl")
                .mapper("mapper")
                .xml("mapper.xml")
                .controller("controller")
                .pathInfo(Collections.singletonMap(OutputFile.xml, "D://"))
                .build();

        // 模板配置(TemplateConfig)
        TemplateConfig templateConfig = new TemplateConfig.Builder()
                .disable(TemplateType.ENTITY)
                .entity("/templates/entity.java")
                .service("/templates/service.java")
                .serviceImpl("/templates/serviceImpl.java")
                .mapper("/templates/mapper.java")
                .xml("/templates/mapper.xml")
                .controller("/templates/controller.java")
                .build();

        // 4、策略配置
        new StrategyConfig.Builder()
                .entityBuilder()
                .superClass(BaseEntity.class)
                .disableSerialVersionUID()
                .enableChainModel()
                .enableLombok()
                .enableRemoveIsPrefix()
                .enableTableFieldAnnotation()
                .enableActiveRecord()
                .versionColumnName("version")
                .versionPropertyName("version")
                .logicDeleteColumnName("deleted")
                .logicDeletePropertyName("deleteFlag")
                .naming(NamingStrategy.no_change)
                .columnNaming(NamingStrategy.underline_to_camel)
                .addSuperEntityColumns("id", "created_by", "created_time", "updated_by", "updated_time")
                .addIgnoreColumns("age")
                .addTableFills(new Column("create_time", FieldFill.INSERT))
                .addTableFills(new Property("updateTime", FieldFill.INSERT_UPDATE))
                .idType(IdType.AUTO)
                .formatFileName("%sEntity")
                .build();

        //5、执行
        mpg.execute();

    }
