//package com.ming.mp.test;
//
//import com.baomidou.mybatisplus.mapper.EntityWrapper;
//import com.baomidou.mybatisplus.plugins.Page;
//import com.ming.mp.model.Employee;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.List;
//
//public class TestAR {
//
//    private ApplicationContext ioc =
//            new ClassPathXmlApplicationContext("applicationContext.xml");
//
//    @Test
//    public void testInsert(){
//        Employee employee = new Employee();
//        employee.setLastName("AR1");
//        employee.setEmail("87997798@qq.com");
//        employee.setAge(18);
//        employee.setGender(1);
//        boolean insert = employee.insert();
//        System.out.println(insert);
//    }
//
//    /**
//     * AR 修改操作
//     */
//    @Test
//    public void testARUpdate() {
//        Employee employee = new Employee();
//        employee.setId(17);
//        employee.setLastName("宋老湿");
//        employee.setEmail("sls@atguigu.com");
//        employee.setGender(1);
//        employee.setAge(36);
//        boolean result = employee.updateById();
//        System.out.println("result:" +result );
//
//    }
//
//
//    /**
//     * AR 查询操作
//     */
//    @Test
//    public void testARSelect() {
//        Employee employee = new Employee();
//
////        Employee result = employee.selectById(11);
////        System.out.println(result);
//
//        employee.setId(11);
//		Employee result = employee.selectById();
//
//        System.out.println(result);
//
////
////		List<Employee> emps = employee.selectAll();
////		System.out.println(emps);
//
////		List<Employee > emps=
////				employee.selectList(new EntityWrapper<Employee>().like("last_name", "老师"));
////		System.out.println(emps);
//
////        Integer result = employee.selectCount(new EntityWrapper<Employee>().eq("gender", 0));
////        // SELECT COUNT(1) FROM tbl_employee WHERE (gender = ?)
////        System.out.println("result: " +result );
//
//
//
//    }
//
//
//    /**
//     * AR  分页复杂操作
//     */
//    @Test
//    public void  testARPage() {
//
//        Employee employee = new Employee();
//
//        Page<Employee> page = employee.selectPage(new Page<>(1, 1),
//                new EntityWrapper<Employee>().like("last_name", "老"));
//        List<Employee> emps = page.getRecords();
//        System.out.println(emps);
//    }
//
//
//    /**
//     * AR 删除操作
//     *
//     * 注意: 删除不存在的数据 逻辑上也是属于成功的.
//     */
//    @Test
//    public void testARDelete() {
//
//        Employee employee = new Employee();
//        boolean result = employee.deleteById(2);
//		employee.setId(2);
//		boolean result1 = employee.deleteById();
//		System.out.println("result:" +result );
//
//
//        boolean result2 = employee.delete(new EntityWrapper<Employee>().like("last_name", "小"));
//        System.out.println(result2 );
//    }
//
//}
