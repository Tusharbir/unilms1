package unilms;

import com.vmm.JHTTPServer;
import java.util.*;
import java.sql.*;

public class MyServer extends JHTTPServer {

    public MyServer(int portno) throws Exception {
        super(portno);
    }

    public Response serve(String uri, String Method, Properties header, Properties parms, Properties files) {
        Response res;
        System.out.println(uri);
        if (uri.contains("/adminlogin")) {

            System.out.println(uri);

            try {
                String u = parms.getProperty("user");
                String p = parms.getProperty("pass");

                ResultSet rs = DBLoader.executeSQL("select * from admin where username=\'" + u + "\' and password=\'" + p + "\'");

                if (rs.next()) {
                    return new Response(HTTP_OK, "text/plain", "Login Successfull !!!");

                } else {
                    return new Response(HTTP_OK, "text/plain", "login Failed !!!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());

            }
        } else if (uri.contains("/adminchangepassword")) {
            try {
                String au = parms.getProperty("user");
                String ap = parms.getProperty("pass");
                String np = parms.getProperty("newpass");

                ResultSet rs = DBLoader.executeSQL("select * from admin where username=\'" + au + "\' and password=\'" + ap + "\'");

                if (rs.next()) {
                    rs.updateString("password", np);
                    rs.updateRow();

                    return new Response(HTTP_OK, "text/plain", "Password Changed !!!");
                } else {

                    return new Response(HTTP_OK, "text/plain", "Incorrect Credentials");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/adminaddcourse")) {
            try {
                String cu = parms.getProperty("coursename");
                String du = parms.getProperty("department");
                String su = parms.getProperty("semester");
                String descu = parms.getProperty("description");

                ResultSet rs = DBLoader.executeSQL("select * from course where course_name=\'" + cu + "\' and department = '" + du + "' and semester =\'" + su + "\'");
                System.out.println(uri);

                if (rs.next()) {
                    return new Response(HTTP_OK, "text/plain", "Course Name Exists !!!");
                } else {
                    rs.moveToInsertRow();

                    // fill row
                    rs.updateString("course_name", cu);
                    rs.updateString("department", du);
                    rs.updateString("Semester", su);
                    rs.updateString("description", descu);

                    // insert to actual DB
                    rs.insertRow();

                    System.out.println("** record added to DB **");

                    return new Response(HTTP_OK, "text/plain", "Course Added !!!");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/adminviewcourse")) {
            try {
                ResultSet rs = DBLoader.executeSQL("select * from course");
                String ans = "";

                while (rs.next()) {
                    String cn, dept, des, sem;
                    cn = rs.getString("course_name");
                    dept = rs.getString("department");
                    des = rs.getString("description");
                    sem = rs.getString("semester");

                    ans += cn + ";;;" + dept + ";;;" + des + ";;;" + sem + "$$";

                }

                return new Response(HTTP_OK, "text/plain", ans);

            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/admindeletecourse")) {
            try {

                String course = parms.getProperty("course");
                String depart = parms.getProperty("depart");
                String sem = parms.getProperty("sem");
                ResultSet rs = DBLoader.executeSQL("select * from course where course_name=\'" + course + "\' and department = '" + depart + "' and semester =\'" + sem + "\'");
                if (rs.next()) {
                    rs.deleteRow();
                    return new Response(HTTP_OK, "text/plain", "Course Deleted !!!");
                } else {
                    return new Response(HTTP_OK, "text/plain", "Error Occured !!! Try Again");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/adminaddteacher")) {
            try {
                String teachername = parms.getProperty("teacher");
                String fathername = parms.getProperty("fathern");
                String address = parms.getProperty("address");
                String email = parms.getProperty("email");
                String phonenum = parms.getProperty("phn");
                String qualification = parms.getProperty("quali");
                String depart = parms.getProperty("dept");
                String pass = parms.getProperty("pass");

                ResultSet rs = DBLoader.executeSQL("select * from teacher");

                String filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/UniLMS_files");
                System.out.println("filename---" + filename);
                String photo = "src/UniLMS_files/" + filename;
                rs.moveToInsertRow();

                // fill row
                rs.updateString("teacher_name", teachername);
                rs.updateString("father_name", fathername);
                rs.updateString("address", address);
                rs.updateString("email_id", email);
                rs.updateString("phone_num", phonenum);
                rs.updateString("qualification", qualification);
                rs.updateString("department", depart);
                rs.updateString("photo", photo);
                rs.updateString("password", pass);

                // insert to actual DB
                rs.insertRow();

                //resultset 2
                ResultSet rs2 = DBLoader.executeSQL("select * from teacher ORDER BY teacher_id desc");
                if (rs2.next()) {
//                  

                    String teacher_id = rs2.getString("teacher_id");
                    return new Response(HTTP_OK, "text/plain", teacher_id);

                } else {
                    return new Response(HTTP_OK, "text/plain", "Fails!!!");

                }

            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }

        } else if (uri.contains("/adminviewteacher")) {
            try {
                String department = parms.getProperty("dept");
                ResultSet rs = DBLoader.executeSQL("select * from teacher where department=\'" + department + "\'");
                String ans2 = "";

                while (rs.next()) {
                    String ti, tn, fn, ad, em, pn, qual, de, ph;
                    ti = rs.getString("teacher_id");
                    tn = rs.getString("teacher_name");
                    fn = rs.getString("father_name");
                    ad = rs.getString("address");
                    em = rs.getString("email_id");
                    pn = rs.getString("phone_num");
                    qual = rs.getString("qualification");
                    de = rs.getString("department");
                    ph = rs.getString("photo");

                    ans2 += ti + ";;;" + tn + ";;;" + fn + ";;;" + ad + ";;;" + em + ";;;" + pn + ";;;" + qual + ";;;" + de + ";;;" + ph + "$$";

                }

                return new Response(HTTP_OK, "text/plain", ans2);

            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/admindeleteteacher")) {
            try {
                String ti = parms.getProperty("teach_id");
                ResultSet rs = DBLoader.executeSQL("select * from teacher where teacher_id=\'" + ti + "\'");
                if (rs.next()) {
                    rs.deleteRow();
                    return new Response(HTTP_OK, "text/plain", "Teacher Deleted !!!");
                } else {
                    return new Response(HTTP_OK, "text/plain", "Error Occured !!! Try Again");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/getcourse")) {
            try {

                String dept = parms.getProperty("depart");
                ResultSet rs = DBLoader.executeSQL("select distinct  course_name from course where department=\'" + dept + "\'");
                String ans4 = "";
                while (rs.next()) {
                    String course = rs.getString("course_name");

                    ans4 += course + "#$#";

                }
                return new Response(HTTP_OK, "text/plain", ans4);
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/getsemester")) {
            try {
                String course2 = parms.getProperty("course");
                String dept2 = parms.getProperty("de");
                ResultSet rs = DBLoader.executeSQL("select * from course where course_name=\'" + course2 + "\' and department = '" + dept2 + "'");
                String ans5 = "";
                while (rs.next()) {
                    String sem = rs.getString("semester");

                    ans5 += sem + "#$#$";

                }
                return new Response(HTTP_OK, "text/plain", ans5);
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }

        } else if (uri.contains("/adminaddstudent")) {
            try {
                String studentn = parms.getProperty("student_name");
                String fathern = parms.getProperty("father_name");
                String mothern = parms.getProperty("mother_name");
                String add = parms.getProperty("add");
                String mobilen = parms.getProperty("mobile");
                String emailid = parms.getProperty("email");
                String depart = parms.getProperty("depart");
                String course = parms.getProperty("coursename");
                String semester = parms.getProperty("semname");
                String pass2 = parms.getProperty("pass");

                ResultSet rs = DBLoader.executeSQL("select * from student");

                String filename2 = saveFileOnServerWithRandomName(files, parms, "photo", "src/UniLMS_files");
                System.out.println("filename---" + filename2);
                String photo2 = "src/UniLMS_files/" + filename2;

                rs.moveToInsertRow();

                // fill row
                rs.updateString("name", studentn);
                rs.updateString("father_name", fathern);
                rs.updateString("mother_name", mothern);
                rs.updateString("address", add);
                rs.updateString("email_id", emailid);
                rs.updateString("mobile", mobilen);

                rs.updateString("department", depart);
                rs.updateString("semester", semester);
                rs.updateString("course", course);
                rs.updateString("photo", photo2);
                rs.updateString("password", pass2);

                // insert to actual DB
                rs.insertRow();

                //resultset 2
                ResultSet rs2 = DBLoader.executeSQL("select * from student ORDER BY student_id desc");
                if (rs2.next()) {
//                  

                    String student_id = rs2.getString("student_id");
                    return new Response(HTTP_OK, "text/plain", student_id);

                } else {
                    return new Response(HTTP_OK, "text/plain", "Fails!!!");

                }

            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }

        } else if (uri.contains("/adminviewstudent")) {
            try {
                String department = parms.getProperty("dept");
                ResultSet rs = DBLoader.executeSQL("select * from student where department=\'" + department + "\'");
                String ans6 = "";

                while (rs.next()) {
                    String ti, tn, fn, mn, ad, em, mob, dep, sem, cour, photo;
                    ti = rs.getString("student_id");
                    tn = rs.getString("name");
                    fn = rs.getString("father_name");
                    mn = rs.getString("mother_name");

                    ad = rs.getString("address");
                    em = rs.getString("email_id");
                    mob = rs.getString("mobile");
                    dep = rs.getString("department");
                    sem = rs.getString("semester");
                    cour = rs.getString("course");
                    photo = rs.getString("photo");

                    ans6 += ti + ";;;" + tn + ";;;" + fn + ";;;"
                            + mn + ";;;" + ad + ";;;" + em + ";;;"
                            + mob + ";;;" + dep + ";;;" + sem + ";;;" + cour + ";;;" + photo + "$$";

                }

                return new Response(HTTP_OK, "text/plain", ans6);

            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/admindeletestudent")) {
            try {
                String si = parms.getProperty("studentid");
                ResultSet rs = DBLoader.executeSQL("select * from student where student_id=\'" + si + "\'");
                if (rs.next()) {
                    rs.deleteRow();
                    return new Response(HTTP_OK, "text/plain", "Student Deleted !!!");
                } else {
                    return new Response(HTTP_OK, "text/plain", "Error Occured !!! Try Again");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/teacherlogin")) {
            try {
                String u = parms.getProperty("user");
                String p = parms.getProperty("pass");

                ResultSet rs = DBLoader.executeSQL("select * from teacher where teacher_id=\'" + u + "\' and password=\'" + p + "\'");

                if (rs.next()) {
                    return new Response(HTTP_OK, "text/plain", "Login Successfull !!!");

                } else {
                    return new Response(HTTP_OK, "text/plain", "login Failed !!!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());

            }
        } else if (uri.contains("/teacherchangepassword")) {
            try {
                String au = parms.getProperty("user");
                String ap = parms.getProperty("pass");
                String np = parms.getProperty("newpass");

                ResultSet rs = DBLoader.executeSQL("select * from teacher where teacher_id=\'" + au + "\' and password=\'" + ap + "\'");

                if (rs.next()) {
                    rs.updateString("password", np);
                    rs.updateRow();

                    return new Response(HTTP_OK, "text/plain", "Password Changed !!!");
                } else {

                    return new Response(HTTP_OK, "text/plain", "Incorrect Credentials");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }

        } else if (uri.contains("/teacherviewprofile")) {
            try {
                String teach_id = parms.getProperty("id");

                System.out.println(teach_id);
                ResultSet rs = DBLoader.executeSQL("select * from teacher where teacher_id=\'" + teach_id + "\'");
                String ans7 = "";
                while (rs.next()) {
                    String ti, tn, fn, mn, ad, em, mob, dep, photo;
                    ti = rs.getString("teacher_id");
                    tn = rs.getString("teacher_name");
                    fn = rs.getString("father_name");
                    mn = rs.getString("address");
                    ad = rs.getString("email_id");
                    em = rs.getString("phone_num");
                    mob = rs.getString("qualification");
                    dep = rs.getString("department");
                    photo = rs.getString("photo");

//                   photo =  rs.getString("photo");
                    ans7 += ti + ";;;" + tn + ";;;" + fn + ";;;"
                            + mn + ";;;" + ad + ";;;" + em + ";;;"
                            + mob + ";;;" + dep + ";;;" + photo;

                }
                return new Response(HTTP_OK, "text/plain", ans7);
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/teachersetname")) {
            try {
                String teach_id = parms.getProperty("id");

                System.out.println(teach_id);
                ResultSet rs = DBLoader.executeSQL("select * from teacher where teacher_id=\'" + teach_id + "\'");
                String ans7 = "";
                while (rs.next()) {
                    String tn, dep, photo;

                    tn = rs.getString("teacher_name");

                    dep = rs.getString("department");
//                   photo =  rs.getString("photo");

                    ans7 += tn + ";;;" + dep + ";;;";

                }
                return new Response(HTTP_OK, "text/plain", ans7);
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/teacheraddnotes")) {
            try {
                String coursename = parms.getProperty("course");
                String depart = parms.getProperty("dept");
                String semester = parms.getProperty("sem");
                String title = parms.getProperty("title");
                String details = parms.getProperty("details");
                String id = parms.getProperty("id");
                String date = parms.getProperty("date");
                String type = parms.getProperty("type");

                ResultSet rs = DBLoader.executeSQL("select * from notes");

                String filename = saveFileOnServerWithRandomName(files, parms, "file", "src/UniLMS_files");
                System.out.println("filename---" + filename);
                String photo = "src/UniLMS_files/" + filename;

                rs.moveToInsertRow();

                rs.updateString("teacher_id", id);
                rs.updateString("course_name", coursename);
                rs.updateString("semester", semester);
                rs.updateString("department", depart);
                rs.updateString("title", title);
                rs.updateString("details", details);
                rs.updateString("file", photo);
                rs.updateString("date", date);
                rs.updateString("type", type);

                rs.insertRow();

                ResultSet rs2 = DBLoader.executeSQL("select * from notes ORDER BY notes_id desc");
                if (rs2.next()) {
//                  

                    String notes_id = rs2.getString("notes_id");
                    return new Response(HTTP_OK, "text/plain", notes_id);

                } else {
                    return new Response(HTTP_OK, "text/plain", "Fails!!!");

                }

            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/teacherviewnotes")) {
            try {
                String id = parms.getProperty("id");
                String dept = parms.getProperty("dept");
                String course = parms.getProperty("course");
                String sem = parms.getProperty("sem");
                ResultSet rs = DBLoader.executeSQL("select * from notes where teacher_id ='" + id + "' and  course_name=\'" + course + "\' and department = '" + dept + "' and semester =\'" + sem + "\'");
                String ans = "";

                while (rs.next()) {
                    String notes, cn, semester, title, details, file, type, date;

                    notes = rs.getString("notes_id");

                    cn = rs.getString("course_name");
                    semester = rs.getString("semester");
                    title = rs.getString("title");
                    details = rs.getString("details");
                    type = rs.getString("type");
                    file = rs.getString("file");
                    date = rs.getString("date");

                    ans += notes + ";;;" + cn + ";;;" + semester + ";;;" + title + ";;;" + details + ";;;" + type + ";;;" + date + ";;;" + file + "$$";

                }
                return new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("teacherdeletenotes")) {
            try {
                String notesid = parms.getProperty("notesid");
                ResultSet rs = DBLoader.executeSQL("select * from notes where notes_id=\'" + notesid + "\'");
                if (rs.next()) {
                    rs.deleteRow();
                    return new Response(HTTP_OK, "text/plain", "Notes Deleted !!!");
                } else {
                    return new Response(HTTP_OK, "text/plain", "Error Occured !!! Try Again");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/TeacherAddAssignment")) {
            try {
                String coursename = parms.getProperty("course");
                String depart = parms.getProperty("dept");
                String semester = parms.getProperty("sem");
                String title = parms.getProperty("title");
                String details = parms.getProperty("details");
                String id = parms.getProperty("id");
                String date = parms.getProperty("date");
                String type = parms.getProperty("type");
                String subdate = parms.getProperty("subdate");

                ResultSet rs = DBLoader.executeSQL("select * from assignment");

                String filename = saveFileOnServerWithRandomName(files, parms, "file", "src/UniLMS_files");
                System.out.println("filename---" + filename);
                String photo = "src/UniLMS_files/" + filename;

                rs.moveToInsertRow();

                rs.updateString("teacher_id", id);
                rs.updateString("course_name", coursename);
                rs.updateString("semester", semester);
                rs.updateString("department", depart);
                rs.updateString("title", title);
                rs.updateString("details", details);
                rs.updateString("file", photo);
                rs.updateString("type", type);
                rs.updateString("date", date);

                rs.updateString("subdate", subdate);

                rs.insertRow();

                ResultSet rs2 = DBLoader.executeSQL("select * from assignment ORDER BY assignment_id desc");
                if (rs2.next()) {
//                  

                    String assignment_id = rs2.getString("assignment_id");
                    return new Response(HTTP_OK, "text/plain", assignment_id);

                } else {
                    return new Response(HTTP_OK, "text/plain", "Fails!!!");

                }

            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/teacherviewassignment")) {
            try {
                String id = parms.getProperty("id");
                String dept = parms.getProperty("dept");
                String course = parms.getProperty("course");
                String sem = parms.getProperty("sem");
                ResultSet rs = DBLoader.executeSQL("select * from assignment where teacher_id ='" + id + "' and  course_name=\'" + course + "\' and department = '" + dept + "' and semester =\'" + sem + "\'");
                String ans = "";

                while (rs.next()) {
                    String notes, cn, semester, title, details, file, type, date, date2;

                    notes = rs.getString("assignment_id");

                    cn = rs.getString("course_name");
                    semester = rs.getString("semester");
                    title = rs.getString("title");
                    details = rs.getString("details");
                    type = rs.getString("type");
                    file = rs.getString("file");
                    date = rs.getString("date");
                    date2 = rs.getString("subdate");

                    ans += notes + ";;;" + cn + ";;;" + semester + ";;;" + title
                            + ";;;" + details + ";;;" + type + ";;;"
                            + file + ";;;" + date + ";;;" + date2 + "$$";

                }
                return new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/teacherdeleteassignment")) {
            try {
                String notesid = parms.getProperty("assignment_id");
                ResultSet rs = DBLoader.executeSQL("select * from assignment where assignment_id=\'" + notesid + "\'");
                if (rs.next()) {
                    rs.deleteRow();
                    return new Response(HTTP_OK, "text/plain", "Assignment Deleted !!!");
                } else {
                    return new Response(HTTP_OK, "text/plain", "Error Occured !!! Try Again");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/studentlogin")) {
            try {
                String u = parms.getProperty("user");
                String p = parms.getProperty("pass");

                ResultSet rs = DBLoader.executeSQL("select * from student where student_id=\'" + u + "\' and password=\'" + p + "\'");

                if (rs.next()) {
                    return new Response(HTTP_OK, "text/plain", "Login Successfull !!!");

                } else {
                    return new Response(HTTP_OK, "text/plain", "login Failed !!!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());

            }
        } else if (uri.contains("/studentviewprofile")) {
            try {
                String teach_id = parms.getProperty("id");

                System.out.println(teach_id);
                ResultSet rs = DBLoader.executeSQL("select * from student where student_id=\'" + teach_id + "\'");
                String ans7 = "";
                while (rs.next()) {
                    String ti, tn, fn, mn, ad, em, mob, dep, photo, course, sem;
                    ti = rs.getString("student_id");
                    tn = rs.getString("name");
                    fn = rs.getString("father_name");
                    mn = rs.getString("mother_name");
                    ad = rs.getString("address");
                    em = rs.getString("email_id");
                    mob = rs.getString("mobile");
                    course = rs.getString("course");
                    sem = rs.getString("semester");

//                   mob =  rs.getString("qualification");
                    dep = rs.getString("department");

                    photo = rs.getString("photo");
                    ans7 += ti + ";;;" + tn + ";;;" + fn + ";;;"
                            + mn + ";;;" + ad + ";;;" + em + ";;;"
                            + mob + ";;;" + course + ";;;" + sem + ";;;" + dep + ";;;" + photo;

                }
                return new Response(HTTP_OK, "text/plain", ans7);
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/studentsetname")) {
            try {
                String teach_id = parms.getProperty("id");

                System.out.println(teach_id);
                ResultSet rs = DBLoader.executeSQL("select * from student where student_id=\'" + teach_id + "\'");
                String ans7 = "";
                while (rs.next()) {
                    String tn, dep, photo, sem, course;

                    tn = rs.getString("name");

                    dep = rs.getString("department");
//                   photo =  rs.getString("photo");

                    course = rs.getString("course");
                    sem = rs.getString("semester");

                    ans7 += tn + ";;;" + dep + ";;;" + course + ";;;" + sem;

                }
                return new Response(HTTP_OK, "text/plain", ans7);
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/studentchangepassword")) {
            try {
                String au = parms.getProperty("user");
                String ap = parms.getProperty("pass");
                String np = parms.getProperty("newpass");

                ResultSet rs = DBLoader.executeSQL("select * from student where student_id=\'" + au + "\' and password=\'" + ap + "\'");

                if (rs.next()) {
                    rs.updateString("password", np);
                    rs.updateRow();

                    return new Response(HTTP_OK, "text/plain", "Password Changed !!!");
                } else {

                    return new Response(HTTP_OK, "text/plain", "Incorrect Credentials");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }

        } else if (uri.contains("/studentviewnotes")) {
            try {
                String dept = parms.getProperty("depart");
                String course = parms.getProperty("course");
                String sem = parms.getProperty("sem");
                ResultSet rs = DBLoader.executeSQL("select * from notes where course_name=\'" + course + "\' and department = '" + dept + "' and semester =\'" + sem + "\'");
                String ans = "";

                while (rs.next()) {
                    String notes, cn, semester, title, details, file, type, date;

//                    notes= rs.getString("notes_id");
//                    
//                    cn = rs.getString("course_name");
//                    semester = rs.getString("semester");
                    title = rs.getString("title");
                    details = rs.getString("details");
                    type = rs.getString("type");
                    file = rs.getString("file");
                    date = rs.getString("date");

                    ans += title + ";;;" + details + ";;;" + type + ";;;" + date + ";;;" + file + "$$";

                }
                return new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.equals("/studentviewassignment")) {
            try {

                String dept = parms.getProperty("depart");
                String course = parms.getProperty("course");
                String sem = parms.getProperty("sem");
                ResultSet rs = DBLoader.executeSQL("select * from assignment INNER JOIN teacher ON assignment.teacher_id = teacher.teacher_id where assignment.course_name=\'" + course + "\' and assignment.department = \'" + dept + "' and assignment.semester =\'" + sem + "\'");
                String ans = "";

                while (rs.next()) {
                    String id, name, title, details, date, date2;

                    id = rs.getString("assignment_id");

                    title = rs.getString("title");
                    details = rs.getString("details");
                    name = rs.getString("teacher_name");

                    date = rs.getString("date");
                    date2 = rs.getString("subdate");

                    ans += id + ";;;" + title + ";;;" + details + ";;;" + name
                            + ";;;" + date + ";;;" + date2 + ";;;"
                            + "$$";

                }
                return new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }

        } else if (uri.equals("/studentviewassignmentdetails")) {
            try {

                String asid = parms.getProperty("id");
                ResultSet rs = DBLoader.executeSQL("select * from assignment where assignment_id =\'" + asid + "\'");
                String ans = "";

                while (rs.next()) {
                    String id, name, title, details, date, date2;

                    id = rs.getString("assignment_id");

                    title = rs.getString("title");
                    details = rs.getString("details");

                    date = rs.getString("date");
                    date2 = rs.getString("subdate");

                    ans += id + ";;;" + title + ";;;" + details + ";;;" + date + ";;;" + date2 + ";;;"
                            + "$$";

                }
                return new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.equals("/studentsubmitassignment")) {
            try {
                String assignmentid = parms.getProperty("assid");
                String studentid = parms.getProperty("studentid");
                String date = parms.getProperty("date");

                ResultSet rs = DBLoader.executeSQL("select * from submission");

                String filename = saveFileOnServerWithRandomName(files, parms, "file", "src/UniLMS_files");
                System.out.println("filename---" + filename);
                String file = "src/UniLMS_files/" + filename;

                rs.moveToInsertRow();

                rs.updateString("assignment_id", assignmentid);
                rs.updateString("student_id", studentid);
                rs.updateString("date", date);
                rs.updateString("file", file);

                rs.insertRow();

                ResultSet rs2 = DBLoader.executeSQL("select * from submission ORDER BY submission_id desc");
                if (rs2.next()) {
//                  

                    String submission_id = rs2.getString("assignment_id");
                    return new Response(HTTP_OK, "text/plain", submission_id);

                } else {
                    return new Response(HTTP_OK, "text/plain", "Fails!!!");

                }

            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.equals("/studentaskquestion")) {
            try {
                String name = parms.getProperty("name");
                String sid = parms.getProperty("id");
                String question = parms.getProperty("question");

                ResultSet rs = DBLoader.executeSQL("select * from chat");

                rs.moveToInsertRow();

                rs.updateString("student_id", sid);
                rs.updateString("s_name", name);
                rs.updateString("question", question);

                rs.insertRow();
                ResultSet rs2 = DBLoader.executeSQL("select * from chat ORDER BY chatid desc");
                if (rs2.next()) {
//                  

                    String chatid = rs2.getString("chatid");
                    return new Response(HTTP_OK, "text/plain", chatid);

                } else {
                    return new Response(HTTP_OK, "text/plain", "Fails!!!");

                }

            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/loadquestion")) {
            try {

                String dept = parms.getProperty("depart");
                String course = parms.getProperty("course");
                String sem = parms.getProperty("sem");
                ResultSet rs = DBLoader.executeSQL("select * from chat INNER JOIN student ON chat.student_id = student.student_id where student.course=\'" + course + "\' and student.semester = semester and chat.answer = 'na' ");
                String ans = "";

                while (rs.next()) {
                    String chatid, sid, sname, question, tid, tname, answer;

                    chatid = rs.getString("chatid");
                    sid = rs.getString("student_id");
                    sname = rs.getString("s_name");
                    question = rs.getString("question");

                    ans += chatid + ";;;" + sid + ";;;" + sname + ";;;" + question
                            + "$$";

                }
                return new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.equals("/teachersendans")) {
            try {
                String chatid = parms.getProperty("chatid");
                String ans = parms.getProperty("ans");
                String tname = parms.getProperty("teachername");
                String tid = parms.getProperty("tid");

                ResultSet rs = DBLoader.executeSQL("select * from chat where chatid=\'" + chatid + "\'");

                if (rs.next()) {
                    rs.updateString("teacher_id", tid);
                    rs.updateString("t_name", tname);
                    rs.updateString("answer", ans);
                    rs.updateRow();

                }

                return new Response(HTTP_OK, "text/plain", "Answer Published !!");
            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());
            }
        } else if (uri.contains("/studentfetchchat")) {
            try {
                String id = parms.getProperty("id");

                ResultSet rs = DBLoader.executeSQL("select * from  chat where student_id=\'" + id + "\'");
                String answer, question, tname;
                String feed = "";
                while (rs.next()) {
                    answer = rs.getString("answer");
                    question = rs.getString("question");
                    tname = rs.getString("t_name");

                    feed += question + ";;;" + answer + ";;;" + tname + "#$#";

                }

                return new Response(HTTP_OK, "text/plain", feed);

            } catch (Exception ex) {
                ex.printStackTrace();
                return new Response(HTTP_OK, "text/plain", ex.toString());

            }

        } else if (uri.equals("/teachergradeassignment")) {
            String ans = "";

            try {

                String id = parms.getProperty("id");

                String subid, assid, sid, date, file;
                ResultSet rs = DBLoader.executeSQL("select * from submission INNER JOIN assignemnt ON submission.assignment_id= assignemnt.assignment_id where assignment.teacher_id =\'" + id + "\'");

                while (rs.next()) {
                    subid = rs.getString("submission_id");
                    assid = rs.getString("assignment_id");
                    sid = rs.getString("student_id");
                    date = rs.getString("date");
                    file = rs.getString("file");

                    ans += subid + ";;;" + assid + ";;;" + sid + ";;;" + date + ";;;" + file + "$$$";

                }

            } catch (Exception ex) {
                ex.printStackTrace();
                //return new Response(HTTP_OK, "text/plain", ex.toString());
            }

            return new Response(HTTP_OK, "text/plain", ans);

        } else if (uri.contains("/getresource")) {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            System.out.println(uri);

            res = sendCompleteFile(uri);
            return res;

        } else {
            return new Response(HTTP_OK, "text/plain", "Invalid Uri");
        }

    }

}
