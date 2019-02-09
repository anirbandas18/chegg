package expertqa.february2_2019.performance;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class PerformanceAttributes {
	
	private Long addToFrontOfList;
	private Long addToMiddleOfList;
	private Long addToEndOfList;
	private Long delFromFrontOfList;
	private Long delFromMiddleOfList;
	private Long delFromEndOfList;
	public Long getAddToFrontOfList() {
		return addToFrontOfList;
	}
	public void setAddToFrontOfList(Long addToFrontOfList) {
		this.addToFrontOfList = addToFrontOfList;
	}
	public Long getAddToMiddleOfList() {
		return addToMiddleOfList;
	}
	public void setAddToMiddleOfList(Long addToMiddleOfList) {
		this.addToMiddleOfList = addToMiddleOfList;
	}
	public Long getAddToEndOfList() {
		return addToEndOfList;
	}
	public void setAddToEndOfList(Long addToEndOfList) {
		this.addToEndOfList = addToEndOfList;
	}
	public Long getDelFromFrontOfList() {
		return delFromFrontOfList;
	}
	public void setDelFromFrontOfList(Long delFromFrontOfList) {
		this.delFromFrontOfList = delFromFrontOfList;
	}
	public Long getDelFromMiddleOfList() {
		return delFromMiddleOfList;
	}
	public void setDelFromMiddleOfList(Long delFromMiddleOfList) {
		this.delFromMiddleOfList = delFromMiddleOfList;
	}
	public Long getDelFromEndOfList() {
		return delFromEndOfList;
	}
	public void setDelFromEndOfList(Long delFromEndOfList) {
		this.delFromEndOfList = delFromEndOfList;
	}
	@Override
	public String toString() {
		DecimalFormat frmt = new DecimalFormat("0.##E0", DecimalFormatSymbols.getInstance(Locale.getDefault()));
		return "addToFrontOfList=" + frmt.format(addToFrontOfList.intValue()) + ", addToMiddleOfList=" + frmt.format(addToMiddleOfList.intValue()) + ", addToEndOfList="
				+ frmt.format(addToEndOfList.intValue()) + ", delFromFrontOfList=" + frmt.format(delFromFrontOfList.intValue()) + ", delFromMiddleOfList="
				+ frmt.format(delFromMiddleOfList.intValue()) + ", delFromEndOfList=" + frmt.format(delFromEndOfList.intValue());
	}
	/*@Override
	public String toString() {
		return "addToFrontOfList=" + addToFrontOfList + ", addToMiddleOfList=" + addToMiddleOfList + ", addToEndOfList="
				+ addToEndOfList + ", delFromFrontOfList=" + delFromFrontOfList + ", delFromMiddleOfList="
				+ delFromMiddleOfList + ", delFromEndOfList=" + delFromEndOfList;
	}*/
	
	

}
