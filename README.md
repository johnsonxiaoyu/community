## 小宇社区

## 资料
[Spring官方文档](https://spring.io/guides)  
[github官方api](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)  
[botstrap官方](https://v3.bootcss.com/)  
[mybatis官网](https://mybatis.org/mybatis-3/zh/index.html)  
[bootstrapvalidator源码](https://github.com/nghuuphuoc/bootstrapvalidator)  
[thymeleaf官网](https://www.thymeleaf.org/)
## 工具
[git地址](https://git-scm.com/)  
[pagehelper](https://pagehelper.github.io/)  
[editor.md](http://editor.md.ipandao.com/)  
## sql脚本
```` sql
CREATE TABLE `user` (
  `account_id` varchar(100) DEFAULT NULL,
  `id` varchar(100) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `token` varchar(100) DEFAULT NULL,
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modifid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `question` (
  `id` varchar(100) NOT NULL COMMENT '主键',
  `title` varchar(20) DEFAULT NULL COMMENT '标题',
  `description` text COMMENT '内容',
  `createuser` varchar(100) DEFAULT NULL COMMENT '创建人',
  `createtime` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `updatetime` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `status` varchar(2) DEFAULT '0' COMMENT '0已删除 1未删除',
  `tag` varchar(200) DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


````

## 待解决bug
1.问题提交页面  bootstrapvalidator 无法校验markdown富文本框
