package cn.happy.entity;

/**
 * Created by cgg on 2017/1/12.
 */
public class Street {
    private Integer id;
    private String name;
    //所属区县编号
    private Integer district_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Integer district_id) {
        this.district_id = district_id;
    }
}
