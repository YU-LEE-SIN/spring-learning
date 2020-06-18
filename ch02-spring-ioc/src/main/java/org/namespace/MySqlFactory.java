package org.namespace;

/**
 * @author yu
 * @date 2020/5/17
 */
public class MySqlFactory {
    private MyDataSource dateSource;

    public MySqlFactory(){}

    public MySqlFactory(MyDataSource dateSource) {
        this.dateSource = dateSource;
    }

    public MyDataSource getDateSource() {
        return dateSource;
    }

    public void setDateSource(MyDataSource dateSource) {
        this.dateSource = dateSource;
    }
}
