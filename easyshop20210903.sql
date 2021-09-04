/*
Navicat MySQL Data Transfer

Source Server         : 坏男的云
Source Server Version : 80025
Source Host           : 47.108.48.162:3306
Source Database       : easyshop

Target Server Type    : MYSQL
Target Server Version : 80025
File Encoding         : 65001

Date: 2021-09-03 20:15:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` bigint NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `admin_mobile` varchar(32) DEFAULT NULL,
  `admin_email` varchar(32) DEFAULT NULL,
  `login_name` varchar(32) DEFAULT NULL,
  `is_delete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', 'admin', '18727670856', '3355147798@qq.com', '真管理员', '0');
INSERT INTO `admin` VALUES ('2', 'zhuqianao520', '123456', '19827807173', '3355147798@qq.com', '虚假的管理员', '0');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键 分类id主键',
  `category_name` varchar(32) NOT NULL COMMENT '分类名称 分类名称',
  `category_level` int NOT NULL COMMENT '分类层级 分类得类型，\n1:一级大分类\n2:二级分类\n3:三级小分类',
  `parent_id` bigint NOT NULL COMMENT '父层级id 父id 上一级依赖的id，1级分类则为0，二级三级分别依赖上一级',
  `category_pic` varchar(64) DEFAULT NULL COMMENT '分类图',
  `category_bg_color` varchar(32) DEFAULT NULL COMMENT '背景颜色',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='商品分类';

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '点心/蛋糕', '1', '0', 'act1.png', 'black', '0');
INSERT INTO `category` VALUES ('2', '饼干/膨化', '1', '0', 'act2.png', 'black', '0');
INSERT INTO `category` VALUES ('3', '衣服/裤子', '1', '0', 'act3.png', 'black', '0');
INSERT INTO `category` VALUES ('4', '鞋子/袜子', '1', '0', 'act1.png', 'black', '0');
INSERT INTO `category` VALUES ('5', '电子产品', '1', '0', 'act2.png', 'black', '0');
INSERT INTO `category` VALUES ('6', '生活用品', '1', '0', 'act3.png', 'black', '0');
INSERT INTO `category` VALUES ('7', '蛋糕', '2', '1', null, null, '0');
INSERT INTO `category` VALUES ('8', '点心', '2', '1', null, null, '0');
INSERT INTO `category` VALUES ('9', '饼干', '2', '2', null, null, '0');
INSERT INTO `category` VALUES ('10', '薯片', '2', '2', null, null, '0');
INSERT INTO `category` VALUES ('11', '虾条', '2', '2', null, null, '0');
INSERT INTO `category` VALUES ('12', '衣服', '2', '3', null, null, '0');
INSERT INTO `category` VALUES ('13', '裤子', '2', '3', null, null, '0');
INSERT INTO `category` VALUES ('14', '鞋子', '2', '4', null, null, '0');
INSERT INTO `category` VALUES ('15', '袜子', '2', '4', null, null, '0');
INSERT INTO `category` VALUES ('16', '手机', '2', '5', null, null, '0');
INSERT INTO `category` VALUES ('17', '电脑', '2', '5', null, null, '0');
INSERT INTO `category` VALUES ('18', '平板', '2', '5', null, null, '0');
INSERT INTO `category` VALUES ('19', '厨具', '2', '6', null, null, '0');
INSERT INTO `category` VALUES ('20', '清洁产品', '2', '6', null, null, '0');
INSERT INTO `category` VALUES ('21', '蒸蛋糕', '3', '7', null, null, '0');
INSERT INTO `category` VALUES ('22', '脱水蛋糕', '3', '7', null, null, '0');
INSERT INTO `category` VALUES ('23', '虾饺', '3', '8', null, null, '0');
INSERT INTO `category` VALUES ('24', '小饼干', '3', '9', null, null, '0');
INSERT INTO `category` VALUES ('25', '油炸薯片', '3', '10', null, null, '0');
INSERT INTO `category` VALUES ('26', '油炸虾条', '3', '11', null, null, '0');
INSERT INTO `category` VALUES ('27', '风衣', '3', '12', null, null, '0');
INSERT INTO `category` VALUES ('28', '牛仔裤', '3', '13', null, null, '0');
INSERT INTO `category` VALUES ('29', '高跟鞋', '3', '14', null, null, '0');
INSERT INTO `category` VALUES ('30', '智能手机', '3', '16', null, null, '0');
INSERT INTO `category` VALUES ('31', '笔记本', '3', '17', null, null, '0');
INSERT INTO `category` VALUES ('32', '华为平板', '3', '18', null, null, '0');
INSERT INTO `category` VALUES ('33', '高压锅', '3', '19', null, null, '0');
INSERT INTO `category` VALUES ('34', '棉袜', '3', '15', null, null, '0');
INSERT INTO `category` VALUES ('35', '洗衣粉', '3', '20', null, null, '0');

-- ----------------------------
-- Table structure for index_img
-- ----------------------------
DROP TABLE IF EXISTS `index_img`;
CREATE TABLE `index_img` (
  `img_id` bigint NOT NULL COMMENT '主键',
  `img_url` varchar(128) NOT NULL COMMENT '图片 图片地址',
  `img_bg_color` varchar(32) DEFAULT NULL COMMENT '背景色 背景颜色',
  `prod_id` bigint DEFAULT NULL COMMENT '商品id 商品id',
  `category_id` bigint DEFAULT NULL COMMENT '商品分类id 商品分类id',
  `index_type` int NOT NULL COMMENT '轮播图类型 轮播图类型，用于判断，可以根据商品id或者分类进行页面跳转，1：商品 2：分类',
  `seq` int NOT NULL COMMENT '轮播图展示顺序 轮播图展示顺序，从小到大',
  `status` int NOT NULL COMMENT '是否展示:1表示正常显示，0表示下线 是否展示，1：展示    0：不展示',
  `gmt_create` datetime NOT NULL COMMENT '创建时间 创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间 更新',
  PRIMARY KEY (`img_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='轮播图 ';

-- ----------------------------
-- Records of index_img
-- ----------------------------
INSERT INTO `index_img` VALUES ('1', 'ad1.jpg', 'green', '101', null, '1', '1', '1', '2021-06-04 17:21:13', '2021-06-04 17:21:18');
INSERT INTO `index_img` VALUES ('2', 'ad2.jpg', 'pink', null, '1', '2', '2', '1', '2021-06-04 17:21:49', '2021-06-04 17:21:52');
INSERT INTO `index_img` VALUES ('3', 'ad3.jpg', 'black', '103', null, '1', '3', '1', '2021-06-04 17:22:23', '2021-06-04 17:22:27');
INSERT INTO `index_img` VALUES ('4', 'ad4.jpg', 'orange', null, '2', '2', '4', '1', '2021-06-04 17:23:06', '2021-06-04 17:23:08');
INSERT INTO `index_img` VALUES ('5', 'ad5.jpg', 'yellow', '101', null, '1', '2', '0', '2021-06-04 09:34:01', '2021-06-04 09:34:05');

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `item_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单项ID',
  `order_id` bigint NOT NULL COMMENT '订单ID',
  `product_id` bigint NOT NULL COMMENT '商品ID',
  `product_name` varchar(32) NOT NULL COMMENT '商品名称',
  `product_img` varchar(32) DEFAULT NULL COMMENT '商品图片',
  `sku_id` bigint DEFAULT NULL COMMENT 'skuID',
  `sku_name` varchar(32) DEFAULT NULL COMMENT 'sku名称',
  `product_price` decimal(32,8) DEFAULT NULL COMMENT '商品价格',
  `buy_counts` int DEFAULT NULL COMMENT '购买数量',
  `total_amount` decimal(32,8) DEFAULT NULL COMMENT '商品总金额',
  `basket_date` datetime DEFAULT NULL COMMENT '加入购物车时间',
  `buy_time` datetime DEFAULT NULL COMMENT '购买时间',
  `is_comment` int(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '评论状态： 0 未评价  1 已评价',
  `gmt_create` datetime(6) DEFAULT NULL,
  `gmt_modify` datetime(6) DEFAULT NULL COMMENT '修改时间',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`item_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4283219 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='订单项/快照 ';

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES ('1', '10001', '1', '奥利奥小饼干', '1.jpg', null, '', '10.00000000', '1', '10.00000000', '2021-06-16 16:01:52', '2021-06-16 16:01:52', '1', '2021-06-14 16:01:53.000000', '2021-06-16 16:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('2', '10001', '2', '汪汪华夫饼', '2.jpg', null, '', '18.00000000', '1', '18.00000000', '2021-06-17 16:01:53', '2021-06-17 16:01:53', '1', '2021-06-16 16:01:52.000000', '2021-06-17 16:01:53.000000', '0');
INSERT INTO `order_item` VALUES ('3', '10001', '3', 'GUCCI风衣', '3.jpg', null, '', '800.00000000', '1', '800.00000000', '2021-06-18 16:01:52', '2021-06-18 16:01:52', '1', '2021-06-14 16:01:53.000000', '2021-06-18 16:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('4', '100083', '1', '奥利奥小饼干', '1.jpg', null, '', '10.00000000', '1', '10.00000000', '2021-06-19 16:01:52', '2021-06-19 16:01:52', '0', '2021-06-16 16:01:52.000000', '2021-06-19 16:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('5', '100083', '3', 'GUCCI风衣', '3.jpg', null, '', '800.00000000', '1', '800.00000000', '2021-06-16 16:01:52', '2021-06-16 16:01:52', '0', '2021-06-12 16:01:53.000000', '2021-06-20 16:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('6', '100070', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, '', '18.00000000', '7', '126.00000000', '2021-06-17 16:01:53', null, '0', '2021-06-16 16:01:52.000000', '2021-06-21 16:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('7', '100082', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, '', '10.00000000', '12', '120.00000000', '2021-06-18 16:01:52', null, '0', '2021-06-14 16:01:53.000000', '2021-06-15 16:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('8', '100094', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, '', '18.00000001', '17', '306.00000017', '2021-06-19 16:01:52', null, '1', '2021-06-16 16:01:52.000000', null, '0');
INSERT INTO `order_item` VALUES ('9', '100106', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, '', '10.00000001', '22', '220.00000022', '2021-06-14 16:01:53', null, '0', '2021-06-14 16:01:53.000000', '2021-06-17 16:01:53.000000', '0');
INSERT INTO `order_item` VALUES ('10', '100118', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, '', '18.00000002', '27', '486.00000054', '2021-06-16 16:01:52', null, '0', '2021-06-16 16:01:52.000000', '2021-06-18 16:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('11', '100130', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, '', '10.00000002', '32', '320.00000064', '2021-06-17 16:01:53', null, '0', '2021-06-14 16:01:53.000000', '2021-06-19 16:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('12', '100142', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, '', '18.00000003', '37', '666.00000111', '2021-06-18 16:01:52', null, '0', '2021-06-16 16:01:52.000000', '2021-06-14 16:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('13', '100154', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, '', '10.00000003', '42', '420.00000126', '2021-06-19 16:01:52', null, '0', '2021-06-14 16:01:53.000000', '2021-06-16 16:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('14', '100166', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, '', '18.00000004', '47', '846.00000188', '2021-06-16 16:01:52', null, '0', '2021-06-16 16:01:52.000000', '2021-06-15 16:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('15', '100178', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, '', '10.00000004', '52', '520.00000208', '2021-06-14 16:01:53', null, '0', '2021-06-14 16:01:53.000000', '2021-06-15 16:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('33221', '100092', '10', 'LV高跟鞋', 'LV高跟鞋1.jpg', null, null, '600.00000000', '1', null, null, null, '0', '2021-06-18 17:17:15.757000', null, '0');
INSERT INTO `order_item` VALUES ('123321', '100092', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, '', '18.00000006', '67', '1206.00000400', '2021-06-16 16:01:52', null, '0', '2021-06-16 16:01:52.000000', null, '0');
INSERT INTO `order_item` VALUES ('123322', '100214', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, '', '18.00000006', '67', '1206.00000400', '2021-06-16 16:01:52', null, '0', '2021-06-16 16:01:52.000000', '2021-06-16 16:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('123323', '100084', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, null, '18.00000000', '7', null, null, null, '0', '2021-06-18 15:18:37.490000', null, '0');
INSERT INTO `order_item` VALUES ('123324', '100085', '2', '旺旺华夫饼', '旺旺华夫饼1.jpg', null, null, '20.00000000', '4', null, null, null, '0', '2021-06-18 15:37:29.786000', null, '0');
INSERT INTO `order_item` VALUES ('123325', '100086', '4', '旺旺雪饼', '旺旺雪饼1.jpg', null, null, '40.00000000', '1', null, null, null, '0', '2021-06-18 15:42:32.810000', null, '0');
INSERT INTO `order_item` VALUES ('123326', '100087', '4', '旺旺雪饼', '旺旺雪饼1.jpg', null, null, '40.00000000', '1', null, null, null, '0', '2021-06-18 15:47:08.083000', null, '0');
INSERT INTO `order_item` VALUES ('123327', '100089', '2', '旺旺华夫饼', '旺旺华夫饼1.jpg', null, null, '20.00000000', '4', null, null, null, '0', '2021-06-18 15:47:39.388000', null, '0');
INSERT INTO `order_item` VALUES ('123328', '100090', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, null, '10.00000000', '2', null, null, null, '0', '2021-06-18 16:43:29.816000', null, '0');
INSERT INTO `order_item` VALUES ('123329', '100090', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, '1800.00000000', '1', null, null, null, '0', '2021-06-18 16:43:29.816000', null, '0');
INSERT INTO `order_item` VALUES ('123330', '100090', '6', '虾饺', '水晶虾饺1.jpg', null, null, '15.00000000', '1', null, null, null, '0', '2021-06-18 16:43:29.816000', null, '0');
INSERT INTO `order_item` VALUES ('123331', '100090', '2', '旺旺华夫饼', '旺旺华夫饼1.jpg', null, null, '20.00000000', '4', null, null, null, '0', '2021-06-18 16:43:29.818000', null, '0');
INSERT INTO `order_item` VALUES ('123332', '100091', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, '1800.00000000', '1', null, null, null, '0', '2021-06-18 17:14:11.434000', null, '0');
INSERT INTO `order_item` VALUES ('123333', '100091', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, '1800.00000000', '1', null, null, null, '0', '2021-06-18 17:14:11.438000', null, '0');
INSERT INTO `order_item` VALUES ('123334', '100091', '3', '咪咪虾条', '咪咪虾条1.jpg', null, null, '25.00000000', '1', null, null, null, '0', '2021-06-18 17:14:11.439000', null, '0');
INSERT INTO `order_item` VALUES ('332211', '100092', '7', '乐事薯片', '乐事薯片1.jpg', null, null, '6.00000000', '3', null, null, null, '0', '2021-06-18 17:17:15.756000', null, '0');
INSERT INTO `order_item` VALUES ('4283154', '100093', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, '1800.00000000', '1', null, null, null, '1', '2021-06-19 11:39:11.063000', null, '0');
INSERT INTO `order_item` VALUES ('4283155', '100093', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, null, '10.00000000', '1', null, null, null, '1', '2021-06-19 11:39:11.063000', null, '0');
INSERT INTO `order_item` VALUES ('4283156', '100093', '2', '旺旺华夫饼', '旺旺华夫饼1.jpg', null, null, '20.00000000', '1', null, null, null, '1', '2021-06-19 11:39:11.063000', null, '0');
INSERT INTO `order_item` VALUES ('4283157', '100190', '2', '汪汪华夫饼', '2.jpg', null, '', '18.00000000', '1', '18.00000000', '2021-06-17 16:01:53', '2021-06-17 16:01:53', '0', '2021-06-17 16:01:53.000000', '2021-06-17 16:01:53.000000', '0');
INSERT INTO `order_item` VALUES ('4283158', '100202', '2', '汪汪华夫饼', '3.jpg', null, '', '18.00000001', '2', '18.00000001', '2021-06-17 19:01:53', null, '0', '2021-06-17 19:01:53.000000', '2021-06-17 19:01:53.000000', '0');
INSERT INTO `order_item` VALUES ('4283159', '100214', '2', '汪汪华夫饼', '4.jpg', null, '', '18.00000002', '3', '18.00000002', '2021-06-17 22:01:52', null, '0', '2021-06-15 22:01:52.000000', '2021-06-17 22:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('4283160', '100226', '2', '汪汪华夫饼', '5.jpg', null, '', '18.00000003', '4', '18.00000003', '2021-06-18 01:01:52', null, '0', '2021-06-16 01:01:52.000000', '2021-06-15 01:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('4283161', '100238', '2', '汪汪华夫饼', '6.jpg', null, '', '18.00000004', '5', '18.00000004', '2021-06-18 04:01:52', null, '0', '2021-06-17 10:01:52.000000', '2021-06-18 04:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('4283162', '100250', '2', '汪汪华夫饼', '7.jpg', null, '', '18.00000005', '6', '18.00000005', '2021-06-18 07:01:52', null, '0', '2021-06-12 10:01:52.000000', '2021-06-18 07:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('4283163', '100262', '2', '汪汪华夫饼', '8.jpg', null, '', '18.00000006', '7', '18.00000006', '2021-06-18 10:01:52', null, '0', '2021-06-17 10:01:52.000000', '2021-06-18 10:01:52.000000', '0');
INSERT INTO `order_item` VALUES ('4283164', '100092', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, '1800.00000000', '1', null, null, null, '1', '2021-06-18 17:14:11.438000', null, '0');
INSERT INTO `order_item` VALUES ('4283165', '100094', '2', '旺旺华夫饼', '旺旺华夫饼1.jpg', null, null, '20.00000000', '1', null, null, null, '1', '2021-06-19 12:24:15.188000', null, '0');
INSERT INTO `order_item` VALUES ('4283166', '100094', '3', '咪咪虾条', '咪咪虾条1.jpg', null, null, '25.00000000', '1', null, null, null, '1', '2021-06-19 12:24:15.201000', null, '0');
INSERT INTO `order_item` VALUES ('4283170', '100095', '10', 'LV高跟鞋', 'LV高跟鞋1.jpg', null, null, '600.00000000', '1', null, null, null, '1', '2021-06-19 15:46:07.294000', null, '0');
INSERT INTO `order_item` VALUES ('4283171', '100095', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, '1800.00000000', '2', null, null, null, '1', '2021-06-19 15:46:07.501000', null, '0');
INSERT INTO `order_item` VALUES ('4283174', '100092', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, null, null, null, null, null, '0', '2021-06-19 15:53:12.173000', null, '0');
INSERT INTO `order_item` VALUES ('4283175', '100096', '5', '港荣蒸蛋糕', '港荣蒸蛋糕1.jpg', null, null, '50.00000000', '1', null, null, null, '0', '2021-06-19 17:20:41.955000', null, '0');
INSERT INTO `order_item` VALUES ('4283176', '100096', '2', '旺旺华夫饼', '旺旺华夫饼1.jpg', null, null, '20.00000000', '1', null, null, null, '0', '2021-06-19 17:20:41.960000', null, '0');
INSERT INTO `order_item` VALUES ('4283177', '100097', '2', '旺旺华夫饼', '旺旺华夫饼1.jpg', null, null, '20.00000000', '1', null, null, null, '0', '2021-06-19 17:23:57.544000', null, '0');
INSERT INTO `order_item` VALUES ('4283178', '100098', '3', '咪咪虾条', '咪咪虾条1.jpg', null, null, '25.00000000', '1', null, null, null, '0', '2021-06-19 17:25:20.407000', null, '0');
INSERT INTO `order_item` VALUES ('4283179', '100099', '3', '咪咪虾条', '咪咪虾条1.jpg', null, null, '25.00000000', '1', null, null, null, '0', '2021-06-19 17:31:12.454000', null, '0');
INSERT INTO `order_item` VALUES ('4283180', '100100', '2', '旺旺华夫饼', '旺旺华夫饼1.jpg', null, null, '20.00000000', '1', null, null, null, '0', '2021-06-19 17:35:48.576000', null, '0');
INSERT INTO `order_item` VALUES ('4283181', '100101', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, '1800.00000000', '1', null, null, null, '0', '2021-06-19 17:40:00.299000', null, '0');
INSERT INTO `order_item` VALUES ('4283182', '100101', '6', '虾饺', '水晶虾饺1.jpg', null, null, '15.00000000', '1', null, null, null, '0', '2021-06-19 17:40:00.299000', null, '0');
INSERT INTO `order_item` VALUES ('4283185', '100102', '2', '旺旺华夫饼', '旺旺华夫饼1.jpg', null, null, '20.00000000', '2', null, null, null, '0', '2021-06-19 18:08:02.507000', null, '0');
INSERT INTO `order_item` VALUES ('4283186', '100102', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, '1800.00000000', '1', null, null, null, '0', '2021-06-19 18:08:02.519000', null, '0');
INSERT INTO `order_item` VALUES ('4283188', '100103', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, '1800.00000000', '1', null, null, null, '0', '2021-06-19 19:02:26.181000', null, '0');
INSERT INTO `order_item` VALUES ('4283189', '100104', '2', '旺旺华夫饼', '旺旺华夫饼1.jpg', null, null, '35.00000000', '1', null, null, null, '0', '2021-06-19 19:05:44.128000', null, '0');
INSERT INTO `order_item` VALUES ('4283190', '100105', '3', '咪咪虾条', '咪咪虾条1.jpg', null, null, '25.00000000', '1', null, null, null, '0', '2021-06-19 19:06:23.875000', null, '0');
INSERT INTO `order_item` VALUES ('4283191', '100105', '15', '南极人棉袜', '南极人棉袜1.jpg', null, null, '10.00000000', '1', null, null, null, '0', '2021-06-19 19:06:23.876000', null, '0');
INSERT INTO `order_item` VALUES ('4283192', '100105', '2', '旺旺华夫饼', '旺旺华夫饼1.jpg', null, null, '20.00000000', '3', null, null, null, '0', '2021-06-19 19:06:23.878000', null, '0');
INSERT INTO `order_item` VALUES ('4283193', '100106', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, null, '10.00000000', '3', null, null, null, '0', '2021-06-19 19:08:20.527000', null, '0');
INSERT INTO `order_item` VALUES ('4283195', '100107', '2', '旺旺华夫饼', '旺旺华夫饼1.jpg', null, null, '20.00000000', '1', null, null, null, '0', '2021-06-19 19:31:52.868000', null, '0');
INSERT INTO `order_item` VALUES ('4283196', '100107', '3', '咪咪虾条', '咪咪虾条1.jpg', null, null, '25.00000000', '1', null, null, null, '0', '2021-06-19 19:31:52.872000', null, '0');
INSERT INTO `order_item` VALUES ('4283197', '100107', '7', '乐事薯片', '乐事薯片1.jpg', null, null, '6.00000000', '1', null, null, null, '0', '2021-06-19 19:31:52.872000', null, '0');
INSERT INTO `order_item` VALUES ('4283198', '100107', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, '1800.00000000', '1', null, null, null, '0', '2021-06-19 19:31:52.896000', null, '0');
INSERT INTO `order_item` VALUES ('4283199', '100107', '11', '华为mate40手机', '华为mate40手机1.jpg', null, null, '4888.00000000', '1', null, null, null, '0', '2021-06-19 19:31:52.925000', null, '0');
INSERT INTO `order_item` VALUES ('4283200', '100108', '3', '咪咪虾条', '咪咪虾条1.jpg', null, null, '25.00000000', '1', null, null, null, '1', '2021-06-19 19:32:32.043000', null, '0');
INSERT INTO `order_item` VALUES ('4283201', '100108', '10', 'LV高跟鞋', 'LV高跟鞋1.jpg', null, null, '600.00000000', '1', null, null, null, '1', '2021-06-19 19:32:32.058000', null, '0');
INSERT INTO `order_item` VALUES ('4283203', '100092', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, null, null, null, null, null, '0', '2021-06-19 21:09:01.408000', null, '0');
INSERT INTO `order_item` VALUES ('4283204', '100092', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, null, null, null, null, null, '0', '2021-06-19 21:30:31.782000', null, '0');
INSERT INTO `order_item` VALUES ('4283205', '100092', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, null, null, null, null, null, '0', '2021-06-19 23:03:13.609000', null, '0');
INSERT INTO `order_item` VALUES ('4283206', '100109', '4', '旺旺雪饼', '旺旺雪饼1.jpg', null, null, '40.00000000', '1', null, null, null, '0', '2021-06-20 09:13:07.004000', null, '0');
INSERT INTO `order_item` VALUES ('4283207', '100109', '2', '旺旺华夫饼', '旺旺华夫饼1.jpg', null, null, '35.00000000', '5', null, null, null, '0', '2021-06-20 09:13:07.005000', null, '0');
INSERT INTO `order_item` VALUES ('4283208', '100109', '6', '虾饺', '水晶虾饺1.jpg', null, null, '15.00000000', '4', null, null, null, '0', '2021-06-20 09:13:07.066000', null, '0');
INSERT INTO `order_item` VALUES ('4283209', '100109', '16', '超能洗衣粉', '超能洗衣粉1.jpg', null, null, '20.00000000', '1', null, null, null, '0', '2021-06-20 09:13:07.105000', null, '0');
INSERT INTO `order_item` VALUES ('4283210', '100110', '7', '乐事薯片', '乐事薯片1.jpg', null, null, '6.00000000', '1', null, null, null, '0', '2021-06-20 09:31:45.778000', null, '0');
INSERT INTO `order_item` VALUES ('4283211', '100111', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, null, '10.00000000', '1', null, null, null, '0', '2021-06-20 10:20:00.205000', null, '0');
INSERT INTO `order_item` VALUES ('4283212', '100111', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, '1800.00000000', '1', null, null, null, '0', '2021-06-20 10:20:00.223000', null, '0');
INSERT INTO `order_item` VALUES ('4283213', '100112', '3', '咪咪虾条', '咪咪虾条1.jpg', null, null, '25.00000000', '1', null, null, null, '1', '2021-06-20 10:21:22.867000', null, '0');
INSERT INTO `order_item` VALUES ('4283214', '100092', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, null, null, null, null, null, '0', '2021-09-03 11:26:49.347000', null, '0');
INSERT INTO `order_item` VALUES ('4283215', '100113', '1', '奥利奥小饼干', '奥利奥小饼干1.jpg', null, null, '10.00000000', '2', null, null, null, '1', '2021-09-03 19:29:06.189000', null, '0');
INSERT INTO `order_item` VALUES ('4283216', '100113', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, '1800.00000000', '3', null, null, null, '1', '2021-09-03 19:29:06.187000', null, '0');
INSERT INTO `order_item` VALUES ('4283217', '100113', '2', '旺旺华夫饼', '旺旺华夫饼1.jpg', null, null, '20.00000000', '1', null, null, null, '1', '2021-09-03 19:29:06.190000', null, '0');
INSERT INTO `order_item` VALUES ('4283218', '100092', '8', 'GUCCI风衣', 'GUCCI风衣1.jpg', null, null, null, null, null, null, null, '0', '2021-09-03 19:59:34.486000', null, '0');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `order_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单ID 同时也是订单编号',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `address_id` bigint NOT NULL COMMENT '与订单关联的地址id',
  `receiver_name` varchar(32) DEFAULT NULL COMMENT '收货人快照',
  `receiver_mobile` varchar(32) DEFAULT NULL COMMENT '收货人手机号快照',
  `receiver_address` varchar(128) DEFAULT NULL COMMENT '收货地址快照',
  `total_amount` decimal(32,8) DEFAULT NULL COMMENT '订单总价格',
  `actual_amount` int DEFAULT NULL COMMENT '实际支付总价格',
  `pay_type` int DEFAULT NULL COMMENT '支付方式 1:微信 2:支付宝',
  `order_remark` varchar(32) DEFAULT NULL COMMENT '订单备注',
  `status` varchar(32) DEFAULT NULL COMMENT '订单状态 1:待付款 2:待发货 3:待收货 4:待评价 5:已完成 6:已关闭',
  `delivery_type` varchar(32) DEFAULT NULL COMMENT '配送方式',
  `delivery_flow_id` bigint DEFAULT NULL COMMENT '物流单号',
  `order_freight` decimal(32,8) DEFAULT '0.00000000' COMMENT '订单运费 默认可以为零，代表包邮',
  `pay_time` datetime DEFAULT NULL COMMENT '付款时间',
  `delivery_time` datetime DEFAULT NULL COMMENT '发货时间',
  `flish_time` datetime DEFAULT NULL COMMENT '完成时间',
  `cancel_time` datetime DEFAULT NULL COMMENT '取消时间',
  `close_type` int DEFAULT NULL COMMENT '订单关闭类型1-超时未支付 2-退款关闭 4-买家取消 15-已通过货到付款交易',
  `gmt_modify` datetime(6) DEFAULT NULL COMMENT '更新时间',
  `gmt_create` datetime(6) DEFAULT NULL COMMENT '创建时间（成交时间）',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '逻辑删除状态 1: 删除 0:未删除',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=100114 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='订单 ';

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('10001', '1', '520', '朱千奥', '18727670856', '四川成都', '280.00000000', '280', '2', '搞快发，急着用', '5', '中通', '565645612312312', '0.00000000', '2021-06-08 14:41:16', null, null, null, null, null, '2021-06-08 14:41:16.000000', '0');
INSERT INTO `orders` VALUES ('100061', '1', '520', '朱千奥', '18727670856', '上乘', '35.00000000', '19', '2', null, '4', null, null, '0.00000000', '2021-06-17 10:06:50', null, null, null, null, null, '2021-06-17 10:02:31.010000', '0');
INSERT INTO `orders` VALUES ('100070', '1', '520', '朱千奥', '18727670856', '上乘', '126.00000000', '110', '2', null, '4', null, null, '0.00000000', '2021-06-17 10:42:09', null, null, null, null, null, '2021-06-17 10:41:26.477000', '0');
INSERT INTO `orders` VALUES ('100081', '1', '44', '谭轶雯', '12345612345', '上乘数据大厦', '45.00000000', '29', '2', null, '1', null, null, '0.00000000', null, null, null, null, null, null, '2021-06-17 15:19:30.622000', '0');
INSERT INTO `orders` VALUES ('100082', '1', '44', '谭轶雯', '12345612345', '上乘数据大厦', '120.00000000', '104', '2', null, '4', null, null, '0.00000000', '2021-06-18 09:09:10', null, null, null, null, null, '2021-06-18 09:08:42.633000', '0');
INSERT INTO `orders` VALUES ('100084', '1', '520', '朱千奥', '18727670856', '上乘', '126.00000000', '110', '2', null, '4', null, null, '0.00000000', '2021-06-18 15:19:22', null, null, null, null, null, '2021-06-18 15:18:37.444000', '0');
INSERT INTO `orders` VALUES ('100085', '1', '520', '朱千奥', '18727670856', '上乘', '80.00000000', '64', '2', null, '4', null, null, '0.00000000', '2021-06-18 15:38:21', null, null, null, null, null, '2021-06-18 15:37:29.736000', '0');
INSERT INTO `orders` VALUES ('100086', '1', '520', '朱千奥', '18727670856', '上乘', '40.00000000', '24', '2', null, '4', null, null, '0.00000000', '2021-06-18 15:44:12', null, null, null, null, null, '2021-06-18 15:42:08.513000', '0');
INSERT INTO `orders` VALUES ('100087', '1', '520', '朱千奥', '18727670856', '上乘', '40.00000000', '24', '2', null, '1', null, null, '0.00000000', null, null, null, null, null, null, '2021-06-18 15:44:44.977000', '0');
INSERT INTO `orders` VALUES ('100088', '1', '520', '朱千奥', '18727670856', '上乘', '40.00000000', '24', '2', null, '1', null, null, '0.00000000', null, null, null, null, null, null, '2021-06-18 15:47:08.093000', '0');
INSERT INTO `orders` VALUES ('100089', '1', '520', '朱千奥', '18727670856', '上乘', '80.00000000', '64', '2', null, '2', null, null, '0.00000000', '2021-06-18 15:48:18', null, null, null, null, null, '2021-06-18 15:47:31.474000', '0');
INSERT INTO `orders` VALUES ('100090', '1', '520', '朱千奥', '18727670856', '上乘', '1915.00000000', '1899', '2', null, '2', null, null, '0.00000000', '2021-06-18 16:44:55', null, null, null, null, null, '2021-06-18 16:43:29.671000', '0');
INSERT INTO `orders` VALUES ('100092', '29', '52', '朱千奥我爱你', '18727670856', '四川大学江安校区', '618.00000000', '622', '2', null, '4', null, null, '0.00000000', '2021-06-18 17:17:40', null, null, null, null, null, '2021-06-18 17:17:15.687000', '0');
INSERT INTO `orders` VALUES ('100093', '32', '61', '黄武我爱你', '13245677654', '四川大学望江校区', '1830.00000000', '1834', '2', null, '5', null, null, '0.00000000', '2021-06-19 11:41:46', null, null, null, null, null, '2021-06-19 11:39:10.852000', '0');
INSERT INTO `orders` VALUES ('100094', '32', '61', '黄武我爱你', '13245677654', '四川大学望江校区', '45.00000000', '49', '2', null, '5', null, null, '0.00000000', '2021-06-19 12:25:54', null, null, null, null, null, '2021-06-19 12:24:14.952000', '0');
INSERT INTO `orders` VALUES ('100095', '29', '52', '朱千奥我爱你', '18727670856', '四川大学江安校区', '4200.00000000', '4204', '2', null, '5', null, null, '0.00000000', '2021-06-19 15:46:41', null, null, null, null, null, '2021-06-19 15:46:07.143000', '0');
INSERT INTO `orders` VALUES ('100096', '29', '52', '朱千奥我爱你', '18727670856', '四川大学江安校区', '70.00000000', '74', '2', null, '1', null, null, '0.00000000', null, null, null, null, null, null, '2021-06-19 17:20:41.836000', '0');
INSERT INTO `orders` VALUES ('100097', '29', '52', '朱千奥我爱你', '18727670856', '四川大学江安校区', '20.00000000', '24', '2', null, '1', null, null, '0.00000000', null, null, null, null, null, null, '2021-06-19 17:23:57.466000', '0');
INSERT INTO `orders` VALUES ('100098', '29', '52', '朱千奥我爱你', '18727670856', '四川大学江安校区', '25.00000000', '29', '2', null, '1', null, null, '0.00000000', null, null, null, null, null, null, '2021-06-19 17:25:20.310000', '0');
INSERT INTO `orders` VALUES ('100099', '29', '52', '朱千奥我爱你', '18727670856', '四川大学江安校区', '25.00000000', '29', '2', null, '1', null, null, '0.00000000', null, null, null, null, null, null, '2021-06-19 17:31:12.340000', '0');
INSERT INTO `orders` VALUES ('100100', '29', '52', '朱千奥我爱你', '18727670856', '四川大学江安校区', '20.00000000', '24', '2', null, '1', null, null, '0.00000000', null, null, null, null, null, null, '2021-06-19 17:35:48.456000', '0');
INSERT INTO `orders` VALUES ('100101', '29', '52', '朱千奥我爱你', '18727670856', '四川大学江安校区', '1815.00000000', '1819', '2', null, '2', null, null, '0.00000000', '2021-06-19 17:40:34', null, null, null, null, null, '2021-06-19 17:40:00.172000', '0');
INSERT INTO `orders` VALUES ('100102', '29', '52', '朱千奥我爱你', '18727670856', '四川大学江安校区', '1840.00000000', '1844', '2', null, '1', null, null, '0.00000000', null, null, null, null, null, null, '2021-06-19 18:08:02.264000', '0');
INSERT INTO `orders` VALUES ('100103', '24', '56', '黄六', '123', '川大', '1800.00000000', '1804', '2', null, '1', null, null, '0.00000000', null, null, null, null, null, null, '2021-06-19 19:02:26.095000', '0');
INSERT INTO `orders` VALUES ('100104', '24', '54', '黄武', '13212341234', '四川大学望江校区', '35.00000000', '39', '2', null, '1', null, null, '0.00000000', null, null, null, null, null, null, '2021-06-19 19:05:44.061000', '0');
INSERT INTO `orders` VALUES ('100105', '29', '52', '朱千奥我爱你', '18727670856', '四川大学江安校区', '95.00000000', '99', '2', null, '2', null, null, '0.00000000', '2021-06-19 19:07:00', null, null, null, null, null, '2021-06-19 19:06:23.746000', '0');
INSERT INTO `orders` VALUES ('100106', '24', '54', '黄武', '13212341234', '四川大学望江校区', '30.00000000', '34', '2', null, '1', null, null, '0.00000000', null, null, null, null, null, null, '2021-06-19 19:08:20.459000', '0');
INSERT INTO `orders` VALUES ('100107', '31', '521', '黄武', '13212345678', '四川大学望江校区', '6739.00000000', '6743', '2', null, '2', null, null, '0.00000000', '2021-06-19 19:41:21', null, null, null, null, null, '2021-06-19 19:31:52.724000', '0');
INSERT INTO `orders` VALUES ('100108', '31', '521', '黄武', '13212345678', '四川大学望江校区', '625.00000000', '629', '2', null, '5', null, null, '0.00000000', '2021-06-19 19:39:08', null, null, null, null, null, '2021-06-19 19:32:31.947000', '0');
INSERT INTO `orders` VALUES ('100109', '1', '44', '谭轶雯', '12345612345', '上乘数据大厦', '295.00000000', '299', '2', null, '2', null, null, '0.00000000', '2021-06-20 09:14:27', null, null, null, null, null, '2021-06-20 09:13:06.805000', '0');
INSERT INTO `orders` VALUES ('100110', '24', '54', '黄武', '13212341234', '四川大学望江校区', '6.00000000', '10', '2', null, '1', null, null, '0.00000000', null, null, null, null, null, null, '2021-06-20 09:31:45.641000', '0');
INSERT INTO `orders` VALUES ('100111', '29', '52', '朱千奥我爱你', '18727670856', '四川大学江安校区', '1810.00000000', '1814', '2', null, '1', null, null, '0.00000000', null, null, null, null, null, null, '2021-06-20 10:20:00.104000', '0');
INSERT INTO `orders` VALUES ('100112', '29', '52', '朱千奥我爱你', '18727670856', '四川大学江安校区', '25.00000000', '29', '2', null, '5', null, null, '0.00000000', '2021-06-20 10:22:32', null, null, null, null, null, '2021-06-20 10:21:22.763000', '0');
INSERT INTO `orders` VALUES ('100113', '29', '522', '王子渊', '18727670856', '上程', '5440.00000000', '5444', '2', null, '5', null, null, '0.00000000', '2021-09-03 19:31:52', null, null, null, null, null, '2021-09-03 19:29:06.124000', '0');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品主键id',
  `product_name` varchar(32) NOT NULL COMMENT '商品名称 商品名称',
  `category_id` bigint DEFAULT NULL COMMENT '分类外键id 分类id',
  `root_category_id` bigint DEFAULT NULL COMMENT '一级分类外键id 一级分类id，用于优化查询',
  `sold_num` int DEFAULT '0' COMMENT '销量 累计销售',
  `product_status` int NOT NULL DEFAULT '1' COMMENT '默认是1，表示正常状态, -1表示删除, 0下架 默认是1，表示正常状态, -1表示删除, 0下架',
  `content` text COMMENT '商品内容 商品内容',
  `gmt_creat` datetime DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='商品 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表';

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '奥利奥小饼干', '24', '2', '196', '1', '口感酥脆，香甜美味', '2021-06-18 15:20:51', '2021-06-18 15:20:51', '0');
INSERT INTO `product` VALUES ('2', '旺旺华夫饼', '24', '2', '202', '1', '口感细腻，轻松解馋', '2021-06-18 15:20:51', '2021-06-18 15:20:51', '0');
INSERT INTO `product` VALUES ('3', '咪咪虾条', '26', '2', '199', '1', '无论是闻起来还是吃起来,虾味儿都不算很浓,口感微酥', '2021-06-18 15:20:51', '2021-06-18 15:20:51', '0');
INSERT INTO `product` VALUES ('4', '旺旺雪饼', '24', '2', '201', '1', '用一种用精选大米制成的膨化食品。松脆香甜、口味多样', '2021-06-18 15:20:51', '2021-06-18 15:20:51', '0');
INSERT INTO `product` VALUES ('5', '港荣蒸蛋糕', '21', '1', '122', '1', '口感湿润,松软香甜,不油腻,不上火,特别适合老人孩子吃', '2021-06-18 15:20:51', '2021-06-18 15:20:51', '0');
INSERT INTO `product` VALUES ('6', '虾饺', '23', '1', '123', '1', '上乘的虾饺,皮白如雪,薄如纸,半透明,吃起来爽滑清鲜,美味可口', '2021-06-18 15:20:51', '2021-06-18 15:20:51', '0');
INSERT INTO `product` VALUES ('7', '乐事薯片', '25', '2', '124', '1', '乐事薯片分了薄切,桶装,小波浪, 大波浪 ,口味略有所不同', '2021-06-18 15:20:51', '2021-06-18 15:20:51', '0');
INSERT INTO `product` VALUES ('8', 'GUCCI风衣', '27', '3', '125', '1', '感性优雅、始终坚持的现代风将这个品牌重新定义为至为精美的意大利时装', '2021-06-18 15:20:51', '2021-06-18 15:20:51', '0');
INSERT INTO `product` VALUES ('9', '杰克琼斯牛仔裤', '28', '3', '126', '1', '样式新颖，质量优良', '2021-06-18 15:20:51', '2021-06-18 15:20:51', '0');
INSERT INTO `product` VALUES ('10', 'LV高跟鞋', '29', '4', '127', '1', '简约设计遇上真皮材质', '2021-06-18 15:20:51', '2021-06-18 15:20:51', '0');
INSERT INTO `product` VALUES ('11', '华为mate40手机', '30', '5', '128', '1', '拍照和游戏兼顾的潮机', '2021-06-18 15:20:51', '2021-06-18 15:20:51', '0');
INSERT INTO `product` VALUES ('12', '华为mateBook', '31', '5', '122', '1', '薄屏触控商务办公', '2021-06-18 15:20:51', '2021-06-18 15:20:51', '0');
INSERT INTO `product` VALUES ('13', '华为matePad', '32', '5', '123', '1', '平板电脑二合一', '2021-06-18 15:20:51', '2021-06-18 15:20:51', '0');
INSERT INTO `product` VALUES ('14', '苏泊尔高压锅', '33', '6', '124', '1', '重量轻、传热快、价格低', '2021-06-18 15:20:51', '2021-06-18 15:20:51', '0');
INSERT INTO `product` VALUES ('15', '南极人棉袜', '34', '4', '125', '1', '质量好，透气，保暖', '2021-06-18 15:20:51', '2021-06-18 15:20:51', '0');
INSERT INTO `product` VALUES ('16', '超能洗衣粉', '35', '6', '126', '1', '超能女人用超能', '2021-06-18 15:20:51', '2021-06-18 15:20:51', '0');

-- ----------------------------
-- Table structure for product_comments
-- ----------------------------
DROP TABLE IF EXISTS `product_comments`;
CREATE TABLE `product_comments` (
  `comm_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `product_name` varchar(64) DEFAULT NULL COMMENT '商品名称',
  `order_item_id` bigint DEFAULT NULL COMMENT '订单项(商品快照)ID 可为空',
  `user_id` bigint DEFAULT NULL COMMENT '评论用户id 用户名须脱敏',
  `is_anonymous` int DEFAULT NULL COMMENT '是否匿名（1:是，0:否）',
  `comm_level` int NOT NULL COMMENT '评价等级 1：好评 2：中评 3：差评',
  `comm_content` varchar(128) NOT NULL COMMENT '评价内容',
  `comm_imgs` varchar(32) DEFAULT NULL COMMENT '评价晒图(JSON {img1:url1,img2:url2}  )',
  `sepc_name` datetime DEFAULT NULL COMMENT '评价时间 可为空',
  `reply_status` int DEFAULT '0' COMMENT '是否回复（0:未回复，1:已回复）',
  `reply_content` varchar(32) DEFAULT NULL COMMENT '回复内容',
  `reply_time` datetime DEFAULT NULL COMMENT '回复时间',
  `is_show` int DEFAULT '1' COMMENT '是否显示（1:是，0:否）',
  `gmt_modify` datetime DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `is_delete` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`comm_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='商品评价 ';

-- ----------------------------
-- Records of product_comments
-- ----------------------------
INSERT INTO `product_comments` VALUES ('1', '1', '奥利奥小饼干', '1', '1', '1', '1', '我买这不是来吃的，就是玩儿', '1.jpg', '2021-06-18 14:51:10', '0', null, '2021-04-27 14:51:32', '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('2', '1', '奥利奥小饼干', '2', '1', '0', '2', 'nice', '2.jpg', '2021-06-18 14:51:10', '1', '你好我也好', '2021-04-27 14:53:37', '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('3', '3', '咪咪虾条', '10000003', '1', '1', '1', '评价内容3', '{}', '2021-06-18 14:51:10', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('4', '3', '咪咪虾条', '10000004', '2', '1', '1', '评价内容3', '{}', '2021-06-18 14:51:10', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('5', '3', '咪咪虾条', '10000005', '2', '1', '1', '评价内容5', '{}', '2021-06-18 14:51:10', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('6', '3', '咪咪虾条', '10000006', '3', '1', '1', '评价内容6', '{}', '2021-06-18 14:51:10', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('7', '3', '咪咪虾条', '10000007', '4', '0', '1', '评价内容7', '{}', '2021-06-18 14:51:10', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('8', '8', 'GUCCI风衣', '4283164', '29', '1', '1', '213123123', 'GUCCI风衣1.jpg', '2021-06-19 10:07:29', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('9', '8', 'GUCCI风衣', '4283154', '32', '1', '2', '123321', 'GUCCI风衣1.jpg', '2021-06-19 11:45:40', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('10', '1', '奥利奥小饼干', '4283155', '32', '1', '3', '321123', '奥利奥小饼干1.jpg', '2021-06-19 11:45:46', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('11', '2', '旺旺华夫饼', '4283156', '32', '1', '3', '123321', '旺旺华夫饼1.jpg', '2021-06-19 11:45:51', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('12', '1', '奥利奥小饼干', '8', '32', '1', '2', '321', '奥利奥小饼干1.jpg', '2021-06-19 13:01:52', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('13', '2', '旺旺华夫饼', '4283165', '32', '1', '3', '123', '旺旺华夫饼1.jpg', '2021-06-19 13:01:59', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('14', '3', '咪咪虾条', '4283166', '32', '1', '2', '32123123', '咪咪虾条1.jpg', '2021-06-19 13:02:07', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('15', '10', 'LV高跟鞋', '4283170', '29', '1', '1', 'asd', 'LV高跟鞋1.jpg', '2021-06-19 15:47:26', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('16', '8', 'GUCCI风衣', '4283171', '29', '1', '3', '123123', 'GUCCI风衣1.jpg', '2021-06-19 15:47:33', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('17', '3', '咪咪虾条', '4283200', '31', '1', '1', 'giao', '咪咪虾条1.jpg', '2021-06-19 19:40:13', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('18', '10', 'LV高跟鞋', '4283201', '31', '1', '1', 'wuhu', 'LV高跟鞋1.jpg', '2021-06-19 19:40:21', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('19', '3', '咪咪虾条', '4283213', '29', '1', '2', '真不错', '咪咪虾条1.jpg', '2021-06-20 10:28:41', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('20', '1', '奥利奥小饼干', '4283215', '29', '1', '2', '好吃', '奥利奥小饼干1.jpg', '2021-09-03 19:33:55', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('21', '8', 'GUCCI风衣', '4283216', '29', '1', '1', '真不错\n', 'GUCCI风衣1.jpg', '2021-09-03 19:34:10', '0', null, null, '1', null, null, '0');
INSERT INTO `product_comments` VALUES ('22', '2', '旺旺华夫饼', '4283217', '29', '1', '3', '不好吃', '旺旺华夫饼1.jpg', '2021-09-03 19:34:20', '0', null, null, '1', null, null, '0');

-- ----------------------------
-- Table structure for product_img
-- ----------------------------
DROP TABLE IF EXISTS `product_img`;
CREATE TABLE `product_img` (
  `id` bigint NOT NULL COMMENT '图片主键',
  `product_id` bigint NOT NULL COMMENT '商品外键id 商品外键id',
  `url` varchar(128) NOT NULL COMMENT '图片地址 图片地址',
  `sort` int NOT NULL COMMENT '顺序 图片顺序，从小到大',
  `is_main` int NOT NULL COMMENT '是否主图 是否主图，1：是，0：否',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='商品图片 ';

-- ----------------------------
-- Records of product_img
-- ----------------------------
INSERT INTO `product_img` VALUES ('1', '1', '奥利奥小饼干1.jpg', '1', '1', '2021-06-18 14:51:10', '2021-06-18 15:25:15');
INSERT INTO `product_img` VALUES ('2', '1', '奥利奥小饼干2.jpg', '2', '0', '2021-06-18 14:51:10', '2021-06-18 15:25:44');
INSERT INTO `product_img` VALUES ('3', '1', '奥利奥小饼干3.jpg', '3', '0', '2021-06-18 14:51:10', '2021-06-18 15:30:19');
INSERT INTO `product_img` VALUES ('4', '2', '旺旺华夫饼1.jpg', '1', '1', '2021-06-18 14:51:10', '2021-06-18 15:30:48');
INSERT INTO `product_img` VALUES ('5', '2', '旺旺华夫饼2.jpg', '2', '0', '2021-06-18 14:51:10', '2021-06-18 15:59:31');
INSERT INTO `product_img` VALUES ('6', '2', '旺旺华夫饼3.jpg', '3', '0', '2021-06-18 14:51:10', '2021-06-18 15:59:54');
INSERT INTO `product_img` VALUES ('7', '3', '咪咪虾条1.jpg', '1', '1', '2021-06-18 14:51:10', '2021-06-18 16:00:17');
INSERT INTO `product_img` VALUES ('8', '3', '咪咪虾条2.jpg', '2', '0', '2021-06-18 14:51:10', '2021-06-18 16:00:39');
INSERT INTO `product_img` VALUES ('9', '4', '旺旺雪饼1.jpg', '1', '1', '2021-06-18 14:51:10', '2021-06-18 11:11:11');
INSERT INTO `product_img` VALUES ('10', '4', '旺旺雪饼2.jpg', '2', '0', '2021-06-18 14:51:10', '2021-06-18 11:11:11');
INSERT INTO `product_img` VALUES ('11', '4', '旺旺雪饼3.jpg', '3', '0', '2021-06-18 14:51:10', '2021-06-18 11:11:11');
INSERT INTO `product_img` VALUES ('12', '5', '港荣蒸蛋糕1.jpg', '1', '1', '2021-06-18 14:51:10', '2021-06-18 11:11:11');
INSERT INTO `product_img` VALUES ('13', '5', '港荣蒸蛋糕2.jpg', '2', '0', '2021-06-18 14:51:10', '2021-06-18 11:11:11');
INSERT INTO `product_img` VALUES ('14', '5', '港荣蒸蛋糕3.jpg', '3', '0', '2021-06-18 14:51:10', '2021-06-18 11:11:11');
INSERT INTO `product_img` VALUES ('15', '6', '水晶虾饺1.jpg', '1', '1', '2021-06-18 14:51:10', '2021-06-18 11:11:11');
INSERT INTO `product_img` VALUES ('16', '6', '水晶虾饺2.jpg', '2', '0', '2021-06-18 14:51:10', '2021-06-18 14:51:10');
INSERT INTO `product_img` VALUES ('17', '6', '水晶虾饺3.jpg', '3', '0', '2021-06-18 14:51:10', '2021-06-18 14:51:10');
INSERT INTO `product_img` VALUES ('18', '7', '乐事薯片1.jpg', '1', '1', '2021-06-18 14:51:10', '2021-06-18 14:51:10');
INSERT INTO `product_img` VALUES ('19', '7', '乐事薯片2.jpg', '2', '0', '2021-06-18 14:51:10', '2021-06-18 14:51:10');
INSERT INTO `product_img` VALUES ('20', '7', '乐事薯片3.jpg', '3', '0', '2021-06-18 11:11:11', '2021-06-18 14:51:10');
INSERT INTO `product_img` VALUES ('21', '8', 'GUCCI风衣1.jpg', '1', '1', '2021-06-18 11:11:11', '2021-06-18 14:51:10');
INSERT INTO `product_img` VALUES ('22', '8', 'GUCCI风衣2.jpg', '2', '0', '2021-06-18 11:11:11', '2021-06-18 14:51:10');
INSERT INTO `product_img` VALUES ('23', '8', 'GUCCI风衣3.jpg', '3', '0', '2021-06-16 14:42:42', '2021-06-18 14:51:10');
INSERT INTO `product_img` VALUES ('24', '9', '杰克琼斯牛仔裤1.jpg', '1', '1', '2021-06-16 15:02:16', '2021-06-18 14:51:10');
INSERT INTO `product_img` VALUES ('25', '9', '杰克琼斯牛仔裤2.jpg', '2', '0', '2021-06-16 15:03:28', '2021-06-18 14:51:10');
INSERT INTO `product_img` VALUES ('26', '9', '杰克琼斯牛仔裤3.jpg', '3', '0', '2021-06-16 15:03:50', '2021-06-18 14:51:10');
INSERT INTO `product_img` VALUES ('27', '10', 'LV高跟鞋1.jpg', '1', '1', '2021-06-16 15:10:30', '2021-06-18 14:51:10');
INSERT INTO `product_img` VALUES ('28', '10', 'LV高跟鞋2.jpg', '2', '0', '2021-06-16 15:10:59', '2021-06-18 14:51:10');
INSERT INTO `product_img` VALUES ('29', '11', '华为mate40手机1.jpg', '1', '1', '2021-06-16 15:19:04', '2021-06-18 14:51:10');
INSERT INTO `product_img` VALUES ('30', '11', '华为mate40手机2.jpg', '2', '0', '2021-06-16 15:24:31', '2021-06-16 15:24:33');
INSERT INTO `product_img` VALUES ('31', '11', '华为mate40手机3.jpg', '3', '0', '2021-06-16 15:26:28', '2021-06-16 15:26:31');
INSERT INTO `product_img` VALUES ('32', '12', '华为mateBook1.jpg', '1', '1', '2021-06-16 15:35:39', '2021-06-16 15:35:41');
INSERT INTO `product_img` VALUES ('33', '12', '华为mateBook2.jpg', '2', '0', '2021-06-16 15:38:14', '2021-06-16 15:38:16');
INSERT INTO `product_img` VALUES ('34', '12', '华为mateBook3.jpg', '3', '0', '2021-06-16 15:41:27', '2021-06-16 15:41:29');
INSERT INTO `product_img` VALUES ('35', '13', '华为matePad1.jpg', '1', '1', '2021-06-16 15:44:29', '2021-06-16 15:44:30');
INSERT INTO `product_img` VALUES ('36', '13', '华为matePad2.jpg', '2', '0', '2021-06-16 15:44:44', '2021-06-16 15:44:47');
INSERT INTO `product_img` VALUES ('37', '13', '华为matePad3.jpg', '3', '0', '2021-06-16 15:45:00', '2021-06-16 15:45:02');
INSERT INTO `product_img` VALUES ('38', '14', '苏泊尔高压锅1.jpg', '1', '1', '2021-06-16 15:49:07', '2021-06-16 15:49:09');
INSERT INTO `product_img` VALUES ('39', '14', '苏泊尔高压锅2.jpg', '2', '0', '2021-06-16 15:49:27', '2021-06-16 15:49:29');
INSERT INTO `product_img` VALUES ('40', '14', '苏泊尔高压锅3.jpg', '3', '0', '2021-06-16 15:49:47', '2021-06-16 15:49:50');
INSERT INTO `product_img` VALUES ('41', '15', '南极人棉袜1.jpg', '1', '1', '2021-06-16 15:54:25', '2021-06-16 15:54:26');
INSERT INTO `product_img` VALUES ('42', '15', '南极人棉袜2.jpg', '2', '0', '2021-06-16 15:54:44', '2021-06-16 15:54:46');
INSERT INTO `product_img` VALUES ('43', '15', '南极人棉袜3.jpg', '3', '0', '2021-06-16 15:55:03', '2021-06-16 15:55:04');
INSERT INTO `product_img` VALUES ('44', '16', '超能洗衣粉1.jpg', '1', '1', '2021-06-16 15:57:48', '2021-06-16 15:57:51');
INSERT INTO `product_img` VALUES ('45', '16', '超能洗衣粉2.jpg', '2', '0', '2021-06-16 15:58:07', '2021-06-16 15:58:10');
INSERT INTO `product_img` VALUES ('46', '16', '超能洗衣粉3.jpg', '3', '0', '2021-06-16 15:58:27', '2021-06-16 15:58:29');

-- ----------------------------
-- Table structure for product_params
-- ----------------------------
DROP TABLE IF EXISTS `product_params`;
CREATE TABLE `product_params` (
  `param_id` bigint NOT NULL COMMENT '商品参数id',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `weight` varchar(32) NOT NULL COMMENT '规格重量 规格重量，例：35g',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  `product_price` float(32,2) NOT NULL DEFAULT '10.00',
  `product_num` int NOT NULL DEFAULT '50',
  `sort` int NOT NULL COMMENT '产品型号递增1-2-3',
  PRIMARY KEY (`param_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='商品参数 ';

-- ----------------------------
-- Records of product_params
-- ----------------------------
INSERT INTO `product_params` VALUES ('1', '1', '原味', '2021-04-27 11:53:20', '2021-04-27 11:53:35', '10.00', '50', '1');
INSERT INTO `product_params` VALUES ('2', '1', '草莓味', '2021-06-10 15:06:13', '2021-06-10 15:06:17', '18.00', '50', '2');
INSERT INTO `product_params` VALUES ('3', '1', '抹茶味', '2021-06-15 15:40:24', '2021-06-15 15:40:28', '18.00', '50', '3');
INSERT INTO `product_params` VALUES ('4', '2', '50g', '2021-06-15 15:48:23', '2021-06-15 15:48:26', '20.00', '50', '1');
INSERT INTO `product_params` VALUES ('5', '2', '100g', '2021-06-15 15:48:40', '2021-06-15 15:48:43', '35.00', '50', '2');
INSERT INTO `product_params` VALUES ('6', '2', '150g', '2021-06-15 15:49:28', '2021-06-15 15:49:30', '45.00', '50', '3');
INSERT INTO `product_params` VALUES ('7', '3', '条状', '2021-06-15 15:59:10', '2021-06-15 15:59:13', '25.00', '50', '1');
INSERT INTO `product_params` VALUES ('8', '3', '片状', '2021-06-15 15:59:29', '2021-06-15 15:59:31', '25.00', '50', '2');
INSERT INTO `product_params` VALUES ('9', '4', '小包', '2021-06-15 16:07:58', '2021-06-15 16:08:01', '10.00', '50', '1');
INSERT INTO `product_params` VALUES ('10', '4', '大礼包（含5包）', '2021-06-15 16:09:05', '2021-06-15 16:09:09', '40.00', '50', '2');
INSERT INTO `product_params` VALUES ('11', '5', '小包', '2021-06-16 10:32:22', '2021-06-16 10:32:25', '50.00', '50', '1');
INSERT INTO `product_params` VALUES ('12', '5', '大包', '2021-06-16 10:32:47', '2021-06-16 10:32:50', '80.00', '50', '2');
INSERT INTO `product_params` VALUES ('14', '7', '原味', '2021-06-16 14:45:13', '2021-06-16 14:45:15', '6.00', '50', '1');
INSERT INTO `product_params` VALUES ('15', '7', '黄瓜味', '2021-06-16 14:45:37', '2021-06-16 14:45:40', '6.00', '50', '2');
INSERT INTO `product_params` VALUES ('16', '7', '番茄味', '2021-06-16 14:45:57', '2021-06-16 14:45:59', '6.00', '50', '3');
INSERT INTO `product_params` VALUES ('17', '7', '麻辣火锅味', '2021-06-16 14:46:22', '2021-06-16 14:46:25', '6.00', '50', '4');
INSERT INTO `product_params` VALUES ('18', '6', '白菜虾仁馅', '2021-06-16 14:58:59', '2021-06-16 14:59:04', '15.00', '50', '1');
INSERT INTO `product_params` VALUES ('19', '6', '青菜虾仁馅', '2021-06-16 14:59:44', '2021-06-16 14:59:46', '15.00', '50', '2');
INSERT INTO `product_params` VALUES ('20', '6', '玉米虾仁馅', '2021-06-16 15:00:15', '2021-06-16 15:00:17', '15.00', '50', '3');
INSERT INTO `product_params` VALUES ('21', '8', 's码', '2021-06-16 15:00:44', '2021-06-16 15:00:46', '1800.00', '50', '1');
INSERT INTO `product_params` VALUES ('22', '8', 'm码', '2021-06-16 15:01:01', '2021-06-16 15:01:04', '1800.00', '50', '2');
INSERT INTO `product_params` VALUES ('23', '8', 'l码', '2021-06-16 15:01:18', '2021-06-16 15:01:21', '1800.00', '50', '3');
INSERT INTO `product_params` VALUES ('24', '8', 'xl码', '2021-06-16 15:01:39', '2021-06-16 15:01:41', '1800.00', '50', '4');
INSERT INTO `product_params` VALUES ('25', '9', 's码', '2021-06-16 15:06:13', '2021-06-16 15:06:15', '400.00', '50', '1');
INSERT INTO `product_params` VALUES ('26', '9', 'm码', '2021-06-16 15:06:36', '2021-06-16 15:06:38', '400.00', '50', '2');
INSERT INTO `product_params` VALUES ('27', '9', 'l码', '2021-06-16 15:07:10', '2021-06-16 15:07:13', '400.00', '50', '3');
INSERT INTO `product_params` VALUES ('28', '9', 'xl码', '2021-06-16 15:07:34', '2021-06-16 15:07:36', '400.00', '50', '4');
INSERT INTO `product_params` VALUES ('29', '10', '34码', '2021-06-16 15:12:05', '2021-06-16 15:12:07', '600.00', '50', '1');
INSERT INTO `product_params` VALUES ('30', '10', '35码', '2021-06-16 15:12:24', '2021-06-16 15:12:26', '600.00', '50', '2');
INSERT INTO `product_params` VALUES ('31', '10', '36码', '2021-06-16 15:12:42', '2021-06-16 15:12:44', '600.00', '50', '3');
INSERT INTO `product_params` VALUES ('32', '10', '37码', '2021-06-16 15:13:06', '2021-06-16 15:13:07', '600.00', '50', '4');
INSERT INTO `product_params` VALUES ('33', '11', '16G', '2021-06-16 15:33:29', '2021-06-16 15:33:31', '4888.00', '50', '1');
INSERT INTO `product_params` VALUES ('34', '11', '64G', '2021-06-16 15:33:48', '2021-06-16 15:33:50', '5888.00', '50', '2');
INSERT INTO `product_params` VALUES ('35', '11', '258G', '2021-06-16 15:34:31', '2021-06-16 15:34:33', '6888.00', '50', '3');
INSERT INTO `product_params` VALUES ('36', '12', '16G', '2021-06-16 15:45:59', '2021-06-16 15:46:00', '5888.00', '50', '1');
INSERT INTO `product_params` VALUES ('37', '12', '64G', '2021-06-16 15:46:24', '2021-06-16 15:46:25', '6888.00', '50', '2');
INSERT INTO `product_params` VALUES ('38', '12', '256G', '2021-06-16 15:46:45', '2021-06-16 15:46:47', '7888.00', '50', '3');
INSERT INTO `product_params` VALUES ('39', '13', '16G', '2021-06-16 15:47:17', '2021-06-16 15:47:19', '4888.00', '50', '1');
INSERT INTO `product_params` VALUES ('40', '13', '64G', '2021-06-16 15:47:38', '2021-06-16 15:47:40', '5888.00', '50', '2');
INSERT INTO `product_params` VALUES ('41', '13', '256G', '2021-06-16 15:48:01', '2021-06-16 15:48:03', '6888.00', '50', '3');
INSERT INTO `product_params` VALUES ('42', '14', '4.5L', '2021-06-16 15:52:48', '2021-06-16 15:52:50', '175.00', '50', '1');
INSERT INTO `product_params` VALUES ('43', '14', '6L', '2021-06-16 15:53:13', '2021-06-16 15:53:15', '190.00', '50', '2');
INSERT INTO `product_params` VALUES ('44', '14', '7.5L', '2021-06-16 15:53:32', '2021-06-16 15:53:33', '200.00', '50', '3');
INSERT INTO `product_params` VALUES ('45', '15', '5双纯黑', '2021-06-16 15:56:22', '2021-06-16 15:56:24', '10.00', '50', '1');
INSERT INTO `product_params` VALUES ('46', '15', '5双不同颜色', '2021-06-16 15:56:42', '2021-06-16 15:56:44', '10.00', '50', '2');
INSERT INTO `product_params` VALUES ('47', '15', '5双纯白', '2021-06-16 15:57:00', '2021-06-16 15:57:03', '10.00', '50', '3');
INSERT INTO `product_params` VALUES ('48', '16', '百合味', '2021-06-16 16:00:32', '2021-06-16 16:00:35', '20.00', '50', '1');
INSERT INTO `product_params` VALUES ('49', '16', '薰衣草味', '2021-06-16 16:00:51', '2021-06-16 16:00:53', '20.00', '50', '2');
INSERT INTO `product_params` VALUES ('50', '16', '橘子味', '2021-06-16 16:01:13', '2021-06-16 16:01:15', '20.00', '50', '3');

-- ----------------------------
-- Table structure for product_sku
-- ----------------------------
DROP TABLE IF EXISTS `product_sku`;
CREATE TABLE `product_sku` (
  `sku_id` bigint NOT NULL COMMENT 'sku编号',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `sku_name` varchar(32) NOT NULL COMMENT 'sku名称',
  `sku_img` varchar(32) DEFAULT NULL COMMENT 'sku图片',
  `original_price` int NOT NULL COMMENT '原价',
  `sell_price` int NOT NULL COMMENT '销售价格',
  `discounts` decimal(4,2) NOT NULL COMMENT '折扣力度',
  `stock` int NOT NULL COMMENT '库存',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime NOT NULL COMMENT '更新时间',
  `status` int DEFAULT NULL COMMENT 'sku状态(1启用，0禁用，-1删除)',
  PRIMARY KEY (`sku_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='商品规格 每一件商品都有不同的规格，不同的规格又有不同的价格和优惠力度，规格表为此设计';

-- ----------------------------
-- Records of product_sku
-- ----------------------------
INSERT INTO `product_sku` VALUES ('1', '3', '咪咪虾条 单包 50g', 'mmxt_1.png', '2', '1', '0.70', '333', '2021-06-01 15:58:00', '2021-06-18 15:58:00', '1');
INSERT INTO `product_sku` VALUES ('2', '3', '咪咪虾条 6连包', 'mmxt_1.png', '6', '5', '0.60', '199', '2021-06-01 14:48:21', '2021-06-18 14:48:25', '1');
INSERT INTO `product_sku` VALUES ('3', '3', '咪咪虾条 整箱50包', 'mmxt_1.png', '50', '40', '0.50', '50', '2021-06-01 14:49:20', '2021-06-18 14:49:23', '1');
INSERT INTO `product_sku` VALUES ('4', '1', '奥利奥分享装', 'ala_1.png', '10', '8', '0.80', '167', '2021-06-01 11:38:55', '2021-06-18 11:39:00', '1');

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `cart_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `params_id` bigint NOT NULL COMMENT '商品ID',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `cart_num` varchar(32) NOT NULL COMMENT '购物车商品数量',
  `cart_time` varchar(32) NOT NULL COMMENT '添加购物车时间',
  `product_price` decimal(32,8) DEFAULT NULL COMMENT '添加购物车时商品价格',
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`cart_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='购物车 ';

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------
INSERT INTO `shopping_cart` VALUES ('64', '7', '31', '1', '2021-06-19 19:42:24', '25.00000000', '3');

-- ----------------------------
-- Table structure for user_addr
-- ----------------------------
DROP TABLE IF EXISTS `user_addr`;
CREATE TABLE `user_addr` (
  `addr_id` bigint NOT NULL AUTO_INCREMENT COMMENT '地址主键id',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `receiver_name` varchar(32) NOT NULL COMMENT '收件人姓名',
  `receiver_mobile` varchar(32) NOT NULL COMMENT '收件人手机号',
  `province` varchar(32) NOT NULL COMMENT '省份',
  `city` varchar(32) NOT NULL COMMENT '城市',
  `area` varchar(32) NOT NULL COMMENT '区县',
  `addr` varchar(128) NOT NULL COMMENT '详细地址',
  `post_code` varchar(32) DEFAULT NULL COMMENT '邮编',
  `status` int DEFAULT NULL COMMENT '状态,1正常，0无效',
  `common_addr` int DEFAULT NULL COMMENT '是否默认地址 1是 1:是  0:否',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`addr_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=523 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='用户地址 ';

-- ----------------------------
-- Records of user_addr
-- ----------------------------
INSERT INTO `user_addr` VALUES ('44', '1', '谭轶雯', '12345612345', '四川', '成都', '郫都', '上乘数据大厦', '122222', null, '0', '2021-06-11 10:01:58', null);
INSERT INTO `user_addr` VALUES ('50', '30', 'Prince.Dias', '13230859192', '河北', '唐山', '路北区', '唐山大学', 'princeyuansql@gmail.com', null, '0', '2021-06-17 09:55:44', null);
INSERT INTO `user_addr` VALUES ('51', '1', '坏男', '19827607173', '四川', '成都', '双流', '四川大学江安校区', '610027', null, '0', '2021-06-17 11:12:50', null);
INSERT INTO `user_addr` VALUES ('52', '29', '朱千奥我爱你', '18727670856', '四川', '成都', '双流', '四川大学江安校区', '610027', null, '1', '2021-06-18 16:51:07', null);
INSERT INTO `user_addr` VALUES ('53', '24', '黄武', '13246541234', '四川', '成都', '武侯', '四川大学望江校区', '610027', null, '0', '2021-06-19 11:03:07', null);
INSERT INTO `user_addr` VALUES ('54', '24', '黄武', '13212341234', '四川', '成都', '武侯', '四川大学望江校区', '610027', null, '0', '2021-06-19 11:04:04', null);
INSERT INTO `user_addr` VALUES ('56', '24', '黄六', '123', '四川', '成都', '双流', '川大', '123', null, '0', '2021-06-19 11:09:44', null);
INSERT INTO `user_addr` VALUES ('61', '32', '黄武我爱你', '13245677654', '四川', '成都', '武侯', '四川大学望江校区', '610027', null, '0', '2021-06-19 11:36:53', null);
INSERT INTO `user_addr` VALUES ('520', '1', '朱千奥', '18727670856', '四川', '成都', '青羊', '上乘', '111111', null, '0', '2021-06-11 09:58:17', null);
INSERT INTO `user_addr` VALUES ('521', '31', '黄武', '13212345678', '四川', '成都', '武侯', '四川大学望江校区', '610024', null, '0', '2021-06-19 19:29:54', null);
INSERT INTO `user_addr` VALUES ('522', '29', '王子渊', '18727670856', '四川', '成都', '青羊', '上程', '610027', null, '0', '2021-06-20 10:18:31', null);

-- ----------------------------
-- Table structure for user_login_history
-- ----------------------------
DROP TABLE IF EXISTS `user_login_history`;
CREATE TABLE `user_login_history` (
  `ID` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `AREA` varchar(32) DEFAULT NULL COMMENT '地区',
  `COUNTRY` varchar(32) DEFAULT NULL COMMENT '国家',
  `USER_ID` bigint DEFAULT NULL COMMENT '用户id',
  `IP` varchar(32) NOT NULL COMMENT 'IP',
  `LOGIN_TIME` varchar(32) NOT NULL COMMENT '时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='登录历史表 ';

-- ----------------------------
-- Records of user_login_history
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id 用户id',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名 用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码 密码',
  `user_img` varchar(1024) DEFAULT NULL COMMENT '头像 头像',
  `user_mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `user_email` varchar(32) DEFAULT NULL,
  `user_sex` char(1) DEFAULT NULL,
  `user_birth` date DEFAULT NULL COMMENT '生日 生日',
  `gmt_create` datetime DEFAULT NULL COMMENT '注册时间 创建时间',
  `gmt_modify` datetime DEFAULT NULL COMMENT '更新时间 更新时间',
  `is_delete` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT COMMENT='用户 ';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '陶宇龙', '111111', null, '13503932324', '1648142046@qq.com', 'M', null, null, null, '0');
INSERT INTO `users` VALUES ('24', 'yym', '111111', null, '13281085709', '1648142046@qq.com', 'M', null, null, null, '0');
INSERT INTO `users` VALUES ('26', '杨一鸣', '111111', null, '13503936614', '1648142046@qq.com', 'M', null, null, null, '0');
INSERT INTO `users` VALUES ('27', 'tyl', '111111', null, '15699025335', '1505971227@qq.com', 'M', null, null, null, '0');
INSERT INTO `users` VALUES ('29', '朱千奥', '123456', null, '18727670856', '3355147798@qq.com', 'M', null, null, null, '0');
INSERT INTO `users` VALUES ('30', '普林斯渊最聪明', 'wzy851234', null, '13230859192', '13230859192@163.com', 'M', null, null, null, '0');
INSERT INTO `users` VALUES ('31', '黄武', '123456', null, '13256565421', '3355147798@qq.com', null, null, null, null, '0');
INSERT INTO `users` VALUES ('32', '黄八', '123456', null, '13212345678', '3355147798@qq.com', null, null, null, null, '0');
