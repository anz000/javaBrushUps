package anuz.relationship.employees;
import java.util.Calendar;

public class EmploymentPeriod {
	private Calendar endDate;
	private Calendar startDate;

	public EmploymentPeriod(Calendar endDate, Calendar startDate) {
		super();
		this.endDate = endDate;
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "EmploymentPeriod [endDate=" + endDate + ", startDate=" + startDate + "]";
	}

}
