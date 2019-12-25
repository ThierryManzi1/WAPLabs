/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.io.IOException;   import javax.servlet.jsp.*; 
import javax.servlet.jsp.tagext.*; 

/**
 *
 * @author Owner
 */
public class Label  extends SimpleTagSupport {
    String foreColor;  
    String text; 
    public void doTag() throws JspException, IOException  {  
        JspWriter out = getJspContext().getOut();  
        if (foreColor != null)   
            out.write(String.format("<span style='color:%s'>%s</span>", foreColor, text));   
        else   
            out.write(String.format("<span>%s</span>", text));   
    }   
    public void setForeColor(String foreColor)  {   
        this.foreColor = foreColor;  
    }    
    public void setText(String text)  {  
        this.text = text; 
    } 
    
}
