package org.xsaas.xstat.utils.page;


import java.util.List;

@SuppressWarnings("unchecked")
public class Results {
	private Page page;   
	  
    private List content;   
    private Object othercontent;
  
    public Object getOthercontent() {
		return othercontent;
	}

    
	public void setOthercontent(Object othercontent) {
		this.othercontent = othercontent;
	}

	/**  
     * The default constructor  
     */  
    public Results() {   
        super();   
    }   
  
    /**  
     * The constructor using fields  
     *   
     * @param page  
     * @param content  
     */  
    public Results(Page page, List content) {   
        this.page = page;   
        this.content = content;   
    }   
  
    /**  
     * @return Returns the content.  
     */  
    public List getContent() {   
        return content;   
    }   
  
    /**  
     * @return Returns the page.  
     */  
    public Page getPage() {   
        return page;   
    }   
  
    /**  
     * @param content  
     *            The content to set.  
     */  
    public void setContent(List content) {   
        this.content = content;   
    }   
  
    /**  
     * @param page  
     *            The page to set.  
     */  
    public void setPage(Page page) {   
        this.page = page;   
    }   
}   
