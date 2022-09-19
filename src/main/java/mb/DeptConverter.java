package mb;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import bean.Dept;

@FacesConverter(value = "deptConverter")
public class DeptConverter implements Converter {

	public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String id) {
		ValueExpression vex = ctx.getApplication().getExpressionFactory().createValueExpression(ctx.getELContext(),
				"#{mbAddEmp}", MBAddEmp.class);

		MBAddEmp depts = (MBAddEmp) vex.getValue(ctx.getELContext());
		if (id == "")
			return null;
		
		return depts.getDept(Integer.valueOf(id));
	}

	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object dept) {
		/*if (((Dept)dept).getId() == null)
			return null; For Primefaces select one menu */
		if (dept instanceof Dept) {
			return ((Dept) dept).getId().toString();
		}
		return null;
		
	}

}
