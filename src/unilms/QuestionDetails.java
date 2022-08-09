/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unilms;

/**
 *
 * @author tushar
 */
public class QuestionDetails 
{
    String chatid,sid,sname,question;
    boolean status;

    public QuestionDetails(String chatid, String sid, String sname, String question,boolean status ) {
        this.chatid = chatid;
        this.sid = sid;
        this.sname = sname;
        this.question = question;
        this.status=status;
        
    }
    
    
}
