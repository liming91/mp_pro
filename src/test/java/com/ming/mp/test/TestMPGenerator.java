package com.ming.mp.test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * MP代码生成器
 */
public class TestMPGenerator {

    @Test
    public void  testMP(){

        //1.全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //是否支持AR模式
        globalConfig.setActiveRecord(true);
        //作者
        globalConfig.setAuthor("liming");
        //生成路径
        globalConfig.setOutputDir("F:\\workspace\\mp_pro\\src\\main\\java");
        //文件覆盖
        globalConfig.setFileOverride(true);
        //主键策略
        globalConfig.setIdType(IdType.AUTO);
        //service接口的名字的首字母是否为I//这样设置接口名没有I
        globalConfig.setServiceName("%sService");
        //生成SQL映射文件
        globalConfig.setBaseResultMap(true);
        //sql片段
        globalConfig.setBaseColumnList(true);

        //2.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3307/mp?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("liming");
        dataSourceConfig.setPassword("liming");

        //3.策略配置
        StrategyConfig strategy = new StrategyConfig();
        //全局大写命名
        strategy.setCapitalMode(true);
        //指定表名字段名是否使用下划线
        strategy.setDbColumnUnderline(true);
        //数据库表映射到实体的策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setTablePrefix("tbl_");
        //生成的表
        strategy.setInclude("tbl_employee");
        //strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        //strategy.setEntityLombokModel(true);
       // strategy.setRestControllerStyle(true);

        //4.包名策略配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.ming.mp");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        pc.setEntity("beans");
        pc.setXml("mapper");

        //5.整合配置代码生成器
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(globalConfig);
        mpg.setDataSource(dataSourceConfig);
        mpg.setStrategy(strategy);
        mpg.setPackageInfo(pc);

        //6.执行
        mpg.execute();
    }
}
