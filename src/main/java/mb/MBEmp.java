package mb;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import bean.Emp;
import dao.EmpDAO;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import report.Report;

@ViewScoped
@ManagedBean(name = "mbEmp")
public class MBEmp {

	private List<Emp> empTable;
	private List<Emp> filteredEmpTable;
	private Emp selectedEmp;
	private EmpDAO empDAO;

	@PostConstruct
	public void init() {
		empDAO = new EmpDAO();
		empTable = empDAO.selectAll();
		selectedEmp = new Emp();
	}

	public String updateEmp() {
		empDAO.update(selectedEmp);
		empTable = empDAO.selectAll();
		return null;
	}

	public String removeEmp() {
		empDAO.delete(selectedEmp.getId());
		empTable = empDAO.selectAll();
		return null;
	}

	public String runEmpReport() throws Exception {

		Map<String, Object> param = new HashMap<String, Object>();
		
		BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/Images/JRLogo.png"));
		param.put("p_deptno", new BigDecimal(99));
		param.put("p_image", image);

		Report report = new Report();
		report.runPdf("emp.jasper", param);

		return null;
	}
	
	public String runSalaryGradeReport() throws Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		ServletContext context = getContext();
		InputStream fsSub = context.getResourceAsStream("/secured/reports/" + "sal-grade-sub-report.jasper");
		JasperReport subReport = (JasperReport) JRLoader.loadObject(fsSub);

		BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/Images/JRLogo.png"));
		param.put("p_image", image);
		param.put("SUBREPORT_JASPER_FILE", subReport);

		Report report = new Report();
		report.runPdf("sal-grade.jasper", param);

		return null;
	}

	public List<Emp> getEmpTable() {
		return empTable;
	}

	public void setEmpTable(List<Emp> empTable) {
		this.empTable = empTable;
	}

	public Emp getSelectedEmp() {
		return selectedEmp;
	}

	public void setSelectedEmp(Emp selectedEmp) {
		this.selectedEmp = selectedEmp;
	}

	public List<Emp> getFilteredEmpTable() {
		return filteredEmpTable;
	}

	public void setFilteredEmpTable(List<Emp> filteredEmpTable) {
		this.filteredEmpTable = filteredEmpTable;
	}
	
	public static ServletContext getContext() {
		return (ServletContext) getFacesContext().getExternalContext().getContext();
	}
	
	public static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

}
