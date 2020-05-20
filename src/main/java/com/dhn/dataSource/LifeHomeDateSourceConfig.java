//package com.dhn.dataSource;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.tomcat.jdbc.pool.DataSource;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @description:
// * @author: Dong HuaNan
// * @date: 2020/5/14 16:30
// */
//
//
//@Configuration
//@MapperScan(basePackages ={"mapper的j包路径"},sqlSessionTemplateRef = "lifeSqlSessionTemplate")
//public class LifeHomeDateSourceConfig {
//
//    @Value("${spring.lifehomedatasource.url}")
//    private String dbUrl;
//
//    @Value("${spring.lifehomedatasource.username}")
//    private String dbUser;
//
//    @Value("${spring.lifehomedatasource.password}")
//    private String dbPassword;
//
//    @Value("${spring.lifehomedatasource.driverClassName}")
//    private String driver;
//
//    @Value("${spring.lifehomedatasource.max-active}")
//    private int max_active;
//
//    @Value("${spring.mybatis.mapper-locations}") //配置文件中的配置
//    private String mappers;
//
//    @Bean(name = "lifeHomeDataSource")
//    //@Primary //此注解表示在默认的数据源配置，即在默认配置时用到的数据源配置
//    public DataSource lifeHomeDataSource() {
//        DataSource dataSource = new DataSource();
//        dataSource.setDriverClassName(driver);
//        dataSource.setUrl(dbUrl);
//        dataSource.setUsername(dbUser);
//        dataSource.setPassword(dbPassword);
//        dataSource.setMaxActive(max_active);
//        dataSource.setTimeBetweenEvictionRunsMillis(3600000);
//        dataSource.setTestWhileIdle(true);
//        dataSource.setValidationQuery("select 1");
//        dataSource.setTestOnBorrow(false);
//        return dataSource;
//    }
//    @Bean(name = "lifeSqlSessionFactory")
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("lifeHomeDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/life/*.xml"));
//        return bean.getObject();
//    }
//    @Bean(name = "lifeTransactionManager")
//    public PlatformTransactionManager testTransactionManager(@Qualifier("lifeHomeDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//    @Bean(name = "lifeSqlSessionTemplate")
//    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("lifeSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//}
//
