package com.ahao.tools;

/**
 * @Description: 分页工具
 * 需获取     表记录总数、当前页
 * 得到      坐标，总页数
 * @Author: ahao
 * @Date: 2022/12/7 18:56
 **/
public class HaoPageHelp {

    //页容量自定义 唯一修改位置
    public int pageSize = 10;   //第二参数 每页行数

    private int currentPageNo = 0;    //当前页码
    private int totalCount = 0;        //总数(表)
    private int totalPageCount = 1;    // 总页数  (totalCount+10-1)/10;
    private int pageHeadIndex = 0;      //limit第一个参数 起始行坐标

    public void setCurrentPageNo(int currentPageNo) {
        if (currentPageNo>0){
            this.currentPageNo = currentPageNo;
            //设置当前页第一行的坐标
            this.setPageHeadIndexMe();
        }
    }

    //设置当前页第一行的坐标
    private void setPageHeadIndexMe() {
        this.pageHeadIndex = (this.currentPageNo-1) * this.pageSize;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount>0){
            this.totalCount = totalCount;
            //设置总页数
            this.setTotalPageCountMe();
        }
    }

    //设置总页数
    private void setTotalPageCountMe() {
        this.totalPageCount = (this.totalCount +this.pageSize -1) / this.pageSize;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public int getPageHeadIndex() {
        return pageHeadIndex;
    }




}
