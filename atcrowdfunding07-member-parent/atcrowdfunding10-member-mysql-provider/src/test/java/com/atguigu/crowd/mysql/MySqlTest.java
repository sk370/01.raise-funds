package com.atguigu.crowd.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.atguigu.crowd.entity.po.MemberPO;
import com.atguigu.crowd.entity.vo.PortalProjectVO;
import com.atguigu.crowd.entity.vo.PortalTypeVO;
import com.atguigu.crowd.mysql.mapper.MemberPOMapper;
import com.atguigu.crowd.mysql.mapper.ProjectPOMapper;

/**
 * @author zhuyuqi
 * @version v0.0.1
 * @className MySqlTest
 * @description https://developer.aliyun.com/profile/sagwrxp2ua66w
 * @date 2022/09/08 10:07
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MySqlTest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private MemberPOMapper memberPOMapper;
    @Autowired
    private ProjectPOMapper projectPOMapper;
    private Logger logger = LoggerFactory.getLogger(MySqlTest.class);

    @Test
    public void testLoadTypeData() {
        List<PortalTypeVO> portalProjectTypeList = projectPOMapper.selectPortalTypeVOList();
        for (PortalTypeVO portalTypeVO : portalProjectTypeList) {
            String name = portalTypeVO.getName();
            String remark = portalTypeVO.getRemark();
            logger.info("name= " + name + ",remark=" + remark);
            List<PortalProjectVO> portalProjectVOList = portalTypeVO.getPortalProjectVOList();
            for (PortalProjectVO portalProjectVO : portalProjectVOList) {
                if (portalProjectVO == null) {
                    continue;
                }
                logger.info(portalProjectVO.toString());
            }
        }
    }

    @Test
    public void testMapper() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String source = "123123";
        String encode = passwordEncoder.encode(source);
        MemberPO memberPO = new MemberPO(null, "jack", encode, "杰克", "jack@qq.com", 1, 1, "杰克", "123123", 2);
        memberPOMapper.insert(memberPO);
    }

    @Test
    public void testDataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
        logger.debug("========================" + connection.toString());
        System.out.println("========================" + connection);
    }

}
