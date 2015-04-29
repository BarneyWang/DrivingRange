package org.heng.xml.impl.db;

import com.google.gson.Gson;
import org.heng.xml.XmlFile;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * @author wangdi
 */
@XmlFile("db.xml")
public class DatabaseConfig {

    @ElementList(inline = true, entry = "dataSourceCluster")
    private List<DataSourceCluster> dataSourceClusters;

    public List<DataSourceCluster> getDataSourceClusters() {
        if (dataSourceClusters.isEmpty()) {
            throw new IllegalStateException();
        }
        return dataSourceClusters;
    }

    public void setDataSourceClusters(List<DataSourceCluster> dataSourceClusters) {
        this.dataSourceClusters = dataSourceClusters;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
