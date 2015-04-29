package org.heng.xml.impl.db;

import com.google.common.collect.Lists;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * @author wangdi
 */
public class DataSourceCluster {

    @Attribute
    private String name;

    @ElementList(inline = true, entry = "dataSourceInstance")
    private List<DataSourceInstance> dataSourceInstances;

    public List<DataSourceInstance> getReadDataSourceInstance() {
        List<DataSourceInstance> reads = Lists.newArrayList();
        for (DataSourceInstance instance : dataSourceInstances) {
            if (instance.isRead()) {
                reads.add(instance);
            }
        }
        if (reads.isEmpty()) {
            throw new IllegalStateException();
        }
        return reads;
    }

    public DataSourceInstance getWriteDataSourceInstance() {
        List<DataSourceInstance> writes = Lists.newArrayList();
        for (DataSourceInstance instance : dataSourceInstances) {
            if (instance.isWrite()) {
                writes.add(instance);
            }
        }
        if (writes.size() != 1) {
            throw new IllegalStateException();
        }
        return writes.get(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataSourceInstance> getDataSourceInstances() {
        return dataSourceInstances;
    }

    public void setDataSourceInstances(List<DataSourceInstance> dataSourceInstances) {
        this.dataSourceInstances = dataSourceInstances;
    }

}
