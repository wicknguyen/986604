package mum.custom.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class Head extends SimpleTagSupport {
    String thecolor;
    String words;
    //This is called from JSP servlet to render custom tag
    public void doTag() throws JspException, IOException
    {
        JspWriter out = getJspContext().getOut();
        if (thecolor != null)
            out.write(String.format("<span style='color:%s'>%s</span>", thecolor, words));
        else
            out.write(String.format("<span>%s</span>", words));
    }
    //Need a setter for each attribute of custom tag
    public void setThecolor(String thecolor)
    {
        this.thecolor = thecolor;
    }
    public void setWords(String words)
    {
        this.words = words;
    }
}
