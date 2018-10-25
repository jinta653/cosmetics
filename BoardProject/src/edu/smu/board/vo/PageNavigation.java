package edu.smu.board.vo;

public class PageNavigation {
    
    private        boolean        isPrevPage;
    private        boolean        isNextPage;
    protected    int            nowPage;
    protected    int            rowTotal;
    protected    int            blockList;
    protected    int            blockPage;
    private        int            totalPage;
    private        int            startPage;
    private        int            endPage;
    private        int            startRow;
    private        int            endRow;
    
  
    public PageNavigation(int nowPage, int rowTotal, int blockList, int blockPage) {
        super();
        
        
        isPrevPage = false;
        isNextPage = false;
        
        
        this.totalPage    = (int) Math.ceil((double)rowTotal / (double)blockList);
        
        
        if(nowPage > this.totalPage)
        {
            nowPage = this.totalPage;
        }
        
       
        this.startRow    = (int) (nowPage - 1) * blockList;
        this.endRow        = (int) this.startRow + blockList - 1;
        
        
        this.startPage    = (int) ((nowPage - 1) / blockPage) * blockPage + 1;
        this.endPage    = (int) this.startPage + blockPage - 1;
        
        
        if(this.endPage > this.totalPage)
        {
            this.endPage = totalPage;
        }
        
        
        if(this.startPage > 1)
        {
            this.isPrevPage = true;
        }
        
       
        if(this.endPage < this.totalPage)
        {
            this.isNextPage = true;
        }
        
       
        this.nowPage = nowPage;
        this.rowTotal = rowTotal;
        this.blockList = blockList;
        this.blockPage = blockPage;
    }
    
    public void Debug()
    {
        System.out.println("Total Page : " + this.totalPage + " / Start Page : " + this.startPage + " / End Page : " + this.endPage);
        System.out.println("Total Row : " + this.rowTotal + " / Start Row : " + this.startRow + " / End Row : " + this.endRow);
    }
    
    
    public int getTotalPage() 
    {
        return totalPage;
    }
    
    
    public int getStartRow()
    {
        return startRow;
    }
    
    
    public int getEndRow()
    {
        return endRow;
    }
    
    
    public int getStartPage()
    {
        return startPage;
    }

    
    public int getEndPage()
    {
        return endPage;
    }
    
   
    public boolean isPrevPage()
    {
        return isPrevPage;
    }
    
    
    public boolean isNextPage()
    {
        return isNextPage;
    }
}