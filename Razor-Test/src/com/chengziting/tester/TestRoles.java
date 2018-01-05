package com.chengziting.tester;

import com.chengziting.razor.service.IRolesService;
import com.chengziting.razor.service.impl.RolesService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by user on 2018-01-05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context-test.xml")
public class TestRoles extends TestCase{
    @Autowired
    protected IRolesService rolesService;

    @Test
    public void testRoleService(){
        if(rolesService == null){
            rolesService = new RolesService();
        }
    }
}
