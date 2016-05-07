package com.example.hassannaqvi.mccp2;

import android.provider.BaseColumns;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;


public class ClustersContract {

    private Long _ID;
    private String ROW_CLUSTER_CODE;
    private String ROW_UC_ID;
    private String ROW_TOWN_ID;
    private String ROW_CLUSTER_NAME;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public String getClusterCode() {
        return this.ROW_CLUSTER_CODE;
    }


    public void setClusterCode(String clusterCode) {
        this.ROW_CLUSTER_CODE = clusterCode;
    }


    public Long getId() {
        return this._ID;
    }


    public void setId(String ids) {
        this._ID = Long.valueOf(ids);
    }


    public String getTownId() {
        return this.ROW_TOWN_ID;
    }


    public void setTownId(String townId) {
        Log.i("TidS: ", townId);
        this.ROW_TOWN_ID = townId;
        Log.i("TidT: ", this.ROW_TOWN_ID);
    }


    public String getUCId() {
        return this.ROW_UC_ID;
    }


    public void setUCId(String UCId) {

        Log.i("CConS: ", UCId);
        this.ROW_UC_ID = UCId;
        Log.i("CConT: ", this.ROW_UC_ID);
    }


    public String getClusterName() {
        return this.ROW_CLUSTER_NAME;
    }


    public void setClusterName(String clusterName) {
        this.ROW_CLUSTER_NAME = clusterName;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    public static abstract class singleCluster implements BaseColumns {

        public static final String TABLE_NAME = "Clusters";
        public static final String _ID = "_ID";
        public static final String ROW_CLUSTERS_CODE = "CLUSTERS_CODE";
        public static final String ROW_UC_ID = "UC_ID";
        public static final String ROW_CLUSTERS_NAME = "CLUSTERS_NAME";
        public static final String ROW_TOWN_ID = "TOWN_ID";

    }
}
