---
##分页属性

private Integer pageHeadIndex;                  //limit第一个参数  起始行坐标

private Integer pageSize;                         //第二参数    每页行数

private Integer pageIndex;                                  **//当前页码**

private Integer totalCount;                                  **//总数**

private Integer totalPageCount = (totalCount+10-1)/10;       **//总页数**

---
