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
    
    // �������� ����ϴ� ������
    public PageNavigation(int nowPage, int rowTotal, int blockList, int blockPage) {
        super();
        
        // ���� �÷��׸� �ʱ�ȭ
        isPrevPage = false;
        isNextPage = false;
        
        // �Էµ� ��ü ���� ���� ���� ��ü ������ ���� ����Ѵ�
        this.totalPage    = (int) Math.ceil((double)rowTotal / (double)blockList);
        
        // ���� �������� ��ü ������������ Ŭ��� ��ü ���������� ������ �����Ѵ�
        if(nowPage > this.totalPage)
        {
            nowPage = this.totalPage;
        }
        
        // DB�Է��� ���� ���۰� ���ᰪ�� ���Ѵ�
        this.startRow    = (int) (nowPage - 1) * blockList;
        this.endRow        = (int) this.startRow + blockList - 1;
        
        // ������������ ������������ ���� ���Ѵ�
        this.startPage    = (int) ((nowPage - 1) / blockPage) * blockPage + 1;
        this.endPage    = (int) this.startPage + blockPage - 1;
        
        // ������ ���������� ��ü ������������ Ŭ ��� ���� ����
        if(this.endPage > this.totalPage)
        {
            this.endPage = totalPage;
        }
        
        // ���� �������� 1���� Ŭ ��� ���� ����¡�� �����Ѱ����� �����Ѵ�
        if(this.startPage > 1)
        {
            this.isPrevPage = true;
        }
        
        // ������������ ��ü���������� ������� ���� ����¡�� �����Ѱ����� �����Ѵ�
        if(this.endPage < this.totalPage)
        {
            this.isNextPage = true;
        }
        
        // ��Ÿ ���� �����Ѵ�
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
    
    // ��ü ������ ���� �˾ƿ´�
    public int getTotalPage() 
    {
        return totalPage;
    }
    
    // ���� Row���� �����´�
    public int getStartRow()
    {
        return startRow;
    }
    
    // ������ Row���� �����´�
    public int getEndRow()
    {
        return endRow;
    }
    
    // Block Row ũ�⸦ �����´�
//    public int getBlockSize()
//    {
//        return blockSize;
//    }
    
    // �������������� �����´�
    public int getStartPage()
    {
        return startPage;
    }

    // ������ ���������� �����´�
    public int getEndPage()
    {
        return endPage;
    }
    
    // ������������ ���������� �����´�
    public boolean isPrevPage()
    {
        return isPrevPage;
    }
    
    // ������������ ���������� �����´�
    public boolean isNextPage()
    {
        return isNextPage;
    }
}