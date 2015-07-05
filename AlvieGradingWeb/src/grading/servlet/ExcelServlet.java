package grading.servlet;

import grading.beans.GradingBean;
import grading.beans.Student;
import grading.modal.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/**
 * Servlet implementation class ExcelServlet
 */
@WebServlet("/ExcelServlet")
public class ExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String realDir;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		realDir = config.getServletContext().getRealPath("/excelfile/");
				
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			filedown(request, response);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void filedown(HttpServletRequest request, HttpServletResponse response) throws IOException, FileUploadException
	{
		HttpSession session = request.getSession(true);
		
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
		response.setContentType("text/html; charset=utf-8");
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	
		if(isMultipart){

			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(1*1024*1024);

			
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			upload.setSizeMax(10*1024*1024);
		
			List<FileItem> items = upload.parseRequest(request);
			Iterator iter = items.iterator();
			
			GradingBean grading = new GradingBean();
			ObservableList<Student> students = FXCollections.observableArrayList();
			
			while(iter.hasNext()){
			
				FileItem fileItem = (FileItem)iter.next();
				
				if(fileItem.isFormField()){
					System.out.println("here 4- EOF");
					
					
				}else{
					System.out.println("here 5");
					if(fileItem.getSize()>0){
						
						
						String contentType = fileItem.getName();
						if(contentType.endsWith("xlsx")){		//xlsx
							NewExcelDataManager xlsxData = new NewExcelDataManager(fileItem.getInputStream(),grading) ;
							students = xlsxData.getDataFromSheet();
						}else if(contentType.endsWith("xls")){									//xls
							OldExcelDataManager xlsData = new OldExcelDataManager(fileItem.getInputStream(),grading);
							students = xlsData.getDataFromSheet();
						}
					}
				}
				
				
				
			}
			
			if(students.size()==0){						//file error
				System.out.println("no file reading");
				session.setAttribute("isBack", true);
				gotemp(response,"index.jsp");
			}else{										//success
				
				System.out.println("file existed, n is successful");
				session.setAttribute("isBack",false);
				session.setAttribute("student", students);
				session.setAttribute("gradingStandard", grading);
				gotemp(response,"mainShowing.jsp");
			}
		}
	}
	
	private void gotemp(HttpServletResponse response,String goSite) throws IOException{
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<script type = 'text/javascript'>");
		out.println("location.href='" + goSite + "';");
		out.println("</script>");
	}

}
