package org.apache.shenyu.admin.mapper;

import org.apache.shenyu.admin.AbstractSpringIntegrationTest;
import org.apache.shenyu.admin.model.entity.DataPermissionDO;
import org.apache.shenyu.common.utils.UUIDUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Test cases for DataPermissionMapper.
 */

public class DataPermissionMapperTest extends AbstractSpringIntegrationTest {

    @Resource
    private DataPermissionMapper dataPermissionMapper;

    @Test
    public void insertBatch() {

        DataPermissionDO dataPermissionDO1 = buildDataPermissionDO();
        DataPermissionDO dataPermissionDO2 = buildDataPermissionDO();
        DataPermissionDO dataPermissionDO3 = buildDataPermissionDO();
        List<DataPermissionDO> dataList = Lists.list(dataPermissionDO1, dataPermissionDO2, dataPermissionDO3);
        int ret = dataPermissionMapper.insertBatch(dataList);
        assertEquals(dataList.size(), ret);

    }

    private DataPermissionDO buildDataPermissionDO() {

        String id = UUIDUtils.getInstance().generateShortUuid();
        String dataId = UUIDUtils.getInstance().generateShortUuid();
        String userId = UUIDUtils.getInstance().generateShortUuid();
        int dataType = 2;

        return DataPermissionDO.builder()
                .dataId(dataId)
                .userId(userId)
                .id(id)
                .dataType(dataType).build();
    }
}
