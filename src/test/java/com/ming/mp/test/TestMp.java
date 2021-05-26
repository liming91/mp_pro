//package com.ming.mp.test;
//
//import com.baomidou.mybatisplus.mapper.Condition;
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import com.baomidou.mybatisplus.plugins.Page;
//import com.ming.mp.mapper.EmployeeMapper;
//import com.ming.mp.beans.Employee;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.*;
//
//public class TestMp {
//    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//    private EmployeeMapper employeeMapper = context.getBean("employeeMapper",EmployeeMapper.class);
//
//    @Test
//    public void testDataSource() throws SQLException {
//        DataSource dataSource = (DataSource) context.getBean("dataSource");
//        System.out.println();
//        System.out.println("===========================dataSource:"+dataSource.getClass());
//        Connection connection = dataSource.getConnection();
//        System.out.println("connection==:"+connection);
//        connection.close();
//    }
//
//
//
//
//    @Test
//    public void  insertEmp(){
//        Employee employee = new Employee();
//        employee.setLastName("员工c");
//        employee.setEmail("87997798@qq.com");
//        employee.setGender(1);
//       // Integer count = employeeMapper.insert(employee);
//        employeeMapper.insertAllColumn(employee);
//
//        //获取主键
//        Integer id = employee.getId();
//    }
//
//    @Test
//    public void  updateByIdEmp(){
//        Employee employee = new Employee();
//        employee.setId(6);
//        employee.setLastName("MP");
//        employee.setEmail("87997798@qq.com");
//        employee.setAge(18);
//        employee.setGender(1);
//        //Integer count = employeeMapper.updateById(employee);
//        employeeMapper.updateAllColumnById(employee);
//    }
//
//    /**
//     * 通用查询
//     */
//    @Test
//    public void  commonSelect() {
//        //1、selectById通过id查询(id 为主键)
//        //Preparing: SELECT id AS id,last_name AS lastName,email,gender,age FROM tbl_employee WHERE id=?
////        Employee employee = employeeMapper.selectById(6);
////        System.out.println(employee);
//
//        //2、selectOne通过多个列查询（id+name）参数T
////        Employee employee = new Employee();
////        employee.setId(6);
////        employee.setLastName("MP");
////        //Preparing: SELECT id AS id,last_name AS lastName,email,gender,age FROM tbl_employee WHERE id=? AND last_name=?
////        Employee selectOne = employeeMapper.selectOne(employee);
//
//        //3、selectBatchIds:通过多个id查询
//        //SQL:SELECT id AS id,last_name AS lastName,email,gender,age FROM tbl_employee WHERE id IN ( ? , ? )
////        List<Employee> list = employeeMapper.selectBatchIds(Arrays.asList(1, 2));
////        System.out.println(list);
//
//        //4、selectByMap
////        LinkedHashMap<String,Object> map = new LinkedHashMap<>();
////        map.put("id","7");
////        map.put("last_name","MP");
////        List<Employee> selectByMap = employeeMapper.selectByMap(map);
////        System.out.println(selectByMap);
//        //5、分页查询 假分页内存分页 实现物理逻辑分页 要借助插件PageHelper
//        List<Employee> list = employeeMapper.selectPage(new Page<Employee>(2,2), null);
//        System.out.println(list);
//
//    }
//
//    @Test
//    public void testCommonDelete(){
//        //1.根据主键id删除DELETE FROM tbl_employee WHERE id=?
//        Integer id = employeeMapper.deleteById(1);
//        System.out.println(id);
//        //2.deleteByMap: 根据 columnMap 条件、删除记录
////        Map<String,Object> columnMap = new HashMap<>();
////        columnMap.put("gender",0);
////        Integer deleteByMap = employeeMapper.deleteByMap(columnMap);
////        System.out.println(deleteByMap);
//        //3.删除（根据ID 批量删除）Preparing: DELETE FROM tbl_employee WHERE id IN ( ? , ? , ? , ? )
////        Integer integer = employeeMapper.deleteBatchIds(Arrays.asList(3, 5, 7, 8));
////        System.out.println(integer);
//
//    }
//
//    /**
//     * 条件构造器查询
//     */
//    @Test
//    public void testEntityWrapper(){
//        //我们要分页查询Employee表中、年龄在19-50之间、性别为男性且姓名为Tom的用户
//        // Preparing: SELECT id AS id,last_name AS lastName,email,gender,age FROM tbl_employee WHERE (age BETWEEN ? AND ? AND gender = ? AND last_name = ?)
////        List<Employee> employeeList= employeeMapper.selectPage(new Page<Employee>(1, 2),
////                        new EntityWrapper<Employee>()
////                        .between("age", 18, 50)
////                        .eq("gender",1)
////                        .eq("last_name", "Tom"));
////        System.out.println(employeeList);
//
//        //查询性别女 并且名字带有老师或者邮箱中带有a
//        List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>()
//                .eq("gender", 0)
//                .like("last_name", "老师")
//                //.or()// SELECT id AS id,last_name AS lastName,email,gender,age FROM tbl_employee WHERE (gender = ? AND last_name LIKE ? OR email LIKE ?)
//                .orNew()//Preparing: SELECT id AS id,last_name AS lastName,email,gender,age FROM tbl_employee WHERE (gender = ? AND last_name LIKE ?) OR (email LIKE ?)
//                .like("email", "a")
//                .orderAsc(Arrays.asList(new String[]{"age"}))
//        );
//        System.out.println(employees);
//
//    }
//
//    @Test
//    public void entityWrapperUpdate(){
//        //修改名字为Tom年龄为44岁
//        Employee employee = new Employee();
//        employee.setLastName("TomA");
//        employee.setEmail("ffff5@qq.com");
//        Integer update = employeeMapper.update(employee, new EntityWrapper<Employee>()
//                .eq("last_name", "Tom")
//                .eq("age", 44)
//        );
//        // Preparing: UPDATE tbl_employee SET last_name=?, eil=? maWHERE (last_name = ? AND gender = ?)
//        System.out.println(update);
//    }
//
//    @Test
//    public void entityWrapperDelete(){
//        // Preparing: DELETE FROM tbl_employee WHERE (id = ?)
//        Integer id = employeeMapper.delete(new EntityWrapper<Employee>()
//                .eq("id", 14));
//    }
//
//    @Test
//    public void testCondition(){
//        //查询性别女 并且名字带有老师或者邮箱中带有a
//        // SELECT id AS id,last_name AS lastName,email,gender,age FROM tbl_employee WHERE (gender = ? AND last_name LIKE ? OR email LIKE ?)
//        List<Employee> list = employeeMapper.selectPage(new Page<Employee>(1, 2), Condition.create()
//                .eq("gender", "女")
//                .like("last_name", "老师")
//                .or()
//                .like("email", "a")
//        );
//        System.out.println(list);
//    }
//
//
////    private ShopConfigViewDTO getConfigByGroupAndKey(String group, String key) {
////        LambdaQueryChainWrapper<ShopConfigEntity> lambdaQuery = lambdaQuery()
////                .eq(ShopConfigEntity::getIsDel, 0)
////                .eq(ShopConfigEntity::getGroup, group)
////                .eq(ShopConfigEntity::getDomainId, CurrentUserUtils.getDomainId())
////                .eq(ShopConfigEntity::getKey, key);
////        if (CurrentUserUtils.isDomain()) {
////            lambdaQuery.and(query -> query.isNull(ShopConfigEntity::getShopId)
////                    .or().eq(ShopConfigEntity::getShopId, 0)
////            );
////        } else {
////            lambdaQuery.and(query -> query.isNull(ShopConfigEntity::getShopId)
////                    .or().eq(ShopConfigEntity::getShopId, 0)
////                    .or().eq(ShopConfigEntity::getShopId, CurrentUserUtils.getShopId())
////            );
////        }
////        List<ShopConfigEntity> shopConfigList = lambdaQuery.list();
////
////        ShopConfigViewDTO viewDTO = ConvertUtils.convert(lambdaQuery.last("limit 1").one(), ShopConfigViewDTO.class);
////        if (Objects.nonNull(viewDTO)) {
////            return viewDTO;
////        }
////
////        Optional<ShopDefaultConfig.ConfigItem> defaultConfig =
////                shopDefaultConfig.getConfig().getOrDefault(group, Collections::emptyList)
////                        .stream().filter(item -> item.getKey().equals(key)).findFirst();
////        Assert.isTrue(defaultConfig.isPresent(), () -> "默认配置不存在");
////
////        return ConvertUtils.convert(defaultConfig.get(), ShopConfigViewDTO.class, (d, e) -> {
////            d.setDomainId(CurrentUserUtils.getDomainId())
////                    .setShopId(CurrentUserUtils.getShopId())
////                    .setGroup(group)
////            ;
////        });
////    }
//}
