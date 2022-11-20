package com.xuegao.wechatservermonolith.framework.config.mybatis;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.toolkit.GlobalConfigUtils;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.xuegao.mapper.config.PrintSqlInterceptor;
import com.xuegao.mapper.mpconfig.MybatisMetaObjectHandler;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class MybatisConfig {

    // @Bean
    // public PrintSqlInterceptor printSqlInterceptor() {
    //     return new PrintSqlInterceptor();
    // }

    @Bean
    public SqlSessionFactory sqlSessionFactory(@Autowired @Qualifier("dataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();

        //获取mybatis-plus全局配置
        GlobalConfig globalConfig = GlobalConfigUtils.defaults();
        //mybatis-plus全局配置设置元数据对象处理器为自己实现的那个
        globalConfig.setMetaObjectHandler(new MybatisMetaObjectHandler());
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        dbConfig.setIdType(IdType.AUTO);
        // dbConfig.setLogicDeleteField("del_flag");
        // dbConfig.setLogicDeleteValue(String.valueOf(DelFlagEnum.DEL_FLAG_0.getCode()));
        // dbConfig.setLogicNotDeleteValue(String.valueOf(DelFlagEnum.DEL_FLAG_1.getCode()));
        globalConfig.setDbConfig(dbConfig);

        mybatisSqlSessionFactoryBean.setDataSource(dataSource);
        //mybatisSqlSessionFactoryBean关联设置全局配置
        mybatisSqlSessionFactoryBean.setGlobalConfig(globalConfig);
        mybatisSqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*/*.xml"));

        // 添加插件
        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
        mybatisConfiguration.addInterceptor(new PrintSqlInterceptor());
        mybatisConfiguration.setMapUnderscoreToCamelCase(Boolean.TRUE);
        mybatisConfiguration.setLogImpl(StdOutImpl.class);
        mybatisSqlSessionFactoryBean.setConfiguration(mybatisConfiguration);

        return mybatisSqlSessionFactoryBean.getObject();
    }
}
