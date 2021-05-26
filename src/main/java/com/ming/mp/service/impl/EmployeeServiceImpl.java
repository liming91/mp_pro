package com.ming.mp.service.impl;

import com.ming.mp.beans.Employee;
import com.ming.mp.mapper.EmployeeMapper;
import com.ming.mp.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liming
 * @since 2021-05-25
 *
 * EmployeeServiceImpl 继承了serviceImpl
 * 在serviceImpl中已经完成了Mapper对象的注入，这样就可以直接在serviceImpl中进行使用了
 * 在serviceImpl中帮我们提供了常用的CRUD方法，基本的一些CRUD方法在service中不用定义了
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    //不用进行mapper注入
}
