package com.newcoder.community.entity;

/*
 *  封装分页相关的信息
 * */
public class Page {

    // 当前页码
    private int current = 1;
    // 显示上限
    private int limit = 10;
    // 数据总数(用于计算总的页数)
    private int rows;
    // 查询路径(用于复用分页链接)
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows >= 0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    /*
     *
     * @param null
     * @return
     * @author biyunfei
     * @date 2021/11/10 15:47
     */

    public int getOffset() {
        // current * limit - limit
        return (current - 1) * limit;
    }

    /*
     * 获取总页数
     * @param null
     * @return
     * @author biyunfei
     * @date 2021/11/10 15:51
     */

    public int getTotal() {
        // rows / limit + 1
        return rows / limit == 0 ? rows / limit : rows / limit + 1;
    }

    /*
     *
     * @param null
     * @return
     * @author biyunfei
     * @date 2021/11/10 15:55
     */
    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    /*
     *
     * @param null
     * @return
     * @author biyunfei
     * @date 2021/11/10 15:56
     */
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }


}
